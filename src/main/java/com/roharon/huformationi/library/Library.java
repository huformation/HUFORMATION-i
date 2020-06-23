package com.roharon.huformationi.library;

import com.google.gson.Gson;
import com.roharon.huformationi.domain.user.User.Campus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements LibraryData {

    private String sourceUrl;

    public Library(Campus campus){
        if(campus.equals(Campus.seoul)){
            this.sourceUrl = seoulUrl;
        }
        else {
            this.sourceUrl = globalUrl;
        }
    }

    public List<Map<String, Object>> process(){
        try{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(this.sourceUrl);
            getRequest.addHeader("content-type", "application/json");

            HttpResponse response = client.execute(getRequest);

            if(response.getStatusLine().getStatusCode() == 200){
                String json = EntityUtils.toString(response.getEntity(), "UTF-8");
                Gson gson = new Gson();
                Map map = new HashMap();

                map = gson.fromJson(json, map.getClass());
                map = (Map) map.get("data");

                return (List<Map<String, Object>>) map.get("list");
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            return null;
        }
    }
}
