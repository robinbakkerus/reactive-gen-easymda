/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.entity.Tstb
import flca.demo.entity.srv.TstbDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TstbDaoSrvActor {
  def props = Props[TstbDaoSrvActor]
  def name = "TstbDaoSrvActor"
  
  case object FindTstbReq
  case class FindTstbRes(value: List[Tstb]) 
  case class RetrieveTstbReq(id:Long)
  case class RetrieveTstbRes(value:Option[Tstb]) 
  case class SaveTstbReq(value:Tstb)
  case class SaveTstbRes(value:Tstb) 
  
  case class DeleteTstbReq(id:Long)
}
 
class TstbDaoSrvActor extends Actor {
  import TstbDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTstbReq => {
      sender ! FindTstbRes(service.findTstb)
    }
    case RetrieveTstbReq(id) => {
      sender ! RetrieveTstbRes(service.retrieveTstb(id))
    }
    case SaveTstbReq(value) => {
      sender ! SaveTstbRes(service.saveTstb(value))
    }
  }
  val service = TstbDaoSrvFact.get
}
