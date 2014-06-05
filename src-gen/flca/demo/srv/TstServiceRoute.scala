 
/*
 * Generated via the com.flca generator
 */
	
package flca.demo.srv
	
import akka.actor.ActorRef
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import com.easymda.util.CreationSupport
import com.easymda.util.JsonUtils
import com.easymda.util.Logger
import flca.demo.dto.TstDto
import flca.demo.entity.Tsta
import flca.demo.srv.TstServiceActor._
import org.json4s._
import org.json4s.native.JsonMethods._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.util.Failure
import scala.util.Success
import spray.http._
import spray.httpx.Json4sSupport
import spray.httpx.SprayJsonSupport._
import spray.routing._
trait TstServiceRoute extends HttpService with CreationSupport with Json4sSupport with Logger {
  
  implicit def executionContext: ExecutionContext
  
  private val tstServiceActor = createChild(TstServiceActor.props, TstServiceActor.name)
  
    val helloWorldRoute: Route = path("helloWorld") {get {handleHelloWorld()} }
    val pingMeRoute: Route = path("pingMe") {get {handlePingMe()} }
    val saveTestARoute: Route = path("saveTestA") {get {handleSaveTestA()} }
    val searchTestARoute: Route = path("searchTestA") {get {handleSearchTestA()} }
    val getDtoRoute: Route = path("getDto") {get {handleGetDto()} }
    val pingRoute: Route = path("ping") {get {handlePing()} }
    val doSomethingRoute: Route = path("doSomething") {get {handleDoSomething()} }
    
  def handleHelloWorld() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handleHelloWorld ...")
      implicit val timeout = Timeout(30 seconds)
      val futureResponse = tstServiceActor.ask(HelloWorldReq).mapTo[HelloWorldRes]
      onComplete(futureResponse) {
        case Success(HelloWorldRes(value)) => complete(JsonUtils.toJson(value))
        case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
      }
    }
  }
  
  def handlePingMe() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handlePingMe ...")
      implicit val timeout = Timeout(30 seconds)
      entity(as[PingMeReq]) { req =>
        val futureResponse = tstServiceActor.ask(PingMeReq(req.aMessage1,req.aMessage2)).mapTo[PingMeRes]
        onComplete(futureResponse) {
          case Success(PingMeRes(value)) => complete(JsonUtils.toJson(value))
          case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
        }
      }
    }
  }
  
  def handleSaveTestA() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handleSaveTestA ...")
      implicit val timeout = Timeout(30 seconds)
      entity(as[SaveTestAReq]) { req =>
        val futureResponse = tstServiceActor.ask(SaveTestAReq(req.aValue)).mapTo[SaveTestARes]
        onComplete(futureResponse) {
          case Success(SaveTestARes(value)) => complete(JsonUtils.toJson(value))
          case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
        }
      }
    }
  }
  
  def handleSearchTestA() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handleSearchTestA ...")
      implicit val timeout = Timeout(30 seconds)
      entity(as[SearchTestAReq]) { req =>
        val futureResponse = tstServiceActor.ask(SearchTestAReq(req.aName)).mapTo[SearchTestARes]
        onComplete(futureResponse) {
          case Success(SearchTestARes(value)) => complete(JsonUtils.toJson(value))
          case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
        }
      }
    }
  }
  
  def handleGetDto() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handleGetDto ...")
      implicit val timeout = Timeout(30 seconds)
      entity(as[GetDtoReq]) { req =>
        val futureResponse = tstServiceActor.ask(GetDtoReq(req.aValue)).mapTo[GetDtoRes]
        onComplete(futureResponse) {
          case Success(GetDtoRes(value)) => complete(JsonUtils.toJson(value))
          case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
        }
      }
    }
  }
  
  def handlePing() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handlePing ...")
      implicit val timeout = Timeout(30 seconds)
      entity(as[PingReq]) { req =>
        val futureResponse = tstServiceActor.ask(PingReq(req.aMessage)).mapTo[PingRes]
        onComplete(futureResponse) {
          case Success(PingRes(value)) => complete(JsonUtils.toJson(value))
          case Failure(e) => complete(JsonUtils.toJson(e.getMessage()))
        }
      }
    }
  }
  
  def handleDoSomething() = {
    respondWithHeader(HttpHeaders.`Access-Control-Allow-Origin`(AllOrigins)) {
      logger.debug("start handleDoSomething ...")
      implicit val timeout = Timeout(30 seconds)
      tstServiceActor ! DoSomethingReq
      complete("ok")
    }
  }
  
}
