/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv.mock
	
import flca.demo.entity.Tstb
import flca.demo.entity.mock.TstbMock
import flca.demo.entity.srv.TstbDaoSrv
import flca.demo.entity.srv.TstbDaoSrvImpl
  
object TstbDaoSrvMock extends TstbDaoSrv {
  
  override def findTstb() : List[Tstb] = {
    List(TstbMock.makeRandom(), TstbMock.makeRandom(), TstbMock.makeRandom())
  }
 
  override def retrieveTstb(id:Long): Option[Tstb] = {
    Some(TstbMock.makeRandom())
  }
 
  override def saveTstb(tstb:Tstb): Tstb = {
     tstb
  }
  
  override def deleteTstb(id:Long): Unit = {
    println("deleted Tstb : id ...")
  }
  
}
