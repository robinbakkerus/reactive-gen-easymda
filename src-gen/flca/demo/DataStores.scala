/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.data.dao.TstcDao
import flca.demo.entity.dao.TstaDao
import flca.demo.entity.dao.TstbDao
import flca.demo.entity.dao.TstdDao
import flca.demo.entity.dao.TsteDao
import flca.demo.entity.dao.TstfDao
import org.slf4j.LoggerFactory
import scala.slick.driver.H2Driver
import scala.slick.driver.JdbcProfile
import scala.slick.driver.SQLiteDriver
import scala.slick.util.SlickLogger
/**
 * The DataStores Layer contains all components and a profile
 */
class DataStores(override val profile: JdbcProfile) extends Profile
    with TsteDao with TstfDao with TstcDao with TstaDao with TstdDao with TstbDao
   with RowMappers with Logger {
  
   import profile.simple._
  
   // helper method to create all tables
   def create(implicit session:Session): Unit = {
     ( tsteQuery.ddl  ++ tstfQuery.ddl  ++ tstcQuery.ddl  ++ tstaQuery.ddl  ++ tstdQuery.ddl  ++ tstbQuery.ddl  ).create 
   }
  
   // helper method to drop all tables
   def drop(implicit session:Session): Unit = {
    ( tsteQuery.ddl  ++ tstfQuery.ddl  ++ tstcQuery.ddl  ++ tstaQuery.ddl  ++ tstdQuery.ddl  ++ tstbQuery.ddl  ).drop 
   }
}
