package de.aviron.abakus.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerUtils {
    
    // url: http://bbbbbbbbcccccvvvvvvv?key1=x,y,z;key2=y,z;key3=z
    // return: {"key1": "x,y,z", "key2": "y,z", "key3": "z",}
    public static Map<String, String> getKeysFromUrl(String url) {

        // TODO

        return new HashMap<String, String>();
    }

    // url: http://bbbbbbbbcccccvvvvvvv?key1=x,y,z;key2=y,z;key3=z  / key: "key2"
    // return: {"y", "z"}
    public static List<String> getFieldsFromKey(String url, String key) {

        // TODO

         return new ArrayList<String>();
    }

    // jsonObject: "{ name: x, email: y, time: z}"  /  field: "email"
    // return: "{ name: x, time: z}
    public static String removeFieldFromJson(String jsonObject, String field) {

        // TODO

        return jsonObject;
    }

    // jsonObject: "{ name: x, email: y, time: z}"  /  fields: { "name", "email" }
    // return: "{ name: x, email: y}"
    public static String getFieldsFromJson(String jsonObject, List<String> fields) {

        // TODO

        return jsonObject;
    }

}
