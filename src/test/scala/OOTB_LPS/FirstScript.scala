package OOTB_LPS

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._



class FirstScript extends Simulation {

 // val httpProtocol = http.baseUrl("https://electronics.local:9002")
  val httpProtocol = http.baseUrl("https://localhost:9002/")

    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0")

  val header_1 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")


  val scn = scenario("Get HomePage")
    .exec(http("request1")
     // .get("/yacceleratorstorefront/electronics/en")
        .get("yacceleratorstorefront/?site=electronics")

      .headers(header_1)
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(10)

 // val scn = scenario("Go to login/registration page")
    .exec(http("request2")
      //.get("/login")
      .get("yacceleratorstorefront/login")
      .headers(header_1)
    )
    .pause(5)

    .exec(http("request3")
      .post("/register")
      .headers(header_1)

      .formParam("titleCode", "mr")
      .formParam("firstName", "First1")
      .formParam("lastName", "Script")
      .formParam("email", "first101@gmail.")
      .formParam("pwd", "123456")
      .formParam("checkPwd", "123456")
      .formParam("consentForm.consentTemplateId", "MARKETING_NEWSLETTER")
      .formParam("consentForm.consentTemplateVersion", "0")
      .formParam("termsCheck", "true")
     // .formParam(" CSRFToken","9be7e327-799a-45fc-8d43-01a25f782dde")
      .formParam(" CSRFToken","$(requestVerificationToken)")
     // .formParam(" CSRFToken","$(responseBody1)")
     /* .check(bodyString.saveAs("responseBody1")))
      .exec(session => {println(session("responseBody1").as[String]).session})
        .check(status.is(403))*/    )
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
