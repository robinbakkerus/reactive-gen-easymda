/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	
import akka.actor.ActorSystem
import akka.actor.Props
import akka.io.IO
import scala.slick.jdbc.JdbcBackend.Database
import spray.can.Http
import spray.can.Http.Bind
  
 
object Main extends App {
  implicit val system = ActorSystem("reactive")
  
  val ds = DataSource.datasource
  var dal = new DataStores(DataSource.driver)
  val db = Database.forDataSource(ds)
  
  startup
  
  val receptionist = system.actorOf(Props[Reception], "reception")
  IO(Http) ! Bind(listener = receptionist, interface = "0.0.0.0", port = 8000)
  
  def startup() = {
    setupDatabase(DataSource.dbType, dal, db)
    DemoStartup.initialize
  }
  
  def setupDatabase(name: String, dal: DataStores, db: Database) {
    import dal._
    import dal.profile.simple._
    println("Running test against " + name)
    db withSession { implicit session: Session =>
      if (DemoConfig.dropTables) {dal.drop}
      if (DemoConfig.createTables) {dal.create}
    }
  }
}
