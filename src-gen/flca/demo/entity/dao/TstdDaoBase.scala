/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.entity.FdTstd
import flca.demo.entity.Tstd
  
/**
 generated class
*/
case class TstdRow(id:Option[Long]=None, dname:Option[String], daantal:Option[Int]) {
  def copy(newId: Option[Long]=None) = {
    TstdRow(this.id, this.dname, this.daantal)
  }
}
  
//-- dao code 
 
trait TstdDaoBase { this: Profile 
  
  with RowMappers with Logger =>
  import profile.simple._
 
  class TstdRows(tag: Tag) extends Table[TstdRow](tag, "Tstd") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def dname = column[Option[String]]("dname" )
  def daantal = column[Option[Int]]("daantal" )
  def * = (id.?, dname, daantal) <> (TstdRow.tupled, TstdRow.unapply)
  }
  
  val tstdQuery = TableQuery[TstdRows]
 
  def findTstd()(implicit session: Session): List[Tstd] = {
    val TstdRows = tstdQuery.list
    for (item <- TstdRows) yield mapFromTstdRow(item)
  }
 
  def retrieveTstd(id:Long, fd:Option[FdTstd]=Some(FdTstd()))(implicit session: Session): Option[Tstd] = {
    logger.info(s"retrieve Tstd $id")
    val list = tstdQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTstdRow(list.head)
      val result2 = retrieveTstdNestedObjects(result1, fd)
      val result3 = copyTstd(result2, fd)
      Some(initTstd(result3))
    } else {
      logger.error(s"could not retrieve Tstd $id")
      None
    }
  }
  
  def saveTstd(item: Tstd)(implicit session: Session): Tstd = {
    var obj = if (isNew(item)) insertTstd(item) else item
      obj = if (mustUpdate(obj)) updateTstd(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTstd(obj, obj.fd)
      initTstd(obj)
  }
  
  def deleteTstd(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tstd $id")
    tstdQuery filter (_.id === id) delete
  }
  
 
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TstdDao to add specific initialization
  */
  private def initTstd(obj:Tstd) = {
    val ohcList = List(obj.ohc(0) )
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tstd):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tstd):Boolean = isDirty(obj)
  def isDirty(obj: Tstd):Boolean = { mapToTstdRow(obj).hashCode != obj.ohc(0) }
 
  private def mainOhcTstd(obj:Tstd, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTstdRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
   
  private def copyTstd(obj:Tstd, fd:Option[FdTstd]=None) = {
    obj.copy(obj.id, mainOhcTstd(obj), fd)
  }
  
 private def insertTstd(obj: Tstd)(implicit session: Session): Tstd = {
    val row = mapToTstdRow(obj)
    val newId:Long = tstdQuery returning tstdQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTstd(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTstd(obj: Tstd)(implicit session: Session): Tstd = {
    val row = mapToTstdRow(obj)
    tstdQuery.where(_.id === row.id).update(row)
    mapFromTstdRow(row)
  }
 
  private def retrieveTstdNestedObjects(obj: Tstd, fd: Option[FdTstd])(implicit session: Session): Tstd = {
    obj
  }
 
  def mapFromTstdRow(row: TstdRow, newId:Option[Long] = None) : Tstd = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tstd(id=useId, ohc=List(row.hashCode))	 
      obj.dname = row.dname	 
      obj.daantal = row.daantal
    obj
  }
 
  private def mapToTstdRow(obj: Tstd): TstdRow = {
        TstdRow(obj.id, obj.dname, obj.daantal)
  } 
  
//--- retrieve and merge nested objects
  private def deleteOneToManys(obj:Tstd)(implicit session: Session): Tstd = {
    obj
  }
  
}
