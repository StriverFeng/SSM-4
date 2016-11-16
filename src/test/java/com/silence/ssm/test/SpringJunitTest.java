package com.silence.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silence.ssm.entity.User;
import com.silence.ssm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringJunitTest {

	@Autowired private UserService userService;
	
	public void test() {
		int result = userService.addUser(new User("打哈", "nishifdfd", "1567989708", "/upload/tesdf.ong", "test", new Date()));
	}
}
