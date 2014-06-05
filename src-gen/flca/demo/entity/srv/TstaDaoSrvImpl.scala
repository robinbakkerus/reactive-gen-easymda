/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.entity.Tsta
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TstaDaoSrvImpl extends TstaDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTsta() = {
    db withSession { implicit session:Session =>
      dal.findTsta
    }
  }
 
  override def retrieveTsta(id:Long): Option[Tsta] = {
    db withSession { implicit session =>
      dal.retrieveTsta(id)
    }
  }
 
  override def saveTsta(tsta:Tsta): Tsta = {
    db withSession { implicit session =>
      dal.saveTsta(tsta)
    }
  }
  
  override def deleteTsta(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTsta(id)
    }
  }
 
}
