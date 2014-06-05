package com.easymda.util
 
import org.slf4j.LoggerFactory
import scala.slick.util.SlickLogger
  
trait Logger {
  lazy val logger = new SlickLogger(LoggerFactory.getLogger("reactive.ReactiveWebApp"))
}
