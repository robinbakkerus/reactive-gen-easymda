/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTstb() extends FetchDepth
	
/**
 generated class
*/
case class Tstb(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTstb]=None, var bname:Option[String]=None, var baantal:Option[Int]=None, var uniek:Option[Int]=None) 
	extends BaseClass {
  
 
  /**
  * use this method to copy Tstb
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTstb]=None) = {
  	val result = new Tstb(id, ohc, fd)
	result.bname = this.bname
	result.baantal = this.baantal
	result.uniek = this.uniek
  	result
  }
  
}
