/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data
	
import com.easymda.util.BaseClass
import com.easymda.util.FetchDepth
import flca.demo.entity.FdTstd
import flca.demo.entity.FdTste
import flca.demo.entity.Tsta
import flca.demo.entity.Tstd
import flca.demo.entity.Tste
/**
 Generated "Fd" class that can be used to define whether or not to fetch (deeply) nested classes. 
*/
case class FdTstc(tstes:Option[FdTste]=Some(FdTste()), d:Option[FdTstd]=Some(FdTstd())) extends FetchDepth
	
/**
 generated class
*/
case class Tstc(val id:Option[Long]=None, val ohc:List[Long]=List(0), val fd:Option[FdTstc]=None, var cname:Option[String]=None) 
	extends BaseClass {
  
	var tsta : Option[Tsta] = None
	var _tstaId : Option[Long] = None
	def tstaId = { if (tsta.isDefined) tsta.get.id else _tstaId }
	var d : Option[Tstd] = None
	var _dId : Option[Long] = None
	def dId = { if (d.isDefined) d.get.id else _dId }
	var tstes : Set[Tste] = Set()
 
  /**
  * use this method to copy Tstc
  */ 
  def copy(id:Option[Long]=None, ohc:List[Long]=List(0), fd:Option[FdTstc]=None) = {
  	val result = new Tstc(id, ohc, fd)
	result.cname = this.cname
	result.tsta = this.tsta
	result.d = this.d
	result.tstes = this.tstes
  	result
  }
  
  def ohcTstes:Long = this.tstes.foldLeft(0L)((acc,item) => acc + (if (item.id.isDefined) 31 * item.id.get else 0))
}
