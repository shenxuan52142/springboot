package com.shenxuan.springboot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shenxuan.springboot.IO.Use.TextFile;
import com.shenxuan.springboot.collection.map.SimpleHashMap;
import com.shenxuan.springboot.gupiao.Gupiao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArraysUnsupported {

    @Test
    public void test1(){

        String gupiaodaima = TextFile.read("C:\\gupiao\\gupiaoID.out");
        List<String> gupiaodai = Arrays.asList(gupiaodaima.split(","));
        JSONArray allGuPiao = new JSONArray();
        JSONArray mayBeGuPiao = new JSONArray();
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("https://xueqiu.com");
        String respone = restTemplate.getForObject(uri, String.class);
        for (String s:gupiaodai){


//        System.out.println(respone);
            URI uri1 = URI.create("https://xueqiu.com/stock/forchartk/stocklist.json?");
            MultiValueMap<String,String> param = new LinkedMultiValueMap<String, String>();//参数放入一个map中，restTemplate不能用hashMap
            //将请求参数放入map中
            long time = System.currentTimeMillis();
            param.add("symbol",s);
            param.add("period","1day");
            param.add("type","before");
            param.add("begin","1557331200000");
            param.add("end",String.valueOf(time));
            param.add("_",String.valueOf(time));
            String var22 = "aliyungf_tc=AQAAADveI2JpzgcADwNo3yJ9W3JFXx6c; xq_a_token=62c76bcb2dcc3aa55d754d345301ac59fbd80d07; xq_a_token.sig=xanpxAxk9je8vsUD96Nzp5ZDpWE; xq_r_token=7adaa5963ce67bef34ec03e13ffae599835fa351; xq_r_token.sig=pP1yd0wp1nq2Ua_6Sl4lXmLql9g";
            List<String> stringList = Arrays.asList("; ", var22);
//        System.out.println(stringList);
            HttpHeaders headers = new HttpHeaders();
            headers.put(HttpHeaders.COOKIE,stringList);
            HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<MultiValueMap<String,String>>(param,headers);
            JSONObject jsonObject = restTemplate.postForEntity(uri1,request, JSONObject.class).getBody();
//        JSONObject jsonObject = JSONObject.parseObject(response222.toString());
//        System.out.println(jsonObject.getString("chartlist"));
            JSONArray jsonArray = jsonObject.getJSONArray("chartlist");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)-1,
                    0,
                    0,
                    0);

            long dayBefore = calendar.getTimeInMillis();
            for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Gupiao gupiao = JSONObject.parseObject(jsonObject1.toJSONString(), Gupiao.class);
                gupiao.getTimestamp();
                if (gupiao.getTimestamp()>dayBefore){
                    allGuPiao.add(gupiao);
                    if (Money.yiYangChuanSanXian(gupiao)) {
                        mayBeGuPiao.add(gupiao);
                        String fileName = "C:\\Users\\Administrator\\Desktop\\";
                        TextFile.write(fileName+s+".out",JSONObject.toJSONString(gupiao));
                    }
                }
            }
            int i=1;
            i = i++;
            System.out.println(i);
        }

        TextFile.write("C:\\Users\\Administrator\\Desktop\\suoyou.out",allGuPiao.toJSONString());
        TextFile.write("C:\\Users\\Administrator\\Desktop\\MayBe.out",mayBeGuPiao.toJSONString());


    }
    @Test
    public void test2(){

        String var = TextFile.read("C:\\Users\\Administrator\\Desktop\\gupiao7.out");
        JSONArray jsonArray = JSONArray.parseArray(var);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)-1,
                0,
                0,
                0);

        long dayBefore = calendar.getTimeInMillis();
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            Gupiao gupiao = JSONObject.parseObject(jsonObject1.toJSONString(), Gupiao.class);
            gupiao.getTimestamp();
            if (gupiao.getTimestamp()>dayBefore){
                jsonArray1.add(gupiao);
            }
        }
        TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiao9.out", jsonArray1.toJSONString());
    }
    @Test
    public void test3(){
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("2", "@B");
        map.get("3");
    }
    @Test
    public void test4(){
        String var1 = new String("hello").intern();
        String[] strings="hello hello".split(" ");
        System.out.println(strings[0].hashCode());
        System.out.println(strings[1].hashCode());
        System.out.println(strings[0]==strings[1]);

        System.out.println(var1.hashCode());
        System.out.println(var1==strings[1]);
        System.out.println(var1==strings[0]);
    }
}
