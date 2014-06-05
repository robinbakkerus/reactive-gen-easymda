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
import flca.demo.entity.FdTstb
import flca.demo.entity.Tstb
import flca.demo.entity.actor.TstbDaoSrvActor
import flca.demo.entity.actor.TstbDaoSrvActor._
import flca.demo.entity.mock.TstbMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTstbDao extends FunSuite {
  
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
    
  test("create some new tstbs") {
    for (i <- 1 to 10) {
      val tstb:Tstb = TstbMock.makeRandom(None)
      testSaveTstb(tstb, dal)
    }
  }
  
  test("find all tstbs") {
    val tstbs = testFindTstb(dal)
    assert(tstbs.size > 9)
  }
  test("retrieve tstb fetch complete") {
    val obj = getOneObject
    assert(TstbMock.hasAllFetched(obj))
  }
  
  test("retrieve tstb without nested objects") {
    val obj = getOneObject
    // no nested objects to test here
  }
    
  test("update tstb with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTstb(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tstb without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTstb(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tstb") {
    val obj1 = testRetrieveTstb(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tstb") {
    val list = testFindTstb(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTstb(obj.id.get, dal)
    val n2 = testFindTstb(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val obj2 = testSaveTstb(obj1, dal)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTstb"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTstbReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTstb"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TstbMock.makeRandom(None)
    val req = SaveTstbReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTstb"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tstb = {
    val list = testFindTstb(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTstb(obj.id.get, dal).get
  }
    
  def testFindTstb(dal: DataStores): List[Tstb] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTstb
    }
  }
  
  def testRetrieveTstb(id: Long, dal: DataStores, fd: Option[FdTstb] = Some(FdTstb())): Option[Tstb] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTstb(id, fd)
    }
  }
  
  def testSaveTstb(tstb: Tstb, dal: DataStores): Tstb = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTstb(tstb)
    }
  }
    
  def testDeleteTstb(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTstb(id)
    }
  }
  
}
