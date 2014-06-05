/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.entity.Tste
import flca.demo.entity.srv.TsteDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TsteDaoSrvActor {
  def props = Props[TsteDaoSrvActor]
  def name = "TsteDaoSrvActor"
  
  case object FindTsteReq
  case class FindTsteRes(value: List[Tste]) 
  case class RetrieveTsteReq(id:Long)
  case class RetrieveTsteRes(value:Option[Tste]) 
  case class SaveTsteReq(value:Tste)
  case class SaveTsteRes(value:Tste) 
  
  case class DeleteTsteReq(id:Long)
}
 
class TsteDaoSrvActor extends Actor {
  import TsteDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTsteReq => {
      sender ! FindTsteRes(service.findTste)
    }
    case RetrieveTsteReq(id) => {
      sender ! RetrieveTsteRes(service.retrieveTste(id))
    }
    case SaveTsteReq(value) => {
      sender ! SaveTsteRes(service.saveTste(value))
    }
  }
  val service = TsteDaoSrvFact.get
}
