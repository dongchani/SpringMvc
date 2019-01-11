package com.Web.format;

import com.commons.entity.Ponit;
import com.commons.entity.User;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class TestFormat implements Formatter<Ponit> {
    @Override
    public Ponit parse(String text, Locale locale) throws ParseException {
        System.out.println(text);
        Ponit ponit = new Ponit();
        String [] result = text.split(",");
        if (result!=null&&result.length==2){
            String x=result[0];
            String y=result[1];
            ponit.setX(Integer.parseInt(x));
            ponit.setY(Integer.parseInt(y));
        }
        return ponit;
    }

    @Override
    public String print(Ponit object, Locale locale) {
        return object.getX()+","+object.getY();
    }
}
