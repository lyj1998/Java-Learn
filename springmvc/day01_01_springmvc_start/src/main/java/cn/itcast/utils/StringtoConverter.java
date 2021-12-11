package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("请您传入数据");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return  df.parse(s);
        }catch (Exception e){
            throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
