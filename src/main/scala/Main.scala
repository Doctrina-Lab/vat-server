import zio._
import zio.http._

object VatServer extends ZIOAppDefault:
  val app: HttpApp[Any] = 
    Routes(
      Method.GET / "germany" -> handler(Response.json("""{"vat": 19.0}""")),
      Method.GET / "netherlands" -> handler(Response.json("""{"vat": 21.0}"""))
    ).toHttpApp
  
  override val run = 
    Server.serve(app).provide(Server.default)