/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.entity.Tstb
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TstbDaoSrvImpl extends TstbDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTstb() = {
    db withSession { implicit session:Session =>
      dal.findTstb
    }
  }
 
  override def retrieveTstb(id:Long): Option[Tstb] = {
    db withSession { implicit session =>
      dal.retrieveTstb(id)
    }
  }
 
  override def saveTstb(tstb:Tstb): Tstb = {
    db withSession { implicit session =>
      dal.saveTstb(tstb)
    }
  }
  
  override def deleteTstb(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTstb(id)
    }
  }
 
}
