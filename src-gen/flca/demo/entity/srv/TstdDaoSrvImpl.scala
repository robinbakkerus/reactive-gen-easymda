/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.entity.Tstd
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TstdDaoSrvImpl extends TstdDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTstd() = {
    db withSession { implicit session:Session =>
      dal.findTstd
    }
  }
 
  override def retrieveTstd(id:Long): Option[Tstd] = {
    db withSession { implicit session =>
      dal.retrieveTstd(id)
    }
  }
 
  override def saveTstd(tstd:Tstd): Tstd = {
    db withSession { implicit session =>
      dal.saveTstd(tstd)
    }
  }
  
  override def deleteTstd(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTstd(id)
    }
  }
 
}
