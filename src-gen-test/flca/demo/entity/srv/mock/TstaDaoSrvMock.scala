/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv.mock
	
import flca.demo.entity.Tsta
import flca.demo.entity.mock.TstaMock
import flca.demo.entity.srv.TstaDaoSrv
import flca.demo.entity.srv.TstaDaoSrvImpl
  
object TstaDaoSrvMock extends TstaDaoSrv {
  
  override def findTsta() : List[Tsta] = {
    List(TstaMock.makeRandom(), TstaMock.makeRandom(), TstaMock.makeRandom())
  }
 
  override def retrieveTsta(id:Long): Option[Tsta] = {
    Some(TstaMock.makeRandom())
  }
 
  override def saveTsta(tsta:Tsta): Tsta = {
     tsta
  }
  
  override def deleteTsta(id:Long): Unit = {
    println("deleted Tsta : id ...")
  }
  
}
