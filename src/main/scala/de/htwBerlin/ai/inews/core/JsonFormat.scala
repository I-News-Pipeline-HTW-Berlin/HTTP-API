package de.htwBerlin.ai.inews.core

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object JsonFormat extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val articleJsonFormat: RootJsonFormat[Article] =
  // the 8 stands for 8 parameters of class Article
    jsonFormat10(Article.apply)
}
