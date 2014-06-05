/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
import flca.demo.data.FdTstc
import flca.demo.data.Tstc
import flca.demo.types.TstEnum
import java.util.Date
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTsta(tstcs:Option[FdTstc]=Some(FdTstc()), b:Option[FdTstb]=Some(FdTstb())) extends FetchDepth
	
/**
 generated class
*/
case class Tsta(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTsta]=None, var name:String=null, var dob:Option[Date]=None, var count:Option[Int]=None, var salary:Option[Double]=None, var flag:Option[Boolean]=None, var testEnum:Option[TstEnum.Value]=None, var testLiteralAnno:Option[String]=None) 
	extends BaseClass {
  
	var b : Option[Tstb] = None
	var _bId : Option[Long] = None
	def bId = { if (b.isDefined) b.get.id else _bId }
	var tstcs : Set[Tstc] = Set()
 
  /**
  * use this method to copy Tsta
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTsta]=None) = {
  	val result = new Tsta(id, ohc, fd)
	result.name = this.name
	result.dob = this.dob
	result.count = this.count
	result.salary = this.salary
	result.flag = this.flag
	result.testEnum = this.testEnum
	result.testLiteralAnno = this.testLiteralAnno
	result.b = this.b
	result.tstcs = this.tstcs
  	result
  }
  
  def ohcTstcs:Long = this.tstcs.foldLeft(0L)((acc,item) => acc + (if (item.id.isDefined) 31 * item.id.get else 0))
}
