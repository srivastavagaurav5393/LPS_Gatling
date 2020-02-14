package LPS
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class UserLoginPragiti extends Simulation {

	val httpProtocol = http
		.baseUrl("https://fsx-dev.pragiti.com")
		.inferHtmlResources()
		.acceptHeader("application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept-Encoding" -> "identity")

	val headers_3 = Map(
		"Accept" -> "*/*",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_5 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Cache-Control" -> "max-age=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept-Encoding" -> "identity",
		"Cache-Control" -> "max-age=0")

	val headers_9 = Map("Cache-Control" -> "max-age=0")

	val headers_10 = Map(
		"Accept" -> "*/*",
		"Cache-Control" -> "max-age=0",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://fsx-dev.pragiti.com/fsxstorefront"

	val scn = scenario("UserLoginPragiti")
		.exec(http("request_0")
			.get("/fsxstorefront/fsx/en_US/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_1)
			.check(status.is(404)),
            http("request_2")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_1)
			.check(status.is(404)),
            http("request_3")
			.get("/fsxstorefront/fsx/en_US/cart/rollover/MiniCart?_=1563888103434")
			.headers(headers_3),
            http("request_4")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.ttf")
			.check(status.is(404))))
		.pause(24)
		.exec(http("request_5")
			.get("/fsxstorefront/fsx/en_US/")
			.headers(headers_5)
			.resources(http("request_6")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_6)
			.check(status.is(404)),
            http("request_7")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_6)
			.check(status.is(404)),
            http("request_8")
			.get("/fsxstorefront/fsx/en_US/cart/rollover/MiniCart?_=1563888129325")
			.headers(headers_3),
            http("request_9")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.ttf")
			.headers(headers_9)
			.check(status.is(404)),
            http("request_10")
			.get("/fsxstorefront/fsx/en_US/my-account/list/viewListsInHeader")
			.headers(headers_10)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}