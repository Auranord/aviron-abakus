package de.aviron.abakus.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.aviron.abakus.security.JwtTokenProvider;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ControllerUtils {
    
    private JwtTokenProvider jwtTokenProvider;
    
    public String getTokenFromAuthorization(String authorization) {

        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer "))
            authorization = authorization.substring(7);

        return authorization;
    }

    public String getEmailFromToken(String token) {

        return jwtTokenProvider.getUserMailFromToken(token);
    }
    
    public static List<String> getFieldsFromString(String fields) {

        ArrayList<String> list = new ArrayList<String>();
        String [] values = fields.split(",");

        for (String value : values) {
            list.add(value);
        }

        return list;
    }

    public static Object updateObject(Object object, ObjectNode objectNode) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerForUpdating(object);

        return objectReader.readValue(objectNode);
    }

    public static ObjectNode getFieldsFromObject(Object object) {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.valueToTree(object);

        return objectNode;
    }

    public static ObjectNode getFieldsFromObject(Object object, List<String> fields) {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode returnNode = objectMapper.createObjectNode();
        ObjectNode objectNode = objectMapper.valueToTree(object);

        for (String field : fields) {
            returnNode.set(field, objectNode.get(field));
        }

        return returnNode;
    }

    public static List<ObjectNode> getFieldsFromObjects(List<?> objects) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ObjectNode> returnNodeList = new ArrayList<>();

        for (Object object : objects) {
            returnNodeList.add(objectMapper.valueToTree(object));
        }

        return returnNodeList;
    }

    public static List<ObjectNode> getFieldsFromObjects(List<?> objects, List<String> fields) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<ObjectNode> returnNodeList = new ArrayList<>();
        List<ObjectNode> objectNodeList = new ArrayList<>();

        for (Object object : objects) {
            returnNodeList.add(objectMapper.createObjectNode());
            objectNodeList.add(objectMapper.valueToTree(object));
        }

        for (int i = 0; i < objects.size(); i++) {
            for (String field : fields) {
                returnNodeList.get(i).set(field, objectNodeList.get(i).get(field)); 
            }
        }

        return returnNodeList;
    }

}
