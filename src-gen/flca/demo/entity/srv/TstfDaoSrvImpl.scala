/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.entity.Tstf
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TstfDaoSrvImpl extends TstfDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTstf() = {
    db withSession { implicit session:Session =>
      dal.findTstf
    }
  }
 
  override def retrieveTstf(id:Long): Option[Tstf] = {
    db withSession { implicit session =>
      dal.retrieveTstf(id)
    }
  }
 
  override def saveTstf(tstf:Tstf): Tstf = {
    db withSession { implicit session =>
      dal.saveTstf(tstf)
    }
  }
  
  override def deleteTstf(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTstf(id)
    }
  }
 
}
