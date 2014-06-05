/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.entity.Tsta
import flca.demo.entity.srv.TstaDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TstaDaoSrvActor {
  def props = Props[TstaDaoSrvActor]
  def name = "TstaDaoSrvActor"
  
  case object FindTstaReq
  case class FindTstaRes(value: List[Tsta]) 
  case class RetrieveTstaReq(id:Long)
  case class RetrieveTstaRes(value:Option[Tsta]) 
  case class SaveTstaReq(value:Tsta)
  case class SaveTstaRes(value:Tsta) 
  
  case class DeleteTstaReq(id:Long)
}
 
class TstaDaoSrvActor extends Actor {
  import TstaDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTstaReq => {
      sender ! FindTstaRes(service.findTsta)
    }
    case RetrieveTstaReq(id) => {
      sender ! RetrieveTstaRes(service.retrieveTsta(id))
    }
    case SaveTstaReq(value) => {
      sender ! SaveTstaRes(service.saveTsta(value))
    }
  }
  val service = TstaDaoSrvFact.get
}
