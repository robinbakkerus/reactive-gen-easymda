/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTste(fs:Option[FdTstf]=Some(FdTstf())) extends FetchDepth
	
/**
 generated class
*/
case class Tste(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTste]=None, var ename:Option[String]=None, var ecount:Option[Int]=None) 
	extends BaseClass {
  
	var tstcId : Option[Long] = None
	var fs : Set[Tstf] = Set()
 
  /**
  * use this method to copy Tste
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTste]=None) = {
  	val result = new Tste(id, ohc, fd)
	result.ename = this.ename
	result.ecount = this.ecount
	result.tstcId = this.tstcId
	result.fs = this.fs
  	result
  }
  
  def ohcFs:Long = this.fs.foldLeft(0L)((acc,item) => acc + (if (item.id.isDefined) 31 * item.id.get else 0))
}
