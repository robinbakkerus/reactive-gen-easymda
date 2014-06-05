/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test
	
import com.easymda.util.JsonUtils
import flca.demo.entity.Tstb
import flca.demo.entity.mock.TstbMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTstbMappers extends FunSuite {
  test("tstb to json") {
    val tstb1 = TstbMock.make()
    val json1 = JsonUtils.toJson(tstb1)
    println(json1)
    val tstb2 = JsonUtils.fromJson[Tstb](json1)
    println(tstb1)
    println(tstb2)
    assert(tstb1.hashCode === tstb2.hashCode)
  }
  
  test("tstb row hashcode") {
  }
}
