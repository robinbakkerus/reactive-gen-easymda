/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test.dao
	
import com.easymda.util.JsonUtils
import com.easymda.util.Profile
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.DemoConfig
import flca.demo.DemoConstants
import flca.demo.DemoConstants._
import flca.demo.entity.FdTste
import flca.demo.entity.Tste
import flca.demo.entity.Tstf
import flca.demo.entity.actor.TsteDaoSrvActor
import flca.demo.entity.actor.TsteDaoSrvActor._
import flca.demo.entity.mock.TsteMock
import flca.demo.entity.mock.TstfMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTsteDao extends FunSuite {
  
  val ds = DataSource.datasource
  var dal = new DataStores(DataSource.driver)
  val db = Database.forDataSource(ds)
  
  test("create schema") {
    setup(DataSource.dbType, dal, db)
  }
  
  def setup(name: String, dal: DataStores, db: Database) {
    import dal._
    import dal.profile.simple._
  
    println("Running test against " + name)
    db withSession { implicit session: Session =>
      if (DemoConfig.dropTables) {dal.drop}
      if (DemoConfig.createTables) {dal.create}
    }
  }
    
  test("create some new tstes") {
    for (i <- 1 to 10) {
      val tste:Tste = TsteMock.makeRandom(None)
      testSaveTste(tste, dal)
    }
  }
  
  test("find all tstes") {
    val tstes = testFindTste(dal)
    assert(tstes.size > 9)
  }
  test("retrieve tste fetch complete") {
    val obj = getOneObject
    assert(TsteMock.hasAllFetched(obj))
  }
  
  test("retrieve tste without nested objects") {
    val obj = getOneObject
    val b0 = obj.fs.isEmpty 
    assert(!b0) 
  }
    
  test("update tste with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTste(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tste without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTste(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tste") {
    val obj1 = testRetrieveTste(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tste") {
    val list = testFindTste(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTste(obj.id.get, dal)
    val n2 = testFindTste(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val n1_fs = obj1.fs.size
    obj1.fs -= obj1.fs.head
    val obj2 = testSaveTste(obj1, dal)
    val n2_fs = obj2.fs.size
    assert(n2_fs == n1_fs - 1)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTste"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTsteReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTste"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TsteMock.makeRandom(None)
    val req = SaveTsteReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTste"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tste = {
    val list = testFindTste(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTste(obj.id.get, dal).get
  }
    
  def testFindTste(dal: DataStores): List[Tste] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTste
    }
  }
  
  def testRetrieveTste(id: Long, dal: DataStores, fd: Option[FdTste] = Some(FdTste())): Option[Tste] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTste(id, fd)
    }
  }
  
  def testSaveTste(tste: Tste, dal: DataStores): Tste = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTste(tste)
    }
  }
    
  def testDeleteTste(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTste(id)
    }
  }
  
}
