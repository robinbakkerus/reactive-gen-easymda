/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv.mock
	
import flca.demo.entity.Tstd
import flca.demo.entity.mock.TstdMock
import flca.demo.entity.srv.TstdDaoSrv
import flca.demo.entity.srv.TstdDaoSrvImpl
  
object TstdDaoSrvMock extends TstdDaoSrv {
  
  override def findTstd() : List[Tstd] = {
    List(TstdMock.makeRandom(), TstdMock.makeRandom(), TstdMock.makeRandom())
  }
 
  override def retrieveTstd(id:Long): Option[Tstd] = {
    Some(TstdMock.makeRandom())
  }
 
  override def saveTstd(tstd:Tstd): Tstd = {
     tstd
  }
  
  override def deleteTstd(id:Long): Unit = {
    println("deleted Tstd : id ...")
  }
  
}
