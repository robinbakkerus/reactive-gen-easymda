/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.entity.Tstb
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstbDaoSrv {
  def findTstb() : List[Tstb]
  def retrieveTstb(id:Long) : Option[Tstb]
  def saveTstb(tstb:Tstb) : Tstb
  def deleteTstb(id:Long) : Unit
  
}
