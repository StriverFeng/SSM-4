package com.silence.ssm.scala.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import com.wordnik.swagger.annotations.Api
import org.springframework.web.bind.annotation.ResponseBody
import com.wordnik.swagger.annotations.ApiOperation

@Api(value = "testScalaController", description = "测试scala")
@Controller
@RequestMapping(value=Array {"/testScalaController"})
class Test1 {
  
  @ResponseBody
  @RequestMapping(value=Array {"test"},method=Array{RequestMethod.GET})
  @ApiOperation(value = "测试Scala", httpMethod = "GET", notes = "test Scala")
  def testScalaController():String = {
    println("this is scala controller test")
    "this is scala controller test"
  }
}