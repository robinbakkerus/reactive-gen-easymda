/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	
import com.jolbox.bonecp.BoneCPDataSource
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import scala.slick.driver.H2Driver
import scala.slick.driver.JdbcDriver
import scala.slick.driver.JdbcProfile
import scala.slick.driver.SQLiteDriver
	
object DataSource {
  lazy val dbType = "h2"
    
  lazy val datasource = {
    val conf = ConfigFactory.load
    val dbsCfg = datasourceConfig()
    val dbUrl = dbsCfg.getString("dburl")
    val driver = dbsCfg.getString("driver")
    val dbuser = dbsCfg.getString("user")
    val dbpwd = dbsCfg.getString("pwd")
    val ds = new BoneCPDataSource
    ds.setDriverClass(driver)
    ds.setJdbcUrl(dbUrl)
    ds.setAcquireIncrement(5)
    ds.setUsername(dbuser)
    ds.setPassword(dbpwd)
    ds
  }
  
  def datasourceConfig() = {
    val conf = ConfigFactory.load()
    val mode = DemoConfig.runMode
    val dskey = DemoConfig.MODUS + "." + mode + "." + DemoConfig.DATASOURCE
    println(s"mode = $mode getting values from: $dskey")
    conf.getConfig(dskey)
  }
  
  def driver: JdbcDriver =
    dbType match {
      case "h2" => H2Driver
      case "sql-lite" => SQLiteDriver
      case _ => throw new IllegalArgumentException("dbType property must be either h2 o sql-lite")
    }
}
