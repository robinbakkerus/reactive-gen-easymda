/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.dao
	
import com.easymda.util.Logger
import com.easymda.util.Profile
import com.easymda.util.RowMappers
import flca.demo.data.FdTstc
import flca.demo.data.Tstc
import flca.demo.data.dao.TstcDao
import flca.demo.entity.FdTsta
import flca.demo.entity.FdTstb
import flca.demo.entity.FdTstd
import flca.demo.entity.FdTste
import flca.demo.entity.FdTstf
import flca.demo.entity.Tsta
import flca.demo.entity.Tstb
import flca.demo.entity.Tstd
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
import flca.demo.types.TstEnum
import java.math.BigDecimal
import java.util.Date
  
/**
 generated class
*/
case class TstaRow(id:Option[Long]=None, name:String, dob:Option[java.sql.Date], count:Option[Int], salary:Option[Double], flag:Option[Boolean], testEnum:Option[String], testLiteralAnno:Option[String], b:Option[Long]=None) {
  def copy(newId: Option[Long]=None) = {
    TstaRow(this.id, this.name, this.dob, this.count, this.salary, this.flag, this.testEnum, this.testLiteralAnno, this.b)
  }
}
  
//-- dao code 
 
trait TstaDaoBase { this: Profile 
   with TsteDao with TstfDao with TstcDao with TstdDao with TstbDao
  with RowMappers with Logger =>
  import profile.simple._
 
  class TstaRows(tag: Tag) extends Table[TstaRow](tag, "Tsta") {
  def id = column[Long]("id" , O.PrimaryKey, O.AutoInc)
  def name = column[String]("name" , O.NotNull)
  def dob = column[Option[java.sql.Date]]("dob" )
  def count = column[Option[Int]]("count" )
  def salary = column[Option[Double]]("salary" )
  def flag = column[Option[Boolean]]("flag" )
  def testEnum = column[Option[String]]("testEnum" )
  def testLiteralAnno = column[Option[String]]("testLiteralAnno" )
  def b = column[Option[Long]]("bId" )
  def * = (id.?, name, dob, count, salary, flag, testEnum, testLiteralAnno, b) <> (TstaRow.tupled, TstaRow.unapply)
  }
  
  val tstaQuery = TableQuery[TstaRows]
 
  def findTsta()(implicit session: Session): List[Tsta] = {
    val TstaRows = tstaQuery.list
    for (item <- TstaRows) yield mapFromTstaRow(item)
  }
 
  def retrieveTsta(id:Long, fd:Option[FdTsta]=Some(FdTsta()))(implicit session: Session): Option[Tsta] = {
    logger.info(s"retrieve Tsta $id")
    val list = tstaQuery.list.filter(Some(id) == _.id)
    if (list.size == 1) {
      val result1 = mapFromTstaRow(list.head)
      val result2 = retrieveTstaNestedObjects(result1, fd)
      val result3 = copyTsta(result2, fd)
      Some(initTsta(result3))
    } else {
      logger.error(s"could not retrieve Tsta $id")
      None
    }
  }
  
  def saveTsta(item: Tsta)(implicit session: Session): Tsta = {
    var obj = if (isNew(item)) insertTsta(item) else item
      obj = saveTstaTstb(obj)
      obj = saveTstaTstc(obj)
      obj = if (mustUpdate(obj)) updateTsta(obj) else obj
      obj = deleteOneToManys(obj)
      obj = copyTsta(obj, obj.fd)
      initTsta(obj)
  }
  
  def deleteTsta(id:Long)(implicit session: Session): Unit = {
    logger.info(s"delete Tsta $id")
    val deleteIds = for {
      item <- tstcQuery filter (_.tsta === id) 
    } yield item.id
    deleteIds foreach deleteTstc
    
    tstaQuery filter (_.id === id) delete
  }
  
  
  def saveTstaTstb(obj:Tsta)(implicit session: Session): Tsta = {
      obj.b = obj.b.map(tstb => {
        saveTstb(tstb)
      })
    obj
  }
   
  def saveTstaTstc(obj:Tsta)(implicit session: Session): Tsta = {
      obj.tstcs = obj.tstcs.map(tstc => {
        tstc.tsta = Some(obj)
        saveTstc(tstc)
      })
    obj
  }
  
  
  /**
  * this is the last method called, before returning the object to the client. Use this method in TstaDao to add specific initialization
  */
  private def initTsta(obj:Tsta) = { 
    val ohcList = List(obj.ohc(0) , obj.ohcTstcs)
    obj.copy(obj.id, ohcList, obj.fd)
  }
  
  def isNew(obj: Tsta):Boolean = obj.id.isEmpty
  def mustUpdate(obj: Tsta):Boolean = isDirty(obj)
  def isDirty(obj: Tsta):Boolean = { mapToTstaRow(obj).hashCode != obj.ohc(0) }
  private def isTstcsDirty(obj:Tsta):Boolean = { fdTstaTstcs(obj.fd) && obj.ohc.size > 1 && obj.ohcTstcs != obj.ohc(1) }
 
  private def mainOhcTsta(obj:Tsta, mainOhc:Long=0L ):List[Long] = {
    val ohc0 = if (mainOhc==0L) mapToTstaRow(obj).hashCode else mainOhc
    List(ohc0)
  }
  
  private def fdTstaTstcs(fd:Option[FdTsta]) = fd.isDefined && fd.get.tstcs.isDefined
  private def fdTstcTstes(fd:Option[FdTsta]) = fd.isDefined && fd.get.tstcs.isDefined && fd.get.tstcs.get.tstes.isDefined
  private def fdTsteFs(fd:Option[FdTsta]) = fd.isDefined && fd.get.tstcs.isDefined && fd.get.tstcs.get.tstes.isDefined && fd.get.tstcs.get.tstes.get.fs.isDefined
  private def fdTstcD(fd:Option[FdTsta]) = fd.isDefined && fd.get.tstcs.isDefined && fd.get.tstcs.get.d.isDefined
  private def fdTstaB(fd:Option[FdTsta]) = fd.isDefined && fd.get.b.isDefined
   
  private def copyTsta(obj:Tsta, fd:Option[FdTsta]=None) = {
    obj.copy(obj.id, mainOhcTsta(obj), fd)
  }
  
 private def insertTsta(obj: Tsta)(implicit session: Session): Tsta = {
    val row = mapToTstaRow(obj)
    val newId:Long = tstaQuery returning tstaQuery.map(_.id) += row
    obj.copy(Some(newId), mainOhcTsta(obj, (row.copy(Some(newId))).hashCode))
  }
  private def updateTsta(obj: Tsta)(implicit session: Session): Tsta = {
    val row = mapToTstaRow(obj)
    tstaQuery.where(_.id === row.id).update(row)
    mapFromTstaRow(row)
  }
 
  private def retrieveTstaNestedObjects(obj: Tsta, fd: Option[FdTsta])(implicit session: Session): Tsta = {
    if (fdTstaTstcs(fd)) obj.tstcs = retrieveTstaTstcs(obj)
  
    if (fdTstcTstes(fd)) {
        obj.tstcs.foreach((objItem1:Tstc) => {
          objItem1.tstes = retrieveTstcTstes(obj).filter((qryItem2:Tste) => {qryItem2.tstcId == objItem1.id})
        })
    }
  
    if (fdTsteFs(fd)) {
        obj.tstcs.foreach((objItem1:Tstc) => {
          objItem1.tstes.foreach((objItem2:Tste) => {
            objItem2.fs = retrieveTsteFs(obj).filter((qryItem3:Tstf) => {qryItem3.tsteId == objItem2.id})
          })
        })
    }
  
    if (fdTstcD(fd)) {
        obj.tstcs.foreach((objItem1:Tstc) => {
          objItem1.d = retrieveTstcD(obj).filter((qryItem2:Tstd) => {qryItem2.id == objItem1.dId}).headOption
        })
    }
  
    if (fdTstaB(fd)) obj.b = retrieveTstaB(obj).headOption
  
    obj
  }
 
  def mapFromTstaRow(row: TstaRow, newId:Option[Long] = None) : Tsta = {
    val useId = if (newId.isDefined) newId else row.id
    val obj = new Tsta(id=useId, ohc=List(row.hashCode))	 
      obj.name = row.name	 
      obj.dob = Some(toDate(row.dob))	 
      obj.count = row.count	 
      obj.salary = row.salary	 
      obj.flag = row.flag	 
      obj.testEnum = TstEnum.parse(row.testEnum)	 
      obj.testLiteralAnno = row.testLiteralAnno	 
      obj._bId = row.b
    obj
  }
 
  private def mapToTstaRow(obj: Tsta): TstaRow = {
       val testEnum = if (obj.testEnum.isDefined) Some(obj.testEnum.get.toString()) else None
    TstaRow(obj.id, obj.name, Some(toSqlDate(obj.dob)), obj.count, obj.salary, obj.flag, testEnum, obj.testLiteralAnno, obj.bId)
  } 
  
//--- retrieve and merge nested objects
  private def retrieveTstaTstcs(obj:Tsta) (implicit session: Session) : Set[Tstc] = {
    val joinQuery = for {
      tstc <- tstcQuery if tstc.tsta === obj.id
    } yield (tstc)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstcRow(_)).to[Set]
  }
  private def retrieveTstcTstes(obj:Tsta) (implicit session: Session) : Set[Tste] = {
    val joinQuery = for {
      tstc <- tstcQuery if tstc.tsta === obj.id
      tste <- tsteQuery if tste.tstcId === tstc.id
    } yield (tste)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTsteRow(_)).to[Set]
  }
  private def retrieveTsteFs(obj:Tsta) (implicit session: Session) : Set[Tstf] = {
    val joinQuery = for {
      tstc <- tstcQuery if tstc.tsta === obj.id
      tste <- tsteQuery if tste.tstcId === tstc.id
      tstf <- tstfQuery if tstf.tste === tste.id
    } yield (tstf)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstfRow(_)).to[Set]
  }
  private def retrieveTstcD(obj:Tsta) (implicit session: Session) : Set[Tstd] = {
    val joinQuery = for {
      tstc <- tstcQuery if tstc.tsta === obj.id
      tstd <- tstdQuery if tstd.id === tstc.d
    } yield (tstd)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstdRow(_)).to[Set]
  }
  private def retrieveTstaB(obj:Tsta) (implicit session: Session) : Set[Tstb] = {
    val joinQuery = for {
      tstb <- tstbQuery if tstb.id === obj.bId
    } yield (tstb)
    val rowlist = joinQuery.list
    rowlist.map(mapFromTstbRow(_)).to[Set]
  }
  private def deleteOneToManys(obj:Tsta)(implicit session: Session): Tsta = {
    val obj1 = if (isTstcsDirty(obj)) deleteOneToManyTstcs(obj) else obj
    obj1
  }
  
  private def deleteOneToManyTstcs(obj:Tsta)(implicit session: Session): Tsta = {
    val oldIds = for {
      tstcs <- tstcQuery if tstcs.tsta === obj.id
    } yield (tstcs.id)
    val newIds:Set[Long] = obj.tstcs.map(_.id.get)
    oldIds.list.to[Set].diff(newIds).map((id:Long) => deleteTstc(id))
    obj
  }
  
}
