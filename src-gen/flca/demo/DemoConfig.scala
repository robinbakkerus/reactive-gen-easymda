/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	
import com.easymda.util.Logger
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
  
object DemoConfig extends Logger {
    
  //constants being uses in application.conf
  val APP_NAME = "easymda-reactive"
  val MODUS = "mode"
  val RUN_MODUS = "run." + MODUS
  val DROP_TABLES = "tables.drop"
  val CREATE_TABLES = "tables.create"
  val POPULATE_TABLES = "tables.populate" 
  val DATASOURCE = "datasource"  
  
  val conf = ConfigFactory.load
  logger.info(s"*** running in ${runMode()} mode ******************")
   
  def runMode():String = if (conf.hasPath(RUN_MODUS)) conf.getString(RUN_MODUS) else "PROD"
  def dropTables():Boolean = datasourceFlag(DROP_TABLES)
  def createTables():Boolean = datasourceFlag(CREATE_TABLES)
  def populateTables():Boolean = datasourceFlag(POPULATE_TABLES)
  
  private def datasourceFlag(suffix:String):Boolean = {
    val key = MODUS + "." + runMode + "." + DATASOURCE + "." + suffix  
    println(key)
    if (conf.hasPath(key)) {
      return conf.getBoolean(key)
    }  else false
  }
}
