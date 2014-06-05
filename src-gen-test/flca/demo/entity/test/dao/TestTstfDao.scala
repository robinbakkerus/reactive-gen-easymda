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
import flca.demo.entity.FdTstf
import flca.demo.entity.Tstf
import flca.demo.entity.actor.TstfDaoSrvActor
import flca.demo.entity.actor.TstfDaoSrvActor._
import flca.demo.entity.mock.TstfMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTstfDao extends FunSuite {
  
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
    
  test("create some new tstfs") {
    for (i <- 1 to 10) {
      val tstf:Tstf = TstfMock.makeRandom(None)
      testSaveTstf(tstf, dal)
    }
  }
  
  test("find all tstfs") {
    val tstfs = testFindTstf(dal)
    assert(tstfs.size > 9)
  }
  test("retrieve tstf fetch complete") {
    val obj = getOneObject
    assert(TstfMock.hasAllFetched(obj))
  }
  
  test("retrieve tstf without nested objects") {
    val obj = getOneObject
    // no nested objects to test here
  }
    
  test("update tstf with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTstf(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tstf without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTstf(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tstf") {
    val obj1 = testRetrieveTstf(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tstf") {
    val list = testFindTstf(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTstf(obj.id.get, dal)
    val n2 = testFindTstf(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val obj2 = testSaveTstf(obj1, dal)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTstf"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTstfReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTstf"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TstfMock.makeRandom(None)
    val req = SaveTstfReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTstf"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tstf = {
    val list = testFindTstf(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTstf(obj.id.get, dal).get
  }
    
  def testFindTstf(dal: DataStores): List[Tstf] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTstf
    }
  }
  
  def testRetrieveTstf(id: Long, dal: DataStores, fd: Option[FdTstf] = Some(FdTstf())): Option[Tstf] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTstf(id, fd)
    }
  }
  
  def testSaveTstf(tstf: Tstf, dal: DataStores): Tstf = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTstf(tstf)
    }
  }
    
  def testDeleteTstf(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTstf(id)
    }
  }
  
}
