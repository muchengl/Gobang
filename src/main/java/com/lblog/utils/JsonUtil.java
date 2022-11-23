package com.lblog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtil {
    public static String getJson(Object object,String sdf) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        //mapper.configure(Serializa)
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(sdf);
        mapper.setDateFormat(simpleDateFormat);

        return mapper.writeValueAsString(object);
    }
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"YYYY-mm-dd hh-mm-ss");
    }
//    public static String getJson(String key,String row){
//        JSONObject object = new JSONObject();
//        return object.put(key,row).toString();
//    }

}
