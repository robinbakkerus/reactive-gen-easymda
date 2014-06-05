/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.mock
	
import com.easymda.util.RandomUtils
import flca.demo.data.Tstc
import flca.demo.entity.Tsta
import flca.demo.entity.Tstd
import flca.demo.entity.Tste
import flca.demo.entity.mock.TstdMock
import flca.demo.entity.mock.TsteMock
 
object TstcMock {
  def make(id:Option[Long]=None, cname:Option[String]=None, tsta:Option[Tsta]=None, d:Option[Tstd]=None, tstes:Set[Tste]=Set()) : Tstc = {
    val result = Tstc(id)
      result.cname = cname 
      result.d = d 
      result.tstes = tstes     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tstc = {
    import RandomUtils._
    val result = Tstc(id)
    result.cname = Some(stringValue) 
    result.d = Some(TstdMock.makeRandom(None)) 
    result.tstes = Set(TsteMock.makeRandom(None), TsteMock.makeRandom(None))     
    result
  }
  
  def hasAllFetched(obj:Tstc) : Boolean = {
    val b0 = obj.d.isDefined    
    val b1 = !obj.tstes.isEmpty && obj.tstes.forall(TsteMock.hasAllFetched(_))
    b0 && b1 
  }
}
