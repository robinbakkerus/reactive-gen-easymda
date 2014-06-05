/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	
import com.easymda.util.ActorContextCreationSupport
import com.easymda.util.CreationSupport
import flca.demo.entity.route.TstaDaoRoute
import flca.demo.srv.TstServiceRoute
import org.json4s.DefaultFormats
import org.json4s.Formats
import spray.routing._
 
class Reception extends HttpServiceActor with ActorContextCreationSupport 
 with DemoStaticRoute with TstaDaoRoute with TstServiceRoute {
 
  implicit def json4sFormats: Formats = DefaultFormats
  
  def receive = runRoute(
	staticRoutes ~
    helloWorldRoute ~ 
    pingMeRoute ~ 
    saveTestARoute ~ 
    searchTestARoute ~ 
    getDtoRoute ~ 
    pingRoute ~ 
    doSomethingRoute ~ 
    findTstaRoute ~ retrieveTstaRoute ~ saveTstaRoute 
  )
  
  implicit def executionContext = actorRefFactory.dispatcher
}
