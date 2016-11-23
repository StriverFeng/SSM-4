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
import com.silence.ssm.service.UserService

@Api(value = "ScalaController", description = "测试scala")
@Controller
@RequestMapping(value=Array {"/scala"})
class Test1 @Autowired()(scalaTestService:ScalaTestService,userService:UserService){
  
  @ResponseBody
  @ApiOperation(value = "scalaWordCount", httpMethod = "POST", notes = "scalaWordCount")
  @RequestMapping(value=Array{"/scalaWordCount"},method=Array{RequestMethod.POST})
  def scalaWorkCount(@ApiParam(required = true, name = "line", value = "给定的字符串") @RequestParam(value = "line") line:String,
      @ApiParam(required = true, name = "pattern", value = "分隔符") @RequestParam(value = "pattern") pattern:String):String = {
    scalaTestService.wordcount(line, pattern)
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
  def test3(@ApiParam(required = true, name = "id", value = "用户id") @RequestParam(value = "id") id:Int):String = {
     println(scalaTestService.execute(id+""))
    "this is scala controller test"
  }
   
  @ResponseBody
  @ApiOperation(value = "scala userService", httpMethod = "GET", notes = "test userService in scala")
  @RequestMapping(value=Array{"/getUserById"},method=Array{RequestMethod.GET})
  def getUserById(@ApiParam(required = true, name = "id", value = "用户id") @RequestParam(value = "id") id:Int):String = {
     println(scalaTestService.execute(id+""))
    "this is scala controller test"
  }
    
}