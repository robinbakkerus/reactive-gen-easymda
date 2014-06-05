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
import flca.demo.data.Tstc
import flca.demo.data.mock.TstcMock
import flca.demo.entity.FdTsta
import flca.demo.entity.Tsta
import flca.demo.entity.actor.TstaDaoSrvActor
import flca.demo.entity.actor.TstaDaoSrvActor._
import flca.demo.entity.mock.TstaMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTstaDao extends FunSuite {
  
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
    
  test("create some new tstas") {
    for (i <- 1 to 10) {
      val tsta:Tsta = TstaMock.makeRandom(None)
      testSaveTsta(tsta, dal)
    }
  }
  
  test("find all tstas") {
    val tstas = testFindTsta(dal)
    assert(tstas.size > 9)
  }
  test("retrieve tsta fetch complete") {
    val obj = getOneObject
    assert(TstaMock.hasAllFetched(obj))
  }
  
  test("retrieve tsta without nested objects") {
    val obj = getOneObject
    val b0 = !obj.b.isDefined    
    val b1 = obj.tstcs.isEmpty 
    b0 && b1 
  }
    
  test("update tsta with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTsta(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tsta without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTsta(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tsta") {
    val obj1 = testRetrieveTsta(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tsta") {
    val list = testFindTsta(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTsta(obj.id.get, dal)
    val n2 = testFindTsta(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val n1_tstcs = obj1.tstcs.size
    obj1.tstcs -= obj1.tstcs.head
    val obj2 = testSaveTsta(obj1, dal)
    val n2_tstcs = obj2.tstcs.size
    assert(n2_tstcs == n1_tstcs - 1)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTsta"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTstaReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTsta"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TstaMock.makeRandom(None)
    val req = SaveTstaReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTsta"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tsta = {
    val list = testFindTsta(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTsta(obj.id.get, dal).get
  }
    
  def testFindTsta(dal: DataStores): List[Tsta] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTsta
    }
  }
  
  def testRetrieveTsta(id: Long, dal: DataStores, fd: Option[FdTsta] = Some(FdTsta())): Option[Tsta] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTsta(id, fd)
    }
  }
  
  def testSaveTsta(tsta: Tsta, dal: DataStores): Tsta = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTsta(tsta)
    }
  }
    
  def testDeleteTsta(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTsta(id)
    }
  }
  
}
