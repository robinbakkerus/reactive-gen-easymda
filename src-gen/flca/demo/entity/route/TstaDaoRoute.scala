/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.route
	
import akka.actor.ActorRef
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import com.easymda.util.CreationSupport
import com.easymda.util.JsonUtils
import com.easymda.util.Logger
import flca.demo.entity.Tsta
import flca.demo.entity.actor.TstaDaoSrvActor
import flca.demo.entity.actor.TstaDaoSrvActor._
import org.json4s._
import org.json4s.JsonAST.JObject
import org.json4s.native.JsonMethods._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.util.Failure
import scala.util.Success
import spray.http.StatusCodes
import spray.httpx.Json4sSupport
import spray.httpx.SprayJsonSupport._
import spray.routing._
  
trait TstaDaoRoute extends HttpService with CreationSupport with Json4sSupport with Logger {
  
  implicit def executionContext: ExecutionContext
  
  private val tstaDaoSrvActor = createChild(TstaDaoSrvActor.props, TstaDaoSrvActor.name)
  
  val findTstaRoute: Route = path("findTsta") {get {handleFindTsta()} }
  val retrieveTstaRoute: Route = path("retrieveTsta" / IntNumber) {id => get {handleRetrieveTsta(id)} } 
  val saveTstaRoute: Route = path("saveTsta") {get {handleSaveTsta()} }
  val deleteTstaRoute: Route = path("deleteTsta") {get {handleDeleteTsta()} }
  
  def handleFindTsta() = {
      logger.debug("start handleFindTsta ....")
      implicit val timeout = Timeout(30 seconds)
       
      val futureResponse = tstaDaoSrvActor.ask(FindTstaReq).mapTo[FindTstaRes]
      onComplete(futureResponse) {
        case Success(FindTstaRes(value)) => complete(value)
        case Failure(e) => complete(StatusCodes.InternalServerError)
      }
  }
   
  def handleRetrieveTsta(id:Int) = {
     logger.debug("start handleRetrieveTsta ...")
     implicit val timeout = Timeout(30 seconds)
     val futureResponse = tstaDaoSrvActor.ask(RetrieveTstaReq(id)).mapTo[RetrieveTstaRes]
     onComplete(futureResponse) {
       case Success(RetrieveTstaRes(value)) => complete(value)
       case Failure(e) => complete(StatusCodes.InternalServerError)
     }
  }   
  
  def handleSaveTsta() = {
      entity(as[SaveTstaReq]) { req =>
        logger.debug("start handleSaveTsta ...")
        implicit val timeout = Timeout(30 seconds)
        val futureResponse = tstaDaoSrvActor.ask(SaveTstaReq(req.value)).mapTo[SaveTstaRes]
        onComplete(futureResponse) {
          case Success(SaveTstaRes(value)) => complete(value)
          case Failure(e) => complete(StatusCodes.InternalServerError)
        }
      }
  }  
  
  def handleDeleteTsta() = {
      entity(as[DeleteTstaReq]) { req =>
        logger.debug("start handleRetrieveTsta ...")
        implicit val timeout = Timeout(30 seconds)
        val futureResponse = tstaDaoSrvActor ! DeleteTstaReq(req.id)
        complete("ok")
      }
  }   
}
