/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTstd() extends FetchDepth
	
/**
 generated class
*/
case class Tstd(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTstd]=None, var dname:Option[String]=None, var daantal:Option[Int]=None) 
	extends BaseClass {
  
 
  /**
  * use this method to copy Tstd
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTstd]=None) = {
  	val result = new Tstd(id, ohc, fd)
	result.dname = this.dname
	result.daantal = this.daantal
  	result
  }
  
}
