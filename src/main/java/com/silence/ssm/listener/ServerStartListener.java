package com.silence.ssm.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;

@Service
public class ServerStartListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private JedisPool jedisPool;
	
	private Logger logger = LoggerFactory.getLogger(ServerStartListener.class);
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
        //防止重复执行。
        if(event.getApplicationContext().getParent() == null){
        	if (jedisPool != null) {
        		logger.info("Redis Server is Running!");
    			Set<String> keys = jedisPool.getResource().keys("*");
        		for (String s : keys) {
        			logger.info("redis key:" + s);
        		}
        	}
        }
	}
	
}
