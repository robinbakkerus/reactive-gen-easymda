/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.mock
	
import com.easymda.util.RandomUtils
import flca.demo.data.Tstc
import flca.demo.data.mock.TstcMock
import flca.demo.entity.Tsta
import flca.demo.entity.Tstb
import flca.demo.types.TstEnum
import java.util.Date
 
object TstaMock {
  def make(id:Option[Long]=None, name:String=null, dob:Option[Date]=None, count:Option[Int]=None, salary:Option[Double]=None, flag:Option[Boolean]=None, testEnum:Option[TstEnum.Value]=None, testLiteralAnno:Option[String]=None, b:Option[Tstb]=None, tstcs:Set[Tstc]=Set()) : Tsta = {
    val result = Tsta(id)
      result.name = name 
      result.dob = dob 
      result.count = count 
      result.salary = salary 
      result.flag = flag 
      result.testEnum = testEnum 
      result.testLiteralAnno = testLiteralAnno 
      result.b = b 
      result.tstcs = tstcs     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : Tsta = {
    import RandomUtils._
    val result = Tsta(id)
    result.name = stringValue 
    result.dob = Some(dateValue) 
    result.count = Some(intValue) 
    result.salary = Some(doubleValue) 
    result.flag = Some(boolValue) 
    result.testEnum = Some(TstEnum.values.toSeq(intValue(TstEnum.values.size))) 
    result.testLiteralAnno = Some(stringValue) 
    result.b = Some(TstbMock.makeRandom(None)) 
    result.tstcs = Set(TstcMock.makeRandom(None), TstcMock.makeRandom(None))     
    result
  }
  
  def hasAllFetched(obj:Tsta) : Boolean = {
    val b0 = obj.b.isDefined    
    val b1 = !obj.tstcs.isEmpty && obj.tstcs.forall(TstcMock.hasAllFetched(_))
    b0 && b1 
  }
}
