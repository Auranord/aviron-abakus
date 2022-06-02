package de.aviron.abakus.utils;

import java.time.Instant;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.aviron.abakus.enums.ErrorMessage;

public class ErrorProvider {
    
    public static ObjectNode getNode(ErrorMessage error) {

        ObjectNode errorNode = JsonNodeFactory.instance.objectNode();

        // TODO: api path

        errorNode.put("timestamp", Instant.now().getEpochSecond());
        errorNode.put("error", error.getError());
        errorNode.put("message", error.getErrorMessage());
        errorNode.put("path", "");

        return errorNode;        
    }


}
