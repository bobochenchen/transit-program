package com.example.transitprogram;

import lombok.Data;

import java.util.HashMap;

@Data
public class RkrltDTO {
    private String baseUrl;
    private String appKey;
    private String appSercert;
    private String service;
    private String method;
    private HashMap<String,String> query;
}
