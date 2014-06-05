/*
 * Generated via the com.flca generator
 */

package flca.demo

import com.easymda.util.Logger
import scala.slick.jdbc.JdbcBackend.Database
import flca.demo.entity.dao.TstaDao
import flca.demo.entity.Tsta
import flca.demo.entity.mock.TstaMock

object DemoStartup {

  val ds = DataSource.datasource
  var dal = new DataStores(DataSource.driver)
  val db = Database.forDataSource(ds)
  val mode = DemoConfig.runMode

  def initialize(): Unit = {
    //TODO add your additional setup commands here
    if (mode == "DEV") {
      initData
    }
    println("Please goto: http://localhost:8000/web/index.html")
  }

  def initData(): Unit = {
    println ("creating some testdata ...")
    for (i <- 1 to 10) {
      val tsta: Tsta = TstaMock.makeRandom(None)
      testSaveTsta(tsta, dal)
    }
  }

  def testSaveTsta(tsta: Tsta, dal: DataStores): Tsta = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTsta(tsta)
    }
  }
}  
