package com.zrx.utils;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try{
            date = simpleDateFormat.parse(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
