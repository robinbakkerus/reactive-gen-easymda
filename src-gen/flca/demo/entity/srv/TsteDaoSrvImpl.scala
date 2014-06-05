/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.entity.Tste
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TsteDaoSrvImpl extends TsteDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTste() = {
    db withSession { implicit session:Session =>
      dal.findTste
    }
  }
 
  override def retrieveTste(id:Long): Option[Tste] = {
    db withSession { implicit session =>
      dal.retrieveTste(id)
    }
  }
 
  override def saveTste(tste:Tste): Tste = {
    db withSession { implicit session =>
      dal.saveTste(tste)
    }
  }
  
  override def deleteTste(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTste(id)
    }
  }
 
}
