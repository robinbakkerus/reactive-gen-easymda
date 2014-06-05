 
/*
 * Generated via the com.flca generator
 */
	
package flca.demo.srv
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.dto.TstDto
import flca.demo.entity.Tsta
import spray.json.DefaultJsonProtocol
 
object TstServiceActor {
  def props = Props[TstServiceActor]
  def name = "TstServiceActor"
  
  case class VoidSuccess()
  case class VoidFailure(errorMsg:String)
  
  case object HelloWorldReq    
  case class HelloWorldRes(value:String)
  
  case class PingMeReq(aMessage1:String,  aMessage2:String)    
  case class PingMeRes(value:String)
  
  case class SaveTestAReq(aValue:Tsta)    
  case class SaveTestARes(value:Tsta)
  
  case class SearchTestAReq(aName:String)    
  case class SearchTestARes(value:List[Tsta])
  
  case class GetDtoReq(aValue:TstDto)    
  case class GetDtoRes(value:TstDto)
  
  case class PingReq(aMessage:String)    
  case class PingRes(value:String)
  
  case object DoSomethingReq    
  
}
 
class TstServiceActor extends Actor {
  import TstServiceActor._
  import context._
  
  def receive: Receive = {
    case HelloWorldReq => {    
    sender ! HelloWorldRes(service.helloWorld()) 
   }
    case PingMeReq(aMessage1, aMessage2) => {    
    sender ! PingMeRes(service.pingMe(aMessage1, aMessage2)) 
   }
    case SaveTestAReq(aValue) => {    
    sender ! SaveTestARes(service.saveTestA(aValue)) 
   }
    case SearchTestAReq(aName) => {    
    sender ! SearchTestARes(service.searchTestA(aName)) 
   }
    case GetDtoReq(aValue) => {    
    sender ! GetDtoRes(service.getDto(aValue)) 
   }
    case PingReq(aMessage) => {    
    sender ! PingRes(service.ping(aMessage)) 
   }
    case DoSomethingReq => {    
      service.doSomething()
   }
}
  
  val service = TstServiceFact.get
}
