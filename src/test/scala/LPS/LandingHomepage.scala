package LPS

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LandingHomepage extends Simulation {

	val httpProtocol = http
		.baseUrl("https://fsx-qa.pragiti.com")
		.inferHtmlResources()
		.acceptHeader("application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")

	val headers_0 = Map("Accept-Encoding" -> "identity")

	val headers_3 = Map(
		"Accept" -> "*/*",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://fsx-qa.pragiti.com/fsxstorefront"

	val scn = scenario("LandingHomepage")
		.exec(http("request_0")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_0)
			.check(status.is(404)),
            http("request_2")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.ttf")
			.check(status.is(404)),
            http("request_3")
			.get("/fsxstorefront/fsx/en_US/cart/rollover/MiniCart?_=1563874412474")
			.headers(headers_3))
			.check(status.is(404)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}