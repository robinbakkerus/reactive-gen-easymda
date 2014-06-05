/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.data.Tstc
import flca.demo.data.dao.TstcDao
import flca.demo.entity.FdTste
import flca.demo.entity.FdTstf
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
  
/**
 generated class
*/
case class TsteRow(id:Option[Long]=None, ename:Option[String], ecount:Option[Int], tstcId:Option[Long]) {
  def copy(newId: Option[Long]=None) = {
    TsteRow(this.id, this.ename, this.ecount, this.tstcId)
  }
}
  
//-- dao code 
 
trait TsteDaoBase { this: Profile 
   with TstfDao with TstcDao
  with RowMappers with Logger =>
  import profile.simple._
 
  class TsteRows(tag: Tag) extends Table[TsteRow](tag, "Tste") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def ename = column[Option[String]]("ename" )
  def ecount = column[Option[Int]]("ecount" )
  def tstcId = column[Option[Long]]("tstcIdId" )
  def * = (id.?, ename, ecount, tstcId) <> (TsteRow.tupled, TsteRow.unapply)
  def tstcIdFK = foreignKey("TSTC", tstcId, tstcQuery)(_.id)
  }
  
  val tsteQuery = TableQuery[TsteRows]
 
  def findTste()(implicit session: Session): List[Tste] = {
    val TsteRows = tsteQuery.list
    for (item <- TsteRows) yield mapFromTsteRow(item)
  }
 
  def retrieveTste(id:Long, fd:Option[FdTste]=Some(FdTste()))(implicit session: Session): Option[Tste] = {
    logger.info(s"retrieve Tste $id")
    val list = tsteQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTsteRow(list.head)
      val result2 = retrieveTsteNestedObjects(result1, fd)
      val result3 = copyTste(result2, fd)
      Some(initTste(result3))
    } else {
      logger.error(s"could not retrieve Tste $id")
      None
    }
  }
  
  def saveTste(item: Tste)(implicit session: Session): Tste = {
    var obj = if (isNew(item)) insertTste(item) else item
      obj = saveTsteTstf(obj)
      obj = if (mustUpdate(obj)) updateTste(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTste(obj, obj.fd)
      initTste(obj)
  }
  
  def deleteTste(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tste $id")
    val deleteIds = for {
      item <- tstfQuery filter (_.tste === id) 
    } yield item.id
    deleteIds foreach deleteTstf
    
    tsteQuery filter (_.id === id) delete
  }
  
  
  def saveTsteTstf(obj:Tste)(implicit session: Session): Tste = {
      obj.fs = obj.fs.map(tstf => {
        tstf.tste = Some(obj)
        saveTstf(tstf)
      })
    obj
  }
  
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TsteDao to add specific initialization
  */
  private def initTste(obj:Tste) = { 
    val ohcList = List(obj.ohc(0) , obj.ohcFs)
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tste):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tste):Boolean = isDirty(obj)
  def isDirty(obj: Tste):Boolean = { mapToTsteRow(obj).hashCode != obj.ohc(0) }
  private def isFsDirty(obj:Tste):Boolean = { fdTsteFs(obj.fd) && obj.ohc.size > 1 && obj.ohcFs != obj.ohc(1) }
 
  private def mainOhcTste(obj:Tste, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTsteRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
  private def fdTsteFs(fd:Option[FdTste]) = fd.isDefined && fd.get.fs.isDefined
   
  private def copyTste(obj:Tste, fd:Option[FdTste]=None) = {
    obj.copy(obj.id, mainOhcTste(obj), fd)
  }
  
 private def insertTste(obj: Tste)(implicit session: Session): Tste = {
    val row = mapToTsteRow(obj)
    val newId:Long = tsteQuery returning tsteQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTste(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTste(obj: Tste)(implicit session: Session): Tste = {
    val row = mapToTsteRow(obj)
    tsteQuery.where(_.id === row.id).update(row)
    mapFromTsteRow(row)
  }
 
  private def retrieveTsteNestedObjects(obj: Tste, fd: Option[FdTste])(implicit session: Session): Tste = {
    if (fdTsteFs(fd)) obj.fs = retrieveTsteFs(obj)
  
    obj
  }
 
  def mapFromTsteRow(row: TsteRow, newId:Option[Long] = None) : Tste = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tste(id=useId, ohc=List(row.hashCode))	 
      obj.ename = row.ename	 
      obj.ecount = row.ecount	 
      obj.tstcId = row.tstcId
    obj
  }
 
  private def mapToTsteRow(obj: Tste): TsteRow = {
        TsteRow(obj.id, obj.ename, obj.ecount, obj.tstcId)
  } 
  
//--- retrieve and merge nested objects
  private def retrieveTsteFs(obj:Tste) (implicit session: Session) : Set[Tstf] = {
    val joinQuery = for {
      tstf <- tstfQuery if tstf.tste === obj.id
    } yield (tstf)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstfRow(_)).to[Set]
  }
  private def deleteOneToManys(obj:Tste)(implicit session: Session): Tste = {
    val obj1 = if (isFsDirty(obj)) deleteOneToManyFs(obj) else obj
    obj1
  }
  
  private def deleteOneToManyFs(obj:Tste)(implicit session: Session): Tste = {
    val oldIds = for {
      fs <- tstcQuery if fs.tsta === obj.id
    } yield (fs.id)
    val newIds:Set[Long] = obj.fs.map(_.id.get)
    oldIds.list.to[Set].diff(newIds).map((id:Long) => deleteTstf(id))
    obj
  }
  
}
