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
import flca.demo.entity.FdTstd
import flca.demo.entity.Tstd
import flca.demo.entity.actor.TstdDaoSrvActor
import flca.demo.entity.actor.TstdDaoSrvActor._
import flca.demo.entity.mock.TstdMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTstdDao extends FunSuite {
  
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
    
  test("create some new tstds") {
    for (i <- 1 to 10) {
      val tstd:Tstd = TstdMock.makeRandom(None)
      testSaveTstd(tstd, dal)
    }
  }
  
  test("find all tstds") {
    val tstds = testFindTstd(dal)
    assert(tstds.size > 9)
  }
  test("retrieve tstd fetch complete") {
    val obj = getOneObject
    assert(TstdMock.hasAllFetched(obj))
  }
  
  test("retrieve tstd without nested objects") {
    val obj = getOneObject
    // no nested objects to test here
  }
    
  test("update tstd with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTstd(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tstd without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTstd(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tstd") {
    val obj1 = testRetrieveTstd(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tstd") {
    val list = testFindTstd(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTstd(obj.id.get, dal)
    val n2 = testFindTstd(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val obj2 = testSaveTstd(obj1, dal)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTstd"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTstdReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTstd"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TstdMock.makeRandom(None)
    val req = SaveTstdReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTstd"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tstd = {
    val list = testFindTstd(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTstd(obj.id.get, dal).get
  }
    
  def testFindTstd(dal: DataStores): List[Tstd] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTstd
    }
  }
  
  def testRetrieveTstd(id: Long, dal: DataStores, fd: Option[FdTstd] = Some(FdTstd())): Option[Tstd] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTstd(id, fd)
    }
  }
  
  def testSaveTstd(tstd: Tstd, dal: DataStores): Tstd = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTstd(tstd)
    }
  }
    
  def testDeleteTstd(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTstd(id)
    }
  }
  
}
