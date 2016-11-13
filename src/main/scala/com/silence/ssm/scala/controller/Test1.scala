package com.silence.ssm.scala.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import com.wordnik.swagger.annotations.Api
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestParam
import com.wordnik.swagger.annotations.ApiOperation
import com.silence.ssm.scala.service.ScalaTestService
import com.wordnik.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired

@Api(value = "ScalaController", description = "测试scala")
@Controller
@RequestMapping(value=Array {"/scala"})
class Test1 @Autowired()(scalaTestService:ScalaTestService){
  
  @ResponseBody
  @ApiOperation(value = "测试Scala1", httpMethod = "GET", notes = "testScala1")
  @RequestMapping(value=Array{"/test1"},method=Array{RequestMethod.GET})
  def test1(@ApiParam(required = true, name = "name", value = "用户姓名") @RequestParam(value = "name") name:String):String = {
     println(scalaTestService.execute("value"))
    "this is scala controller test"
  }
  
  @ResponseBody
  @ApiOperation(value = "测试Scala2", httpMethod = "POST", notes = "testScala2")
  @RequestMapping(value=Array{"/test2"},method=Array{RequestMethod.POST})
  def test2(@ApiParam(required = true, name = "name", value = "用户姓名") @RequestParam(value = "name") name:String):String = {
     println(scalaTestService.execute("value"))
    "this is scala controller test"
  }
  
  @ResponseBody
  @ApiOperation(value = "测试Scala3", httpMethod = "DELETE", notes = "testScala3")
  @RequestMapping(value=Array{"/test3"},method=Array{RequestMethod.DELETE})
  def test3(@ApiParam(required = true, name = "name", value = "用户姓名") @RequestParam(value = "name") name:String):String = {
     println(scalaTestService.execute("value"))
    "this is scala controller test"
  }
    
}