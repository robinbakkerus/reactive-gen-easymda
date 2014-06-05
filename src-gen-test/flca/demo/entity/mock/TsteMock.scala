/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.mock
	
import com.easymda.util.RandomUtils
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
 
object TsteMock {
  def make(id:Option[Long]=None, ename:Option[String]=None, ecount:Option[Int]=None, tstcId:Option[Long]=None, fs:Set[Tstf]=Set()) : Tste = {
    val result = Tste(id)
      result.ename = ename 
      result.ecount = ecount 
      result.fs = fs     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tste = {
    import RandomUtils._
    val result = Tste(id)
    result.ename = Some(stringValue) 
    result.ecount = Some(intValue) 
    result.fs = Set(TstfMock.makeRandom(None), TstfMock.makeRandom(None))     
    result
  }
  
  def hasAllFetched(obj:Tste) : Boolean = {
    val b0 = !obj.fs.isEmpty && obj.fs.forall(TstfMock.hasAllFetched(_))
    b0 
  }
}
