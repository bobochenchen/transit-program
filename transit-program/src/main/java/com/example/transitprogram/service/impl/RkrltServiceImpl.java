package com.example.transitprogram.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.example.transitprogram.service.RkrltService;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

@Service
public class RkrltServiceImpl implements RkrltService {
    private static final String JOIN = "_";

    @Override
    public JSONObject transitRkrlt(String baseUrl, String AppKey, String AppSercert, String Service, String Method ,HashMap query) {

        HashMap<String,String> params=new HashMap();

        /**
         * params参数，接口请求参数
         */
//        HashMap<String,String> query=new HashMap();
        //query.put("uuid","12");
        String queryparam=JSON.toJSONString(query);

        Long timestamp= LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()/1000;
        System.out.println("timestamp"+timestamp);
        params.put("appKey",AppKey);
        params.put("method",Method);
        params.put("service",Service);
        params.put("timestamp",timestamp.toString());
        params.put("params",queryparam);

        String sign = createSign(queryparam,AppKey,AppSercert,Service,Method,timestamp);

        System.out.println("sign");
        System.out.println(sign);
        params.put("sign",sign);

        String url=baseUrl+"?appKey="+ params.get("appKey")+"&method="+params.get("method")+"&service="+params.get("service")
                +"&timestamp="+timestamp+"&sign="+params.get("sign");
        System.out.println("url:  "+url);
        System.out.println("parms "+params.toString());


        String result = HttpRequest.post(url)
                .header("Accept", "*")
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(JSON.toJSONString(query))//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();

        System.out.println("result "+result);
        return JSONObject.parseObject(result);
    }

    /**
     * 计算sign值
     * @param params
     * @param service
     * @param method
     * @param timestamp
     * @return
     */
    private static String createSign(String params, String AppKey,String AppSercert,String service, String method, Long timestamp) {
        System.out.println("AppSercert"+AppSercert);
        // 以下是系统级约定的url参数
        StringBuilder sb = new StringBuilder();
        sb.append("appKey").append(AppKey).append(JOIN);
        sb.append("method").append(method).append(JOIN);
        sb.append("service").append(service).append(JOIN);
        sb.append("timestamp").append(timestamp).append(JOIN);
        if (params!=null){
            sb.append(params);
        }
        sb.append("@");
        sb.append(AppSercert);

        String str = sb.toString();
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        System.out.println("md5str   "+str);
        System.out.println("md5     "+md5);

        return md5;
    }
}
