/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTstf() extends FetchDepth
	
/**
 generated class
*/
case class Tstf(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTstf]=None, var fname:Option[String]=None, var fcount:Option[Int]=None) 
	extends BaseClass {
  
	var tste : Option[Tste] = None
	var _tsteId : Option[Long] = None
	def tsteId = { if (tste.isDefined) tste.get.id else _tsteId }
 
  /**
  * use this method to copy Tstf
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTstf]=None) = {
  	val result = new Tstf(id, ohc, fd)
	result.fname = this.fname
	result.fcount = this.fcount
	result.tste = this.tste
  	result
  }
  
}
