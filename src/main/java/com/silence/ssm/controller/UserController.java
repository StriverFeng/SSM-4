package com.silence.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silence.ssm.entity.User;
import com.silence.ssm.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "userController", description = "用户信息")
@RequestMapping("/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;
		
	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	@ApiOperation(value = "添加用户", httpMethod = "POST", response = String.class, notes = "add user")
	public String addUser(
			@ApiParam(required = true, name = "username", value = "用户名") @RequestParam(value = "username") String username,
			@ApiParam(required = true, name = "password", value = "密码") @RequestParam(value = "password") String password,
			@ApiParam(required = true, name = "phone", value = "电话") @RequestParam(value = "phone") String phone,
			@ApiParam(required = true, name = "image", value = "照片") @RequestParam(value = "image") String image,
			@ApiParam(required = true, name = "info", value = "其他信息") @RequestParam(value = "info") String info,
			HttpServletRequest request) {
		userService.addUser(new User(username, password, phone, image, info, new Date()));
		return "Add SuccessFul";
	}
	
	@ResponseBody
	@RequestMapping(value = "queryUserById", method = RequestMethod.GET)
	@ApiOperation(value = "添加用户", httpMethod = "GET", response = User.class, notes = "query user")
	public User queryUserById(
			@ApiParam(required = true, name = "id", value = "id") @RequestParam(value = "id") Integer id,
			HttpServletRequest request) {
		logger.info("query user " + id);
		return userService.findUserById(id);
	}
}
