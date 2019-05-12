package com.shenxuan.springboot.gupiao;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shenxuan.springboot.IO.Use.TextFile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

public class Money {
    public static void getAllGupiao() {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = "https://xueqiu.com/stock/forchartk/stocklist.json";
        //cookie
        HttpHeaders headers = new HttpHeaders();
        List<String> cookieList = new ArrayList<String>();
        String cookie = "aliyungf_tc=AQAAABOjnjPFRQoAQ+PY3eSUpCbyyrUj; " +
                "xq_a_token=62c76bcb2dcc3aa55d754d345301ac59fbd80d07; " +
                "xq_a_token.sig=xanpxAxk9je8vsUD96Nzp5ZDpWE; " +
                "xq_r_token=7adaa5963ce67bef34ec03e13ffae599835fa351; " +
                "xq_r_token.sig=pP1yd0wp1nq2Ua_6Sl4lXmLql9g";
        cookieList = Arrays.asList(cookie.split("; "));
        headers.put(HttpHeaders.COOKIE, cookieList);
        //请求参数
        //当前时间戳
        String var1 = TextFile.read("C:\\Users\\Administrator\\Desktop\\gupiaozuixin\\allgupiao.txt");
        List<String> list = Arrays.asList(var1.split(","));
        JSONArray allGupiao = new JSONArray();
        JSONArray goodGupiao = new JSONArray();
        List<String> goodGupiaoDaiMa = new ArrayList<>();
        for (String s : list) {
            long nowTime = System.currentTimeMillis();
            MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();//参数放入一个map中，restTemplate不能用hashMap
            //将请求参数放入map中
            param.add("symbol", s);
            param.add("period", "1day");
            param.add("type", "before");
            param.add("begin", "1557244800000");
            param.add("end", String.valueOf(nowTime));
            param.add("_", String.valueOf(nowTime));
            //System.out.println("参数内容为：" + param.toString());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(param, headers);//将参数和header组成一个请求
            JSONObject jsonObject = restTemplate.postForEntity(requestUrl, request, JSONObject.class).getBody();
            JSONArray jsonArray = jsonObject.getJSONArray("chartlist");
            //获取前一天0点的时间戳
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH) - 2,
                    0, 0, 0);
            long beforeDay = calendar.getTimeInMillis() - 900;

            for (int j = 0; j < jsonArray.size(); j++) {
                Gupiao gupiao = JSONObject.parseObject(jsonArray.getJSONObject(j).toJSONString(), Gupiao.class);
                if (beforeDay < gupiao.getTimestamp()) {
                    gupiao.setDaima(s);
                    allGupiao.add(gupiao);
                    if (yiYangChuanSanXian(gupiao)) {
                        goodGupiao.add(gupiao);
                        goodGupiaoDaiMa.add(gupiao.getDaima());
                    }
                }
            }

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = simpleDateFormat.format(new Date());
        TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiaozuixin\\" + now + "_juti.out", allGupiao.toJSONString());
        TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiaozuixin\\" + now + "zhiDeMaiDaiMa.out", String.join(",", goodGupiaoDaiMa));
        TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiaozuixin\\" + now + "zhiDeMai.out",goodGupiao.toJSONString());
    }

    public static void main(String[] args) {
        getAllGupiao();
    }

    public static boolean yiYangChuanSanXian(Gupiao gupiao) {
        boolean result = false;
        if (compare(gupiao.getMa5(), gupiao.getMa10()) && compare(gupiao.getMa5(), gupiao.getMa20()) && compare(gupiao.getMa5(), gupiao.getMa30())) {
            result = true;
        }
        return result;
    }

    public static boolean compare(float a, float b) {
        boolean result = false;
        if (a / (a + b) > 0.4975 && a / (a + b) < 0.5025 && b / (a + b) > 0.4975 && b / (a + b) < 0.5025) {
            result = true;
        }
        return result;
    }
}
