package de.htwBerlin.ai.inews.data

import com.sksamuel.elastic4s.{Hit, HitReader}
import de.htwBerlin.ai.inews.core.Article.Article
import org.joda.time.DateTime

import scala.util.Try

object ArticleHitReader extends HitReader[Article] {
  override def read(hit: Hit): Try[Article] = {
    Try(Article(
      hit.id,
      hit.sourceAsMap.getOrElse("authors", Seq()) match {
        case authors if authors == null => Seq()
        case authors => authors.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("crawlTime", 0) match {
        case time: String => DateTime.parse(time).getMillis
        case _ => 0
      },
      hit.sourceAsMap.getOrElse("departments", Seq()) match {
        case departments if departments == null => Seq()
        case departments => departments.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("description", "") match {
        case description: String => description
        case _ => ""
      },
      hit.sourceAsMap.getOrElse("imageLinks", Seq()) match {
        case imageLinks if imageLinks == null => Seq()
        case imageLinks => imageLinks.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("intro", "") match {
        case intro: String => intro
        case _ => ""
      },
      hit.sourceAsMap.getOrElse("keywords", Seq()) match {
        case keywords if keywords == null => Seq()
        case keywords => keywords.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("lemmas", Seq()) match {
        case lemmas if lemmas == null => Seq()
        case lemmas => lemmas.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("links", Seq()) match {
        case links if links == null => Seq()
        case links => links.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("longUrl", "") match {
        case longUrl: String => longUrl
        case _ => ""
      },
      hit.sourceAsMap.getOrElse("mostRelevantLemmas", Seq()) match {
        case mostRelevantLemmas if mostRelevantLemmas == null => Seq()
        case mostRelevantLemmas => mostRelevantLemmas.asInstanceOf[List[String]]
      },
      hit.sourceAsMap.getOrElse("newsSite", "") match {
        case newsSite: String => newsSite
        case _ => ""
      },
      hit.sourceAsMap.getOrElse("publishedTime", 0) match {
        case time: String => DateTime.parse(time).getMillis
        case _ => 0
      },
      hit.sourceAsMap.getOrElse("readingTime", 0) match {
        case readingTime: Int => readingTime
        case _ => 0
      },
      hit.sourceAsMap.getOrElse("text", "") match {
        case text: String => text
        case _ => ""
      },
      hit.sourceAsMap.getOrElse("title", "") match {
        case title: String => title
        case _ => ""
      }
    ))
  }
}
