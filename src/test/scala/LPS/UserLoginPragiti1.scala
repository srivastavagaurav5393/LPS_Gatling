package LPS
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class UserLoginPragiti1 extends Simulation {

	val httpProtocol = http
		.baseUrl("http://detectportal.firefox.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")

	val headers_0 = Map("Pragma" -> "no-cache")

    val uri1 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("UserLoginPragiti1")
		.exec(http("request_0")
			.get("/success.txt")
			.headers(headers_0)
			.check(bodyBytes.is(RawFileBody("UserLoginPragiti1_0000_response.txt"))))
		.pause(12)
		.exec(http("request_1")
			.get("/success.txt")
			.headers(headers_0)
			.check(bodyBytes.is(RawFileBody("UserLoginPragiti1_0001_response.txt"))))
		.pause(19)
		.exec(http("request_2")
			.get("/success.txt")
			.headers(headers_0)
			.check(bodyBytes.is(RawFileBody("UserLoginPragiti1_0002_response.txt"))))
		.pause(31)
		.exec(http("request_3")
			.get("/success.txt")
			.headers(headers_0)
			.check(bodyBytes.is(RawFileBody("UserLoginPragiti1_0003_response.txt"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}