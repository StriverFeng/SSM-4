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
@RequestMapping(value=Array {"/testScalaController"})
class Test1 @Autowired()(scalaTestService:ScalaTestService){
  
  @ResponseBody
  @ApiOperation(value = "测试Scala", httpMethod = "GET", notes = "testScala")
  @RequestMapping(value=Array{"/test"},method=Array{RequestMethod.GET})
  def test(@ApiParam(required = true, name = "name", value = "用户姓名") @RequestParam(
            value = "postData") name:String):String = {
     println(scalaTestService.execute("value"))
    "this is scala controller test"
  }
}