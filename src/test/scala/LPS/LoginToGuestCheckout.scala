package LPS

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoginToGuestCheckout extends Simulation {

  val httpProtocol = http
    .baseUrl("https://b2caccelerator.pragiti.com")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0")

  val headers_0 = Map(
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val uri1 = "https://b2caccelerator.pragiti.com/yacceleratorstorefront/electronics/en"

  val feeder = csv("/home/dell/LPS/gatling-charts-highcharts-bundle-2.3.1/user-files/CSV_Folder/HomepageToAddToCart.csv")

  val scn = scenario("LogInAsGuestCheckout")
    .feed(feeder)
    .exec(http("request_0")
      .get("/yacceleratorstorefront/electronics/en/?site=electronics")
      .headers(headers_0))
    .pause(11)
    .exec(http("request_1")
      .get("/yacceleratorstorefront/electronics/en/Brands/Canon/c/brand_10")
      .headers(headers_0))
    .pause(21)
    .exec(http("request_2")
      .get("/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Digital-Cameras/Digital-Compacts/c/576")
      .headers(headers_0))
    .pause(25)
    .exec(http("request_3")
      .get("/yacceleratorstorefront/electronics/en/cart")
      .headers(headers_0))
    .pause(42)
    .exec(http("request_4")
      .get("/yacceleratorstorefront/electronics/en/cart/checkout")
      .headers(headers_0)
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
    )
    .pause(13)
    .exec(http("request_5")
      .post("/yacceleratorstorefront/electronics/en/checkout/j_spring_security_check")
      .headers(headers_0)
      .formParam("j_username", "{user}")
      .formParam("j_password", "{password}")
      .formParam("CSRFToken", "${requestVerificationToken}"))
  //.formParam("CSRFToken", "a80acd6e-0320-4e57-b835-bc5aa57dfc2b"))

  setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}