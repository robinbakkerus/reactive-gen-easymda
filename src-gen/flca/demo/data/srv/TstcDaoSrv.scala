/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.srv
	
import flca.demo.data.Tstc
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstcDaoSrv {
  def findTstc() : List[Tstc]
  def retrieveTstc(id:Long) : Option[Tstc]
  def saveTstc(tstc:Tstc) : Tstc
  def deleteTstc(id:Long) : Unit
  
}
