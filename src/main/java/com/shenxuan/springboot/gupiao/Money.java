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
        String requestUrl1 = "https://xueqiu.com";
        String var222 = restTemplate.getForObject(requestUrl1, String.class);
        HttpHeaders headers = new HttpHeaders();
        List<String> cookieList = new ArrayList<String>();
        String cookie = "aliyungf_tc=AQAAADveI2JpzgcADwNo3yJ9W3JFXx6c; xq_a_token=a9632c244e3abdabf5e69648484ace358f551cc2; xq_a_token.sig=Jts98RL77SW_icc7iqdEtUiImZc; xq_r_token=2963a1e5c3d6891a6abd22a0205a91b4e1f78967; xq_r_token.sig=Um9wCJ4pmQ3kt_DnEGLCO5ykd6I";
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
            try{
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
                    Gupiao gupiao = JSONObject.parseObject(jsonArray.getJSONObject(jsonArray.size()-1).toJSONString(), Gupiao.class);
                    if (beforeDay < gupiao.getTimestamp()) {
                        gupiao.setDaima(s);
                        allGupiao.add(gupiao);
                        if (yiYangChuanSanXian(gupiao)) {
                            goodGupiao.add(gupiao);
                            goodGupiaoDaiMa.add(gupiao.getDaima());
                            TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiaozuixin\\" + s + "_juti.out", JSONObject.toJSONString(gupiao));
                        }
                    }
                }

            }catch (Exception e){
                System.out.println(s);
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

        float now = (gupiao.getMa5()*5 + (float) gupiao.getClose())/6;
        float now10 = (gupiao.getMa10()*10 +(float) gupiao.getClose()) / 11;
        float now20 = (gupiao.getMa20() *20+ (float)gupiao.getClose()) / 21;
        if (compare(now, now10) && compare(now, now20)) {
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
