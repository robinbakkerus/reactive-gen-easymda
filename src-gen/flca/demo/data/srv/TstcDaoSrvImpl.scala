/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.srv
	
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.data.Tstc
import scala.slick.jdbc.JdbcBackend.Database
 
/**
 * 
 *
 * @author robin
 * @version $Id: ServiceIntf.jet,v 1.1 rbakkerus Exp $
 * @generated
 */
object TstcDaoSrvImpl extends TstcDaoSrv {
 
  val ds = DataSource.datasource
  val db = Database.forDataSource(ds)
  val dal = new DataStores(DataSource.driver)
 
  import dal.profile.simple._
  
  override def findTstc() = {
    db withSession { implicit session:Session =>
      dal.findTstc
    }
  }
 
  override def retrieveTstc(id:Long): Option[Tstc] = {
    db withSession { implicit session =>
      dal.retrieveTstc(id)
    }
  }
 
  override def saveTstc(tstc:Tstc): Tstc = {
    db withSession { implicit session =>
      dal.saveTstc(tstc)
    }
  }
  
  override def deleteTstc(id:Long): Unit = {
    db withSession { implicit session =>
      dal.deleteTstc(id)
    }
  }
 
}
