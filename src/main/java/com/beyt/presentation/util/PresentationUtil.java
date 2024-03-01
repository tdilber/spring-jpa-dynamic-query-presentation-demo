package com.beyt.presentation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Objects;

public class PresentationUtil {

    @SneakyThrows
    public static void prettyPrint(Object object) {
        var objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
    }
}
