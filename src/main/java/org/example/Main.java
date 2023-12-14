package org.example;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int status=500;
        int s=404;
        int ss=400;
        String responseContent="{ \"data\": \"NO_RATING_POSSIBLE\" }";
        try{
            if (status == 404) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseContent.toString());
                if (jsonNode.has("data")) {
                    String quoteStatus = jsonNode.get("data").asText();
                    throw new RuntimeException("Error while executing the Jarvis response " + quoteStatus);
                }
            }else if(status==400){
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseContent.toString());
                if (jsonNode.has("data")) {
                    String quoteStatus = jsonNode.get("data").asText();
                    throw new RuntimeException("Error while executing the Jarvis response " + quoteStatus);
                }
            }
            else{
                throw new RuntimeException("Error while executing the Jarvis response status except 400 and 404");
            }
        }catch(Exception e){
            LOGGER.info(""+e.getMessage());
        }
    }
}
