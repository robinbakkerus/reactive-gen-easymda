/*
 * Generated via the com.flca generator
 */
	
package flca.demo
	 
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.util.Failure
import scala.util.Success
import spray.http.StatusCodes
import spray.routing._

trait DemoStaticRoute extends HttpService {  

  def staticPrefixes = List("web", "dojoweb") map { pathPrefix(_) } reduce { _ | _ }

  def stripLeadingSlash(path: String) = if (path startsWith "/") path.tail else path

  val staticPath =
    staticPrefixes &
      //      cache(routeCache()) &
      extract(ctx ⇒ stripLeadingSlash(ctx.request.uri.path.toString))

  val staticRoutes =
    get {
      staticPath { path ⇒
        getFromResource(path.toString)
      }
    }
}
