package com.shenxuan.springboot;

import com.alibaba.fastjson.JSONObject;
import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.Transaction.ServiceA;
import com.shenxuan.springboot.aop.ForumService;
import com.shenxuan.springboot.aop.ForumServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Autowired
    ServiceA serviceA;
}
