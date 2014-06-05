/*
 * Generated via the com.flca generator
 */
	
package flca.demo.test.mock
	
import com.easymda.util.JsonUtils
import flca.demo.dto.mock.TstDtoMock
import flca.demo.entity.mock.TstaMock
import java.io.File
import java.io.PrintWriter
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
 
@RunWith(classOf[JUnitRunner])
class DemoJsonMocks extends FunSuite {
  
  val tmpdir = System.getProperty("java.io.tmpdir")
     
  test("saveTsta") {
	val json = JsonUtils.toJson(TstaMock.makeRandom(None))
    writeFile("saveTsta.json", json)  
  }  
    
  test("findTsta") {
    val list = List(TstaMock.makeRandom(None), TstaMock.makeRandom(None), TstaMock.makeRandom(None))
	val json = JsonUtils.toJson(list)
    writeFile("findTsta.json", json)  
  }
    
  test("retrieveTsta") {
	val json = JsonUtils.toJson(TstaMock.makeRandom(Some(100)))
    writeFile("retrieveTsta.json", json)  
  }  
    
  test("helloWorld") {
	val json = JsonUtils.toJson("TODO")
    writeFile("helloWorld.json", json)  
  }
  
  test("pingMe") {
	val json = JsonUtils.toJson("TODO")
    writeFile("pingMe.json", json)  
  }
  
  test("saveTestA") { 
	val json = JsonUtils.toJson(TstaMock.makeRandom(None))
    writeFile("saveTestA.json", json)  
  }
  
  test("searchTestA") {
	val json = JsonUtils.toJson("TODO")
    writeFile("searchTestA.json", json)  
  }
  
  test("getDto") { 
	val json = JsonUtils.toJson(TstDtoMock.makeRandom(None))
    writeFile("getDto.json", json)  
  }
  
  test("ping") {
	val json = JsonUtils.toJson("TODO")
    writeFile("ping.json", json)  
  }
  
  test("doSomething") {
	val json = JsonUtils.toJson("TODO")
    writeFile("doSomething.json", json)  
  }
  
  
  private def writeFile(name: String, text: String): Unit = {
    val fname = tmpdir + "/" + name
	val writer = new PrintWriter(new File(fname))
    writer.write(text)
    writer.close()
    println("created " + fname)
  }
}
