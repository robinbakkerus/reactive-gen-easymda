/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.data.FdTstc
import flca.demo.data.Tstc
import flca.demo.entity.FdTstd
import flca.demo.entity.FdTste
import flca.demo.entity.FdTstf
import flca.demo.entity.Tsta
import flca.demo.entity.Tstd
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
import flca.demo.entity.dao.TstaDao
import flca.demo.entity.dao.TstdDao
import flca.demo.entity.dao.TsteDao
import flca.demo.entity.dao.TstfDao
  
/**
 generated class
*/
case class TstcRow(id:Option[Long]=None, cname:Option[String], tsta:Option[Long], d:Option[Long]=None) {
  def copy(newId: Option[Long]=None) = {
    TstcRow(this.id, this.cname, this.tsta, this.d)
  }
}
  
//-- dao code 
 
trait TstcDaoBase { this: Profile 
   with TsteDao with TstfDao with TstaDao with TstdDao
  with RowMappers with Logger =>
  import profile.simple._
 
  class TstcRows(tag: Tag) extends Table[TstcRow](tag, "Tstc") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def cname = column[Option[String]]("cname" )
  def d = column[Option[Long]]("dId" )
  def tsta = column[Option[Long]]("tstaId" )
  def * = (id.?, cname, tsta, d) <> (TstcRow.tupled, TstcRow.unapply)
  def tstaFK = foreignKey("TSTA", tsta, tstaQuery)(_.id)
  }
  
  val tstcQuery = TableQuery[TstcRows]
 
  def findTstc()(implicit session: Session): List[Tstc] = {
    val TstcRows = tstcQuery.list
    for (item <- TstcRows) yield mapFromTstcRow(item)
  }
 
  def retrieveTstc(id:Long, fd:Option[FdTstc]=Some(FdTstc()))(implicit session: Session): Option[Tstc] = {
    logger.info(s"retrieve Tstc $id")
    val list = tstcQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTstcRow(list.head)
      val result2 = retrieveTstcNestedObjects(result1, fd)
      val result3 = copyTstc(result2, fd)
      Some(initTstc(result3))
    } else {
      logger.error(s"could not retrieve Tstc $id")
      None
    }
  }
  
  def saveTstc(item: Tstc)(implicit session: Session): Tstc = {
    var obj = if (isNew(item)) insertTstc(item) else item
      obj = saveTstcTstd(obj)
      obj = saveTstcTste(obj)
      obj = if (mustUpdate(obj)) updateTstc(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTstc(obj, obj.fd)
      initTstc(obj)
  }
  
  def deleteTstc(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tstc $id")
    val deleteIds = for {
      item <- tsteQuery filter (_.tstcId === id) 
    } yield item.id
    deleteIds foreach deleteTste
    
    tstcQuery filter (_.id === id) delete
  }
  
  def saveTstcTsta(obj:Tstc)(implicit session: Session) : Tstc = {
    if (obj.tsta.isDefined) obj.tsta = Some(saveTsta(obj.tsta.get))
    obj
  }
  
  def saveTstcTstd(obj:Tstc)(implicit session: Session): Tstc = {
      obj.d = obj.d.map(tstd => {
        saveTstd(tstd)
      })
    obj
  }
   
  def saveTstcTste(obj:Tstc)(implicit session: Session): Tstc = {
      obj.tstes = obj.tstes.map(tste => {
        tste.tstcId = obj.id
        saveTste(tste)
      })
    obj
  }
  
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TstcDao to add specific initialization
  */
  private def initTstc(obj:Tstc) = { 
    val ohcList = List(obj.ohc(0) , obj.ohcTstes)
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tstc):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tstc):Boolean = isDirty(obj)
  def isDirty(obj: Tstc):Boolean = { mapToTstcRow(obj).hashCode != obj.ohc(0) }
  private def isTstesDirty(obj:Tstc):Boolean = { fdTstcTstes(obj.fd) && obj.ohc.size > 1 && obj.ohcTstes != obj.ohc(1) }
 
  private def mainOhcTstc(obj:Tstc, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTstcRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
  private def fdTstcTstes(fd:Option[FdTstc]) = fd.isDefined && fd.get.tstes.isDefined
  private def fdTsteFs(fd:Option[FdTstc]) = fd.isDefined && fd.get.tstes.isDefined && fd.get.tstes.get.fs.isDefined
  private def fdTstcD(fd:Option[FdTstc]) = fd.isDefined && fd.get.d.isDefined
   
  private def copyTstc(obj:Tstc, fd:Option[FdTstc]=None) = {
    obj.copy(obj.id, mainOhcTstc(obj), fd)
  }
  
 private def insertTstc(obj: Tstc)(implicit session: Session): Tstc = {
    val row = mapToTstcRow(obj)
    val newId:Long = tstcQuery returning tstcQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTstc(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTstc(obj: Tstc)(implicit session: Session): Tstc = {
    val row = mapToTstcRow(obj)
    tstcQuery.where(_.id === row.id).update(row)
    mapFromTstcRow(row)
  }
 
  private def retrieveTstcNestedObjects(obj: Tstc, fd: Option[FdTstc])(implicit session: Session): Tstc = {
    if (fdTstcTstes(fd)) obj.tstes = retrieveTstcTstes(obj)
  
    if (fdTsteFs(fd)) {
        obj.tstes.foreach((objItem1:Tste) => {
          objItem1.fs = retrieveTsteFs(obj).filter((qryItem2:Tstf) => {qryItem2.tsteId == objItem1.id})
        })
    }
  
    if (fdTstcD(fd)) obj.d = retrieveTstcD(obj).headOption
  
    obj
  }
 
  def mapFromTstcRow(row: TstcRow, newId:Option[Long] = None) : Tstc = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tstc(id=useId, ohc=List(row.hashCode))	 
      obj.cname = row.cname	 
      obj._tstaId = row.tsta	 
      obj._dId = row.d
    obj
  }
 
  private def mapToTstcRow(obj: Tstc): TstcRow = {
        TstcRow(obj.id, obj.cname, obj.tstaId, obj.dId)
  } 
  
//--- retrieve and merge nested objects
  private def retrieveTstcTstes(obj:Tstc) (implicit session: Session) : Set[Tste] = {
    val joinQuery = for {
      tste <- tsteQuery if tste.tstcId === obj.id
    } yield (tste)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTsteRow(_)).to[Set]
  }
  private def retrieveTsteFs(obj:Tstc) (implicit session: Session) : Set[Tstf] = {
    val joinQuery = for {
      tste <- tsteQuery if tste.tstcId === obj.id
      tstf <- tstfQuery if tstf.tste === tste.id
    } yield (tstf)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstfRow(_)).to[Set]
  }
  private def retrieveTstcD(obj:Tstc) (implicit session: Session) : Set[Tstd] = {
    val joinQuery = for {
      tstd <- tstdQuery if tstd.id === obj.dId
    } yield (tstd)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstdRow(_)).to[Set]
  }
  private def deleteOneToManys(obj:Tstc)(implicit session: Session): Tstc = {
    val obj1 = if (isTstesDirty(obj)) deleteOneToManyTstes(obj) else obj
    obj1
  }
  
  private def deleteOneToManyTstes(obj:Tstc)(implicit session: Session): Tstc = {
    val oldIds = for {
      tstes <- tstcQuery if tstes.tsta === obj.id
    } yield (tstes.id)
    val newIds:Set[Long] = obj.tstes.map(_.id.get)
    oldIds.list.to[Set].diff(newIds).map((id:Long) => deleteTste(id))
    obj
  }
  
}
