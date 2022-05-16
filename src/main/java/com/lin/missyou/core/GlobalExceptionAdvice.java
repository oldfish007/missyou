package com.lin.missyou.core;

import com.lin.missyou.core.configuration.ExceptionCodeConfiguration;
import com.lin.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 发现机制一旦打上了@ControllerAdvice就知道是处理异常的标签 使用特定的注解
 *
 *
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
//接收方法中抛出的异常出来
    //把exception里面的信息组成成UnifyResponse的格式
    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    /**
     * 在处理未知异常
     * 未知异常的message会涉及到代码结构以及一些机密信息，对于未知异常即使你有message也不应该返回到前端去
     * 就好像产生了一个1/0的异常
     *
     * @param request
     * @param e
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req,Exception e){
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        //确保函数中能够接收到异常
        System.out.println(e);
        //url是要获取到当前访问的接口URL
        UnifyResponse message = new UnifyResponse(9999, "服务器异常", method + " "+ requestURI);
        //要把unifyResponse返回到前端去
        return message;
    }
    /**
     * 处理已知异常 已知异常严格来说是不能算异常的 就是消息
     * 通过异常的传递表达这种消息
     * 必须告诉前端
     * 对于已知异常
     * @param req
     * @param e
     */
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req,HttpException e){
        System.out.println("helloHttpException");
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        //message是怎么传到这个xxx里面去呢
        UnifyResponse message = new UnifyResponse(e.getCode(),codeConfiguration.getMessage(e.getCode()),method + " "+ requestURI);
        //以前有@ResponseBody springboot会自动添加header但是这个方法不用就需要手动设置
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message,headers,httpStatus);
        return  r;
    }
    /**
     * validate exception MethodArgumentNotValidException
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse ValidationException(HttpServletRequest req,MethodArgumentNotValidException e){
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        //从 excepiton里面得到message
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrorMessage(allErrors);
        //这个地方就没有必要返回ResponseEntity
        UnifyResponse response = new UnifyResponse(10001,message,method + " "+ requestURI);
        return response;
    }
    /**
     * 拼接error
     *
     */
     public String formatAllErrorMessage(List<ObjectError> allErrors){
         StringBuffer errorMsg = new StringBuffer();
         allErrors.forEach(error->
                         errorMsg.append(error.getDefaultMessage()).append(";")
                 );
         return errorMsg.toString();
     }

     //ConstraintViolationException
    @ExceptionHandler(value= ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintViolationException(HttpServletRequest req,ConstraintViolationException e){
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        //获取异常信息
        //Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        //ConstraintViolation 这个接口是很丰富的  如果需求比较细致可以用这个接口
       /* for (ConstraintViolation  error : constraintViolations) {
            ConstraintViolation a = error;
        }*/
        String message = e.getMessage();
        UnifyResponse unifyResponse = new UnifyResponse(10001,message,method + " "+ requestURI);
        return unifyResponse;
    }



}
