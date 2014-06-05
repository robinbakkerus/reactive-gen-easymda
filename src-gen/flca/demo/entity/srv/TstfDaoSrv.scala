/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.entity.Tstf
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstfDaoSrv {
  def findTstf() : List[Tstf]
  def retrieveTstf(id:Long) : Option[Tstf]
  def saveTstf(tstf:Tstf) : Tstf
  def deleteTstf(id:Long) : Unit
  
}
