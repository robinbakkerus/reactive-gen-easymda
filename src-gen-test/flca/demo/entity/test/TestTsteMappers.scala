/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test
	
import com.easymda.util.JsonUtils
import flca.demo.entity.Tste
import flca.demo.entity.mock.TsteMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTsteMappers extends FunSuite {
  test("tste to json") {
    val tste1 = TsteMock.make()
    val json1 = JsonUtils.toJson(tste1)
    println(json1)
    val tste2 = JsonUtils.fromJson[Tste](json1)
    println(tste1)
    println(tste2)
    assert(tste1.hashCode === tste2.hashCode)
  }
  
  test("tste row hashcode") {
  }
}
