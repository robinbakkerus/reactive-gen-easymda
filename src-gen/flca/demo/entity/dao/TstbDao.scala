/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import scala.slick.util.SlickLogger
/**
 * add your own queries here
 */
trait TstbDao extends TstbDaoBase { this: Profile 
   
  with RowMappers with Logger =>
  import profile.simple._
}
