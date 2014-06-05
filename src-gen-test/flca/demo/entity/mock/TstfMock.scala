/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.mock
	
import com.easymda.util.RandomUtils
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
 
object TstfMock {
  def make(id:Option[Long]=None, fname:Option[String]=None, fcount:Option[Int]=None, tste:Option[Tste]=None) : Tstf = {
    val result = Tstf(id)
      result.fname = fname 
      result.fcount = fcount     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tstf = {
    import RandomUtils._
    val result = Tstf(id)
    result.fname = Some(stringValue) 
    result.fcount = Some(intValue)     
    result
  }
  
  def hasAllFetched(obj:Tstf) : Boolean = {
    true
  }
}
