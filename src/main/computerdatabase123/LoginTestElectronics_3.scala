package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._



class LoginTestElectronics_3 extends Simulation {

  val httpProtocol = http
    .baseUrl("https://electronics.local:9002")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0")

  val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val feeder = csv("/home/dell/LPS/gatling-charts-highcharts-bundle-2.3.1/user-files/CSV_Folder/LoginTest3.csv")

  val scn = scenario("Login with CSRF")
    .feed(feeder)
    .exec(http("get Home Page")
      .get("/yacceleratorstorefront/electronics/en/")
      .headers(headers_0)
      .check(
        regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
          .saveAs("requestVerificationToken")))


    .exec(http("Login")
      .post("/yacceleratorstorefront/electronics/en/j_spring_security_check")
      .headers(headers_0)
      .formParam("j_username", "${user}")
      .formParam("j_password", "${password}")
      .formParam("CSRFToken", "${requestVerificationToken}"))


 // setUp(scn.inject(atOnceUsers(21))).protocols(httpProtocol)
 // setUp(scn.inject(rampUsers(20).over(5 seconds))).protocols(httpProtocol)
  setUp(scn.inject(rampUsers(10).during(300 seconds))).protocols(httpProtocol)
  //.assertions(global.successfulRequests.percent.is(100))
}
