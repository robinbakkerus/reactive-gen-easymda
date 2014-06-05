/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.mock
	
import com.easymda.util.RandomUtils
import flca.demo.entity.Tstb
 
object TstbMock {
  def make(id:Option[Long]=None, bname:Option[String]=None, baantal:Option[Int]=None, uniek:Option[Int]=None) : Tstb = {
    val result = Tstb(id)
      result.bname = bname 
      result.baantal = baantal 
      result.uniek = uniek     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tstb = {
    import RandomUtils._
    val result = Tstb(id)
    result.bname = Some(stringValue) 
    result.baantal = Some(intValue) 
    result.uniek = Some(intValue)     
    result
  }
  
  def hasAllFetched(obj:Tstb) : Boolean = {
    true
  }
}
