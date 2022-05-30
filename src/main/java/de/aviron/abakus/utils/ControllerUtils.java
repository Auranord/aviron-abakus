package de.aviron.abakus.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ControllerUtils {
    

    // url: http://bbbbbbbbcccccvvvvvvv?key1=x,y,z&key2=y,z&key3=z
    // return: {"key1": "x,y,z", "key2": "y,z", "key3": "z",}
    public static Map<String, String> getKeysFromUrl(String url) {
        String [] pairs = url.split("\\?")[1].split(("&"));
        Map<String, String> map = new HashMap<>();

        for (String pair : pairs) {
            if(pair.contains("=")){
                String [] result = pair.split("=");

                String key = result[0];

                String value = result[1];
                if(!map.containsKey(key)){
                    map.put(key, value);
                }
            }
        }

        return map;
    }
    

    // url: http://bbbbbbbbcccccvvvvvvv?key1=x,y,z;key2=y,z;key3=z  / key: "key2"
    // return: {"y", "z"}
    public static List<String> getFieldsFromKey(String url, String key) {

        Map<String,String> map = getKeysFromUrl(url);
        ArrayList<String> list = new ArrayList<String>();
        
        if(map.containsKey(key)){
            String [] values = map.get(key).split(",");
            for (String value : values) {
                list.add(value);
            }
        }

        return list;
    }

    // jsonObject: "{ name: x, email: y, time: z}"  /  fields: { "name", "email" }
    // return: "{ name: x, email: y}"
    public static ObjectNode getFieldsFromJson(ObjectNode jsonObject, List<String> fields) {
        for (String field : fields) {
            jsonObject.remove(field);
        }
        return jsonObject;
    }

}
