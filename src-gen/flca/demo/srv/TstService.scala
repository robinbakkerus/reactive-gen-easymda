 
/*
 * Generated via the com.flca generator
 */
	
package flca.demo.srv
	
import flca.demo.dto.TstDto
import flca.demo.entity.Tsta
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
trait TstService {
	/**
	 * todo
	 */
	def helloWorld() : String 
	/**
	 * todo
	 */
	def pingMe(aMessage1:String,  aMessage2:String) : String 
	/**
	 * todo
	 */
	def saveTestA(aValue:Tsta) : Tsta 
	/**
	 * todo
	 */
	def searchTestA(aName:String) : List[Tsta] 
	/**
	 * todo
	 */
	def getDto(aValue:TstDto) : TstDto 
	/**
	 * todo
	 */
	def ping(aMessage:String) : String 
	/**
	 * todo
	 */
	def doSomething() : Unit 
}
