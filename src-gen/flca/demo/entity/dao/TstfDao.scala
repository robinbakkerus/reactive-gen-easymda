/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
import scala.slick.util.SlickLogger
/**
 * add your own queries here
 */
trait TstfDao extends TstfDaoBase { this: Profile 
    with TsteDao
  with RowMappers with Logger =>
  import profile.simple._
}
