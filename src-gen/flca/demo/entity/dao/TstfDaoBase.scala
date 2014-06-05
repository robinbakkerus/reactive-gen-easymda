/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.entity.FdTstf
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
  
/**
 generated class
*/
case class TstfRow(id:Option[Long]=None, fname:Option[String], fcount:Option[Int], tste:Option[Long]) {
  def copy(newId: Option[Long]=None) = {
    TstfRow(this.id, this.fname, this.fcount, this.tste)
  }
}
  
//-- dao code 
 
trait TstfDaoBase { this: Profile 
   with TsteDao
  with RowMappers with Logger =>
  import profile.simple._
 
  class TstfRows(tag: Tag) extends Table[TstfRow](tag, "Tstf") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def fname = column[Option[String]]("fname" )
  def fcount = column[Option[Int]]("fcount" )
  def tste = column[Option[Long]]("tsteId" )
  def * = (id.?, fname, fcount, tste) <> (TstfRow.tupled, TstfRow.unapply)
  def tsteFK = foreignKey("TSTE", tste, tsteQuery)(_.id)
  }
  
  val tstfQuery = TableQuery[TstfRows]
 
  def findTstf()(implicit session: Session): List[Tstf] = {
    val TstfRows = tstfQuery.list
    for (item <- TstfRows) yield mapFromTstfRow(item)
  }
 
  def retrieveTstf(id:Long, fd:Option[FdTstf]=Some(FdTstf()))(implicit session: Session): Option[Tstf] = {
    logger.info(s"retrieve Tstf $id")
    val list = tstfQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTstfRow(list.head)
      val result2 = retrieveTstfNestedObjects(result1, fd)
      val result3 = copyTstf(result2, fd)
      Some(initTstf(result3))
    } else {
      logger.error(s"could not retrieve Tstf $id")
      None
    }
  }
  
  def saveTstf(item: Tstf)(implicit session: Session): Tstf = {
    var obj = if (isNew(item)) insertTstf(item) else item
      obj = if (mustUpdate(obj)) updateTstf(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTstf(obj, obj.fd)
      initTstf(obj)
  }
  
  def deleteTstf(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tstf $id")
    tstfQuery filter (_.id === id) delete
  }
  
  def saveTstfTste(obj:Tstf)(implicit session: Session) : Tstf = {
    if (obj.tste.isDefined) obj.tste = Some(saveTste(obj.tste.get))
    obj
  }
 
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TstfDao to add specific initialization
  */
  private def initTstf(obj:Tstf) = {
    val ohcList = List(obj.ohc(0) )
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tstf):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tstf):Boolean = isDirty(obj)
  def isDirty(obj: Tstf):Boolean = { mapToTstfRow(obj).hashCode != obj.ohc(0) }
 
  private def mainOhcTstf(obj:Tstf, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTstfRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
   
  private def copyTstf(obj:Tstf, fd:Option[FdTstf]=None) = {
    obj.copy(obj.id, mainOhcTstf(obj), fd)
  }
  
 private def insertTstf(obj: Tstf)(implicit session: Session): Tstf = {
    val row = mapToTstfRow(obj)
    val newId:Long = tstfQuery returning tstfQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTstf(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTstf(obj: Tstf)(implicit session: Session): Tstf = {
    val row = mapToTstfRow(obj)
    tstfQuery.where(_.id === row.id).update(row)
    mapFromTstfRow(row)
  }
 
  private def retrieveTstfNestedObjects(obj: Tstf, fd: Option[FdTstf])(implicit session: Session): Tstf = {
    obj
  }
 
  def mapFromTstfRow(row: TstfRow, newId:Option[Long] = None) : Tstf = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tstf(id=useId, ohc=List(row.hashCode))	 
      obj.fname = row.fname	 
      obj.fcount = row.fcount	 
      obj._tsteId = row.tste
    obj
  }
 
  private def mapToTstfRow(obj: Tstf): TstfRow = {
        TstfRow(obj.id, obj.fname, obj.fcount, obj.tsteId)
  } 
  
//--- retrieve and merge nested objects
  private def deleteOneToManys(obj:Tstf)(implicit session: Session): Tstf = {
    obj
  }
  
}
