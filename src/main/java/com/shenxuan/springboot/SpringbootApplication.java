package com.shenxuan.springboot;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@SpringBootApplication(exclude= {MongoAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class SpringbootApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
   @RequestMapping(value = "/im/ceshi",method = RequestMethod.POST,produces  = "application/json;charset=UTF-8")
	public void ceshi(@RequestBody JSONObject jsonObject){

	   String var = "/usr/local/";
	   Date date = new Date(System.currentTimeMillis());
	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	   String date1 = simpleDateFormat.format(date);
	   String fileName = var+date1+".out";
	   try{
		   PrintWriter out = new PrintWriter(
				   new FileWriter(fileName)
		   );
		   try{
			   out.print(jsonObject.toJSONString());
		   }finally {
			   out.close();
		   }
	   }catch (IOException e){
		   throw new RuntimeException(e);
	   }
	}

}
