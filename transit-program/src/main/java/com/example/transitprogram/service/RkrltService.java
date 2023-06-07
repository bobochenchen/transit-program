package com.example.transitprogram.service;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public interface RkrltService {
    JSONObject transitRkrlt(String baseUrl, String AppKey, String AppSercert, String Service, String Method, HashMap query);
}
