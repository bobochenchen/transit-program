package com.example.transitprogram.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.transitprogram.dto.RkrltDTO;
import com.example.transitprogram.service.RkrltService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/transit")
public class TransitController {
    @Resource
    RkrltService rkrltService;

    @PostMapping("/rkrlt")
    public JSONObject transitRkrlt(@RequestBody RkrltDTO rkrltDTO){
        System.out.println(rkrltDTO.toString());
        String baseUrl = rkrltDTO.getBaseUrl();
        String appKey = rkrltDTO.getAppKey();
        String method = rkrltDTO.getMethod();
        String service = rkrltDTO.getService();
        String appSercert = rkrltDTO.getAppSercert();
        HashMap<String, String> query = rkrltDTO.getQuery();

        Assert.isTrue((!StringUtils.isEmpty(baseUrl)&&!StringUtils.isEmpty(appKey)&&!StringUtils.isEmpty(method)&&!StringUtils.isEmpty(service)&&!StringUtils.isEmpty(appSercert)),"缺少必要参数！");

        try {
            JSONObject jsonObject = rkrltService.transitRkrlt(baseUrl, appKey, appSercert, service, method, query);
            return jsonObject;
        }catch (Exception e){
            System.out.println("exception");
            return JSONObject.parseObject(e.getMessage());
        }
    }
}