package LPS
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class UserLogin_PragitiDev extends Simulation {

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

	val headers_2 = Map(
		"Accept" -> "*/*",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://accstorefront.c4f4c56-foodservi1-d1-public.model-t.cc.commerce.ondemand.com/fsxstorefront"

	val scn = scenario("UserLogin_PragitiDev")
		.exec(http("request_0")
			.get("/fsxstorefront/fsx/en_US/")
			.headers(headers_0))
		.pause(2)
	
		.exec(http("request_1")
			.get("/fsxstorefront/fsx/en_US/register")
			.headers(headers_0)
			.check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("loginsubmit"))
			 )
		.pause(76)
		.exec(http("request_2")
			.post("/fsxstorefront/fsx/en_US/j_spring_security_check")
			.headers(headers_0)
			.formParam("j_username", "fsx2@gmail.com")
			.formParam("j_password", "12345678")		
			//.formParam("CSRFToken", "8dbc78eb-55bc-4818-85f4-67540e401f8b")			  
			.formParam("CSRFToken", "${loginsubmit}") 
			 )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}