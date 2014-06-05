/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test
	
import com.easymda.util.JsonUtils
import flca.demo.entity.Tstf
import flca.demo.entity.mock.TstfMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTstfMappers extends FunSuite {
  test("tstf to json") {
    val tstf1 = TstfMock.make()
    val json1 = JsonUtils.toJson(tstf1)
    println(json1)
    val tstf2 = JsonUtils.fromJson[Tstf](json1)
    println(tstf1)
    println(tstf2)
    assert(tstf1.hashCode === tstf2.hashCode)
  }
  
  test("tstf row hashcode") {
  }
}
