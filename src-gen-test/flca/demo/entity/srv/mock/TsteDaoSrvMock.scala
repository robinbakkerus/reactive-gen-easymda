/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv.mock
	
import flca.demo.entity.Tste
import flca.demo.entity.mock.TsteMock
import flca.demo.entity.srv.TsteDaoSrv
import flca.demo.entity.srv.TsteDaoSrvImpl
  
object TsteDaoSrvMock extends TsteDaoSrv {
  
  override def findTste() : List[Tste] = {
    List(TsteMock.makeRandom(), TsteMock.makeRandom(), TsteMock.makeRandom())
  }
 
  override def retrieveTste(id:Long): Option[Tste] = {
    Some(TsteMock.makeRandom())
  }
 
  override def saveTste(tste:Tste): Tste = {
     tste
  }
  
  override def deleteTste(id:Long): Unit = {
    println("deleted Tste : id ...")
  }
  
}
