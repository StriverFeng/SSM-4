package com.silence.ssm.scala.service

import org.springframework.stereotype.Service
import scala.io.Source

@Service("scalaTestService")
class ScalaTestService {

  def execute(name: String): String = {
    "Scala test service module return data"
  }

  def wordcount(line:String, pattern:String): String = {
    //原始map
    val map = line.split(pattern)
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }
    val sortmap = map
      .toList //转成List排序
      //.filter(_._2 > 1) //过滤出数量大于指定数目的数据，这里是1
      .sortWith(_._2 > _._2); //根据value值进行降序排序,( 降序（_._2 > _._2）升序(_._2 < _._2) )
    for (pair <- sortmap) println(pair) //遍历Map，输出每一个kv对
    sortmap.toString()
  }
}