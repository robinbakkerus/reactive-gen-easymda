/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.test.dao
	
import com.easymda.util.JsonUtils
import com.easymda.util.Profile
import flca.demo.DataSource
import flca.demo.DataStores
import flca.demo.DemoConfig
import flca.demo.DemoConstants
import flca.demo.DemoConstants._
import flca.demo.data.FdTstc
import flca.demo.data.Tstc
import flca.demo.data.actor.TstcDaoSrvActor
import flca.demo.data.actor.TstcDaoSrvActor._
import flca.demo.data.mock.TstcMock
import flca.demo.entity.Tste
import flca.demo.entity.mock.TsteMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
   
@RunWith(classOf[JUnitRunner])
class TestTstcDao extends FunSuite {
  
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
    
  test("create some new tstcs") {
    for (i <- 1 to 10) {
      val tstc:Tstc = TstcMock.makeRandom(None)
      testSaveTstc(tstc, dal)
    }
  }
  
  test("find all tstcs") {
    val tstcs = testFindTstc(dal)
    assert(tstcs.size > 9)
  }
  test("retrieve tstc fetch complete") {
    val obj = getOneObject
    assert(TstcMock.hasAllFetched(obj))
  }
  
  test("retrieve tstc without nested objects") {
    val obj = getOneObject
    val b0 = !obj.d.isDefined    
    val b1 = obj.tstes.isEmpty 
    b0 && b1 
  }
    
  test("update tstc with changes") {
    val obj1 = getOneObject
    //TODO obj1.name = "AAA"
    val obj2 = testSaveTstc(obj1, dal)
    //TODO assert(obj2.name === "AAA")
    println(obj2)
  }
  
  test("update tstc without changes") {
    val obj1 = getOneObject
    val obj2 = testSaveTstc(obj1, dal)
    println(obj2)
  }
  
  test("retrieve unknown tstc") {
    val obj1 = testRetrieveTstc(-1, dal, None)
    assert(obj1.isEmpty)
  }
  
  test("delete a tstc") {
    val list = testFindTstc(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testDeleteTstc(obj.id.get, dal)
    val n2 = testFindTstc(dal).size
    assert(n2 == n1-1)
  }  
  
  test("delete an onetomany element") {
    val obj1 = getOneObject
    val n1_tstes = obj1.tstes.size
    obj1.tstes -= obj1.tstes.head
    val obj2 = testSaveTstc(obj1, dal)
    val n2_tstes = obj2.tstes.size
    assert(n2_tstes == n1_tstes - 1)
  }  
  
  test("make find curl cmd") {
    val url = s"http://localhost:$HTTP_PORT/FindTstc"
    val s = CURL_CMD + "'" + "' " + url
    println(s)
  }
  
  test("make retrieve curl cmd") {
    val req = RetrieveTstcReq(1L)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/retrieveTstc"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  test("make save curl cmd") {
    val obj = TstcMock.makeRandom(None)
    val req = SaveTstcReq(obj)
val json = JsonUtils.toJson(req)
    val url = s"http://localhost:$HTTP_PORT/saveTstc"
    val s = CURL_CMD + "'" + json + "' " + url
    println(s)
  }
  
  //--- dao helpers --
  
  def getOneObject() : Tstc = {
    val list = testFindTstc(dal)
    val n1 = list.size
    val obj = list(list.size-1)
    testRetrieveTstc(obj.id.get, dal).get
  }
    
  def testFindTstc(dal: DataStores): List[Tstc] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      findTstc
    }
  }
  
  def testRetrieveTstc(id: Long, dal: DataStores, fd: Option[FdTstc] = Some(FdTstc())): Option[Tstc] = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      retrieveTstc(id, fd)
    }
  }
  
  def testSaveTstc(tstc: Tstc, dal: DataStores): Tstc = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      saveTstc(tstc)
    }
  }
    
  def testDeleteTstc(id: Long, dal: DataStores): Unit = {
    import dal._
    import dal.profile.simple._
    db withSession { implicit session =>
      deleteTstc(id)
    }
  }
  
}
