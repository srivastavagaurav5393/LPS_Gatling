package LPS
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Registration_PragitiDev extends Simulation {

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

	val scn = scenario("Registration_PragitiDev")
		.exec(http("request_0")
			.get("/fsxstorefront/fsx/en_US/")
			.headers(headers_0))
		.pause(2)
	
		.exec(http("request_5")
			.get("/fsxstorefront/fsx/en_US/register")
			.headers(headers_0)
			.check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("loginsubmit"))
			 )
		.pause(76)
		.exec(http("request_10")
			.post("/fsxstorefront/fsx/en_US/register/newcustomer")
			.headers(headers_0)
			.formParam("titleCode", "none")
			.formParam("termsCheck", "true")
			.formParam("firstName", "testing")
			.formParam("lastName", "testing")
			.formParam("phoneFull", "(201) 555-1234")
			.formParam("companyName", "FSX")
			.formParam("industry", "Faith_Based_Facility")
			.formParam("email", "fsx3@gmail.com")
			.formParam("pwd", "12345678")
			.formParam("checkPwd", "12345678")
			//.formParam("CSRFToken", "8dbc78eb-55bc-4818-85f4-67540e401f8b")
			  
			.formParam("CSRFToken", "${loginsubmit}") 
			.resources(http("request_11")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_1)
			.check(status.is(404)),
            http("request_12")
			.get("/fsxstorefront/fsx/en_US/cart/rollover/MiniCart?_=1563877281873")
			.headers(headers_2),
            http("request_13")
			.get("/fsxstorefront/fsx/en_US/my-account/list/viewListsInHeader")
			.headers(headers_2),
            http("request_14")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.woff")
			.headers(headers_1)
			.check(status.is(404)),
            http("request_15")
			.get("/fsxstorefront/_ui/responsive/common/fonts/glyphicons-halflings-regular.ttf")
			.check(status.is(404)))
		   )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}