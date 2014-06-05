/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.entity.Tstd
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstdDaoSrv {
  def findTstd() : List[Tstd]
  def retrieveTstd(id:Long) : Option[Tstd]
  def saveTstd(tstd:Tstd) : Tstd
  def deleteTstd(id:Long) : Unit
  
}
