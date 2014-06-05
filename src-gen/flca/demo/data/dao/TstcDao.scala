/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.data.Tstc
import flca.demo.entity.Tsta
import flca.demo.entity.Tstd
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
import flca.demo.entity.dao.TstaDao
import flca.demo.entity.dao.TstdDao
import flca.demo.entity.dao.TsteDao
import flca.demo.entity.dao.TstfDao
import scala.slick.util.SlickLogger
/**
 * add your own queries here
 */
trait TstcDao extends TstcDaoBase { this: Profile 
    with TsteDao with TstfDao with TstaDao with TstdDao
  with RowMappers with Logger =>
  import profile.simple._
}
