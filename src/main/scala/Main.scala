import zio._
import zio.http._

object VatServer extends ZIOAppDefault:
  val app: HttpApp[Any] = 
    Routes(
      Method.GET / "germany" -> handler(Response.text(f"${19.0}%.2f")),
      Method.GET / "netherlands" -> handler(Response.text(f"${21.0}%.2f"))
    ).toHttpApp
  
  override val run = 
    Server.serve(app).provide(Server.default)