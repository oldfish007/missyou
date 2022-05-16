package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
@Converter
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {
    @Autowired
    private ObjectMapper mapper;

        /**
         * entity属性向database转换这样一个过程
         * @param stringObjectMap
         * @return
         */
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {

        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }

    /**
     * 把数据库字段反向转换成entity属性的过程
     * 跟前端没关系的异常主要是记录日志，把具体的错误信息告诉前端
     * 第一次报500 服务器端异常  是由于id为1的spu有两个
     * @param s
     * @return
     */
    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return mapper.readValue(s, HashedMap.class);
        } catch (Exception e) { //建议还是写能够确定的异常
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
