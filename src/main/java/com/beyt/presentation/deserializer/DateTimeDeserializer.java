package com.beyt.presentation.deserializer;

import com.beyt.jdq.deserializer.BasicDeserializer;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateTimeDeserializer extends BasicDeserializer {

    @Override
    public <T> T deserialize(Object value, Class<T> clazz) throws Exception {
        if (clazz.isAssignableFrom(java.util.Date.class)) {
            if (value instanceof Date date) {
                return (T) date;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
            return  (T)  simpleDateFormat.parse(value.toString());
        }

        return super.deserialize(value, clazz);
    }
}
