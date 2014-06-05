/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.srv.mock
	
import flca.demo.data.Tstc
import flca.demo.data.mock.TstcMock
import flca.demo.data.srv.TstcDaoSrv
import flca.demo.data.srv.TstcDaoSrvImpl
  
object TstcDaoSrvMock extends TstcDaoSrv {
  
  override def findTstc() : List[Tstc] = {
    List(TstcMock.makeRandom(), TstcMock.makeRandom(), TstcMock.makeRandom())
  }
 
  override def retrieveTstc(id:Long): Option[Tstc] = {
    Some(TstcMock.makeRandom())
  }
 
  override def saveTstc(tstc:Tstc): Tstc = {
     tstc
  }
  
  override def deleteTstc(id:Long): Unit = {
    println("deleted Tstc : id ...")
  }
  
}
