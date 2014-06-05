/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.data.Tstc
import flca.demo.data.srv.TstcDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TstcDaoSrvActor {
  def props = Props[TstcDaoSrvActor]
  def name = "TstcDaoSrvActor"
  
  case object FindTstcReq
  case class FindTstcRes(value: List[Tstc]) 
  case class RetrieveTstcReq(id:Long)
  case class RetrieveTstcRes(value:Option[Tstc]) 
  case class SaveTstcReq(value:Tstc)
  case class SaveTstcRes(value:Tstc) 
  
  case class DeleteTstcReq(id:Long)
}
 
class TstcDaoSrvActor extends Actor {
  import TstcDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTstcReq => {
      sender ! FindTstcRes(service.findTstc)
    }
    case RetrieveTstcReq(id) => {
      sender ! RetrieveTstcRes(service.retrieveTstc(id))
    }
    case SaveTstcReq(value) => {
      sender ! SaveTstcRes(service.saveTstc(value))
    }
  }
  val service = TstcDaoSrvFact.get
}
