package com.example.backend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataService {

    @Value("classpath:eureka-sample-response")
    Resource resourceFile;

    public JsonNode getData() throws IOException {
        final JsonNode fileData = getFileData();
        System.out.println("Data: " + fileData);
        return fileData;
    }

    private JsonNode getFileData() throws IOException {
        return new ObjectMapper().readTree(resourceFile.getFile());
    }
}