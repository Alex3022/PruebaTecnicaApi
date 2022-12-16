package co.com.sofka.utils;


import java.util.HashMap;
import java.util.Map;

import static co.com.sofka.utils.PropertiesManager.getValue;

public class Constants {

    private Constants() {throw new IllegalStateException("Utility class");}


    public static String getAPIUrl(String api)
    {
        if ("url".equals(api)) {
            return getValue("url");
        }
        throw new TestFailure("Fallo seleccionando api");
    }

    public static Map<String, String> getHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put("contentType", getValue("contentType"));


        return headers;
    }

}
