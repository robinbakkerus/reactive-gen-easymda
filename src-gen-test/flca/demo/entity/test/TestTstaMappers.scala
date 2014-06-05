/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test
	
import com.easymda.util.JsonUtils
import flca.demo.entity.Tsta
import flca.demo.entity.mock.TstaMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTstaMappers extends FunSuite {
  test("tsta to json") {
    val tsta1 = TstaMock.make()
    val json1 = JsonUtils.toJson(tsta1)
    println(json1)
    val tsta2 = JsonUtils.fromJson[Tsta](json1)
    println(tsta1)
    println(tsta2)
    assert(tsta1.hashCode === tsta2.hashCode)
  }
  
  test("tsta row hashcode") {
  }
}
