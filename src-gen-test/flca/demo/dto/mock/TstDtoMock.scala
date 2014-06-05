/*
 * Generated via the com.flca generator
 */
	
package flca.demo.dto.mock
	
import com.easymda.util.RandomUtils
import flca.demo.dto.TstDto
import java.util.Date
 
object TstDtoMock {
  def make(id:Option[Long]=None, dtoId:Option[Long]=None, dtoName:Option[String]=None, count:Option[Int]=None, dob:Option[Date]=None) : TstDto = {
    val result = TstDto(id)
      result.dtoId = dtoId 
      result.dtoName = dtoName 
      result.count = count 
      result.dob = dob     
    result
  }
  
  def makeRandom(id:Option[Long]=None) : TstDto = {
    import RandomUtils._
    val result = TstDto(id)
    result.dtoId = Some(intValue) 
    result.dtoName = Some(stringValue) 
    result.count = Some(intValue) 
    result.dob = Some(dateValue)     
    result
  }
}
