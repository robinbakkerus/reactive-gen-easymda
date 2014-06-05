/*
 * Generated via the com.flca generator
 */
	
package flca.demo.data.test
	
import com.easymda.util.JsonUtils
import flca.demo.data.Tstc
import flca.demo.data.mock.TstcMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTstcMappers extends FunSuite {
  test("tstc to json") {
    val tstc1 = TstcMock.make()
    val json1 = JsonUtils.toJson(tstc1)
    println(json1)
    val tstc2 = JsonUtils.fromJson[Tstc](json1)
    println(tstc1)
    println(tstc2)
    assert(tstc1.hashCode === tstc2.hashCode)
  }
  
  test("tstc row hashcode") {
  }
}
