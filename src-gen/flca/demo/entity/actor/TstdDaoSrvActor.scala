/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.actor
	
import akka.actor.Actor
import akka.actor.Props
import flca.demo.entity.Tstd
import flca.demo.entity.srv.TstdDaoSrvFact
import spray.json.DefaultJsonProtocol
 
object TstdDaoSrvActor {
  def props = Props[TstdDaoSrvActor]
  def name = "TstdDaoSrvActor"
  
  case object FindTstdReq
  case class FindTstdRes(value: List[Tstd]) 
  case class RetrieveTstdReq(id:Long)
  case class RetrieveTstdRes(value:Option[Tstd]) 
  case class SaveTstdReq(value:Tstd)
  case class SaveTstdRes(value:Tstd) 
  
  case class DeleteTstdReq(id:Long)
}
 
class TstdDaoSrvActor extends Actor {
  import TstdDaoSrvActor._
  import context._
  def receive: Receive = {
    case FindTstdReq => {
      sender ! FindTstdRes(service.findTstd)
    }
    case RetrieveTstdReq(id) => {
      sender ! RetrieveTstdRes(service.retrieveTstd(id))
    }
    case SaveTstdReq(value) => {
      sender ! SaveTstdRes(service.saveTstd(value))
    }
  }
  val service = TstdDaoSrvFact.get
}
