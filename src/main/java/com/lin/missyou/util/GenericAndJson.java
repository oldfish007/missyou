package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericAndJson {

    private static ObjectMapper mapper;

    /**
     * 相当于把objectMapper实例化了之后注入到一个方法里面，然后在通过方法是赋值给类变量
     * @param mapper
     */
    @Autowired
    public void setMapper(ObjectMapper mapper){
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o){
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    /**
     * 把List<T> 整体看成是一个泛型T
     * 原因 TypeReference 是可以获取到数组类型的泛型的参数
     * @param s
     * @param tr
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String s, TypeReference<T> tr){
        try {
            if(s==null){
                return null;
            }
            T o = GenericAndJson.mapper.readValue(s, tr);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
/**
 * 把List<T>中的T 看成是一个泛型
 */
//    public static <T> List<T> jsonToList(String str){
//        if(str==null){
//            return null;
//        }
//        try {
//            List<T> list = GenericAndJson.mapper.readValue(str, new TypeReference<List<T>>() {
//            });
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }
///**
// * 把list<T> 当成整体
// */
//    public static <T> T jsonToList(String s,TypeReference<T> tr){
//        if(s==null){
//            return null;
//        }
//        try {
//            T list = GenericAndJson.mapper.readValue(s, tr);
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }

}
