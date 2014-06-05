/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.entity.Tstf
import flca.demo.entity.srv.TstfDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TstfDaoSrvActor {
  def props = Props[TstfDaoSrvActor]
  def name = "TstfDaoSrvActor"
  
  case object FindTstfReq
  case class FindTstfRes(value: List[Tstf]) 
  case class RetrieveTstfReq(id:Long)
  case class RetrieveTstfRes(value:Option[Tstf]) 
  case class SaveTstfReq(value:Tstf)
  case class SaveTstfRes(value:Tstf) 
  
  case class DeleteTstfReq(id:Long)
}
 
class TstfDaoSrvActor extends Actor {
  import TstfDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTstfReq => {
      sender ! FindTstfRes(service.findTstf)
    }
    case RetrieveTstfReq(id) => {
      sender ! RetrieveTstfRes(service.retrieveTstf(id))
    }
    case SaveTstfReq(value) => {
      sender ! SaveTstfRes(service.saveTstf(value))
    }
  }
  val service = TstfDaoSrvFact.get
}
