/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv.mock
	
import flca.demo.entity.Tstf
import flca.demo.entity.mock.TstfMock
import flca.demo.entity.srv.TstfDaoSrv
import flca.demo.entity.srv.TstfDaoSrvImpl
  
object TstfDaoSrvMock extends TstfDaoSrv {
  
  override def findTstf() : List[Tstf] = {
    List(TstfMock.makeRandom(), TstfMock.makeRandom(), TstfMock.makeRandom())
  }
 
  override def retrieveTstf(id:Long): Option[Tstf] = {
    Some(TstfMock.makeRandom())
  }
 
  override def saveTstf(tstf:Tstf): Tstf = {
     tstf
  }
  
  override def deleteTstf(id:Long): Unit = {
    println("deleted Tstf : id ...")
  }
  
}
