/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.mock
	
import com.easymda.util.RandomUtils
import flca.demo.entity.Tstd
 
object TstdMock {
  def make(id:Option[Long]=None, dname:Option[String]=None, daantal:Option[Int]=None) : Tstd = {
    val result = Tstd(id)
      result.dname = dname 
      result.daantal = daantal     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tstd = {
    import RandomUtils._
    val result = Tstd(id)
    result.dname = Some(stringValue) 
    result.daantal = Some(intValue)     
    result
  }
  
  def hasAllFetched(obj:Tstd) : Boolean = {
    true
  }
}
