/*
 * Generated via the com.flca generator
 */
	
package flca.demo.entity.test
	
import com.easymda.util.JsonUtils
import flca.demo.entity.Tstd
import flca.demo.entity.mock.TstdMock
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.slick.jdbc.JdbcBackend.Database
import scala.slick.util.SlickLogger
  
@RunWith(classOf[JUnitRunner])
class TestTstdMappers extends FunSuite {
  test("tstd to json") {
    val tstd1 = TstdMock.make()
    val json1 = JsonUtils.toJson(tstd1)
    println(json1)
    val tstd2 = JsonUtils.fromJson[Tstd](json1)
    println(tstd1)
    println(tstd2)
    assert(tstd1.hashCode === tstd2.hashCode)
  }
  
  test("tstd row hashcode") {
  }
}
