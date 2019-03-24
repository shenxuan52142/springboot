package com.shenxuan.springboot.fb;

import com.shenxuan.springboot.bean.FeedBackVo;
import org.springframework.beans.factory.FactoryBean;

import java.util.Arrays;
import java.util.List;

public class FeedBackVoFactoryBean implements FactoryBean<FeedBackVo> {
    private String feedBackVoInfo;

    public String getFeedBackVoInfo() {
        return feedBackVoInfo;
    }
    public void setFeedBackVoInfo(String feedBackVoInfo){
        this.feedBackVoInfo = feedBackVoInfo;
    }

    @Override
    public FeedBackVo getObject() throws Exception {
        FeedBackVo feedBackVo=new FeedBackVo();
        String[] infos = feedBackVoInfo.split(",");
        feedBackVo.setSex(infos[0]);
        feedBackVo.setAge(Integer.parseInt(infos[1]));
        feedBackVo.setName(infos[2]);
        return feedBackVo;
    }

    @Override
    public Class<?> getObjectType() {
        return FeedBackVo.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
