package com.silence.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "testController", description = "測試")
@RequestMapping("/test")
@Controller
public class TestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @ResponseBody
    @RequestMapping(
            value = "addUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = String.class, notes = "add user")
    public String addUser(@ApiParam(required = true, name = "postData", value = "用户信息json数据") @RequestParam(
            value = "postData") String postData, HttpServletRequest request){
    	LOGGER.info("test Controller addUser mapping...");
    	return "123456";
    }
    
    @ResponseBody
    @ApiOperation(value = "获取书本内容", notes = "获取书本内容")
    @RequestMapping(value = "/getBookListByFilter", method = RequestMethod.POST)
    public String getBookListByFilter(HttpServletResponse response, HttpServletRequest request, @ApiParam(value = "机器序列号")
    @RequestParam(value = "machineId", required = true)
    String machineId, @ApiParam(value = "教材id")
    @RequestParam(value = "materialId", required = true)
    String materialId, @ApiParam(value = "用户id")
    @RequestParam(value = "accountId", required = false)
    String accountId, @ApiParam(value = "年级id")
    @RequestParam(value = "gradeId", required = true)
    String gradeId){
    	return "test";
    }
    
    @ResponseBody
    @ApiOperation(value = "test1", notes = "test1")
    @RequestMapping(value="/test1",method=RequestMethod.POST)
    public void test(){
    	LOGGER.info("123");
    }
    
    @ResponseBody
    @ApiOperation(value = "test2", notes = "test2")
    @RequestMapping(value="/test2",method=RequestMethod.POST)
    public void test1(){
    	LOGGER.info("123");
    }
}
