/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.entity.FdTstb
import flca.demo.entity.Tstb
  
/**
 generated class
*/
case class TstbRow(id:Option[Long]=None, bname:Option[String], baantal:Option[Int], uniek:Option[Int]) {
  def copy(newId: Option[Long]=None) = {
    TstbRow(this.id, this.bname, this.baantal, this.uniek)
  }
}
  
//-- dao code 
 
trait TstbDaoBase { this: Profile 
  
  with RowMappers with Logger =>
  import profile.simple._
 
  class TstbRows(tag: Tag) extends Table[TstbRow](tag, "Tstb") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def bname = column[Option[String]]("bname" )
  def baantal = column[Option[Int]]("baantal" )
  def uniek = column[Option[Int]]("uniek" )
  def * = (id.?, bname, baantal, uniek) <> (TstbRow.tupled, TstbRow.unapply)
  }
  
  val tstbQuery = TableQuery[TstbRows]
 
  def findTstb()(implicit session: Session): List[Tstb] = {
    val TstbRows = tstbQuery.list
    for (item <- TstbRows) yield mapFromTstbRow(item)
  }
 
  def retrieveTstb(id:Long, fd:Option[FdTstb]=Some(FdTstb()))(implicit session: Session): Option[Tstb] = {
    logger.info(s"retrieve Tstb $id")
    val list = tstbQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTstbRow(list.head)
      val result2 = retrieveTstbNestedObjects(result1, fd)
      val result3 = copyTstb(result2, fd)
      Some(initTstb(result3))
    } else {
      logger.error(s"could not retrieve Tstb $id")
      None
    }
  }
  
  def saveTstb(item: Tstb)(implicit session: Session): Tstb = {
    var obj = if (isNew(item)) insertTstb(item) else item
      obj = if (mustUpdate(obj)) updateTstb(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTstb(obj, obj.fd)
      initTstb(obj)
  }
  
  def deleteTstb(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tstb $id")
    tstbQuery filter (_.id === id) delete
  }
  
 
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TstbDao to add specific initialization
  */
  private def initTstb(obj:Tstb) = {
    val ohcList = List(obj.ohc(0) )
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tstb):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tstb):Boolean = isDirty(obj)
  def isDirty(obj: Tstb):Boolean = { mapToTstbRow(obj).hashCode != obj.ohc(0) }
 
  private def mainOhcTstb(obj:Tstb, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTstbRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
   
  private def copyTstb(obj:Tstb, fd:Option[FdTstb]=None) = {
    obj.copy(obj.id, mainOhcTstb(obj), fd)
  }
  
 private def insertTstb(obj: Tstb)(implicit session: Session): Tstb = {
    val row = mapToTstbRow(obj)
    val newId:Long = tstbQuery returning tstbQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTstb(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTstb(obj: Tstb)(implicit session: Session): Tstb = {
    val row = mapToTstbRow(obj)
    tstbQuery.where(_.id === row.id).update(row)
    mapFromTstbRow(row)
  }
 
  private def retrieveTstbNestedObjects(obj: Tstb, fd: Option[FdTstb])(implicit session: Session): Tstb = {
    obj
  }
 
  def mapFromTstbRow(row: TstbRow, newId:Option[Long] = None) : Tstb = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tstb(id=useId, ohc=List(row.hashCode))	 
      obj.bname = row.bname	 
      obj.baantal = row.baantal	 
      obj.uniek = row.uniek
    obj
  }
 
  private def mapToTstbRow(obj: Tstb): TstbRow = {
        TstbRow(obj.id, obj.bname, obj.baantal, obj.uniek)
  } 
  
//--- retrieve and merge nested objects
  private def deleteOneToManys(obj:Tstb)(implicit session: Session): Tstb = {
    obj
  }
  
}
