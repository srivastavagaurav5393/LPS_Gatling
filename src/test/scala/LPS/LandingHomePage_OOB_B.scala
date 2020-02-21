package LPS

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LandingHomePage_OOB_B extends Simulation{


  val httpProtocol = http
    .baseUrl("https://accstorefront.c4f4c56-foodservi1-d1-public.model-t.cc.commerce.ondemand.com")
    .inferHtmlResources()
    .acceptHeader("application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")

  val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Upgrade-Insecure-Requests" -> "1")

  val scn_1 = scenario("Registration")
    .exec(http("request_0")
      .get("/fsxstorefront/?site=fsx")
      .headers(headers_0))
    .pause(2)

  setUp(scn_1.inject(atOnceUsers(1))).protocols(httpProtocol)
}
