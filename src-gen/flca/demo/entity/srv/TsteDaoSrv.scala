/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.entity.Tste
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TsteDaoSrv {
  def findTste() : List[Tste]
  def retrieveTste(id:Long) : Option[Tste]
  def saveTste(tste:Tste) : Tste
  def deleteTste(id:Long) : Unit
  
}
