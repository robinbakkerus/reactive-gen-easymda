/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.entity.Tsta
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstaDaoSrv {
  def findTsta() : List[Tsta]
  def retrieveTsta(id:Long) : Option[Tsta]
  def saveTsta(tsta:Tsta) : Tsta
  def deleteTsta(id:Long) : Unit
  
}
