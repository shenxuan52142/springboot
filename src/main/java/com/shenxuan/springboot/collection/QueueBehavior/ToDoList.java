package com.shenxuan.springboot.collection.QueueBehavior;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(char primary,int secondary,String item){
           this.primary=primary;
           this.secondary=secondary;
           this.item=item;
        }
        @Override
        public int compareTo(ToDoItem arg) {
            if (primary >arg.primary){
                return +1;
            }
            if (primary==arg.primary){
                if (secondary>arg.secondary){
                    return +1;
                }else if (secondary==arg.secondary){
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary)+secondary+": "+item;
        }
    }
   public void add(String it,char pri,int sec){
       super.add(new ToDoItem(pri, sec, it));
   }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.im.group.taikang.com/api/v1/message/sync?identify=EE5WRI0hiLLxtQJMKKmngNjlQXMQ&deviceType=0";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aW1lU3RhbXAiOjE1NTc3MzIxODM4NDksInN1YiI6IkVFNVdSSTBoaUxMeHRRSk1LS21uZ05qbFFYTVEiLCJyYXdUeXBlIjowLCJhcHBJZCI6InNpNjRkMzU3OTUwNTM4NmMzNSJ9.hPuvhKcdBMUcE2aYM7L5Q6k8mzgkVK6P7YiK9JHeIfk");
        httpHeaders.add("accept", "application/json");
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("identify","EE5WRI0hiLLxtQJMKKmngNjlQXMQ");
        param.add("deviceType", "0");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null, httpHeaders);
        ResponseEntity<String> responseBody = restTemplate.exchange(url, HttpMethod.GET,request,String.class);
        responseBody.getStatusCode();
    }
}
