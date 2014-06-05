package flca.demo
import java.util.concurrent.TimeUnit
import com.typesafe.config.Config
import akka.actor._
import scala.concurrent.duration.FiniteDuration
 
class AkkaSettings (config: Config, extendedSystem: ExtendedActorSystem) extends Extension {
 
  object Http {
    val Port = config.getInt(DemoConfig.APP_NAME  + ".http.port")
    val Host = config.getString(DemoConfig.APP_NAME  + ".http.host")
  }
 
  val askTimeout = FiniteDuration(config.getMilliseconds(DemoConfig.APP_NAME  + "ask-timeout"), TimeUnit.MILLISECONDS)
}
 
object AkkaSettings extends ExtensionId[AkkaSettings] with ExtensionIdProvider {
  override def lookup = AkkaSettings
  override def createExtension(system: ExtendedActorSystem) = new AkkaSettings(system.settings.config, system)
 
  def apply(context: ActorContext): AkkaSettings = apply(context.system)
}
