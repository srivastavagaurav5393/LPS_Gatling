package pageFactory

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
//import akka.util.duration._
import pageHeaders._


object LandingHomePage {

  val homepage = exec(http("Homepage_Call")
    .get("/US/en_US/")
    .headers(Headers.headers_0))
    .pause(4)

    .exec(http("internalRequestFor>>getminicart?")
      .get("/US/en_US/cart/getminicart?_=1560332044567")
      .headers(Headers.headers_1)

      .resources(http("internalRequestFor>>getheader?")
        .get("/US/en_US/getheader?_=1560332044568")
        .headers(Headers.headers_1),

        http("internalRequestFor>>getmobileheader")
          .get("/US/en_US/getmobileheader?_=1560332044569")
          .headers(Headers.headers_1),

        http("internalRequestFor>>bv.js")
          .get("https://apps.bazaarvoice.com/deployments/maui-jim/main_site/production/en_US/bv.js")
          .headers(Headers.headers_1),

        http("internalRequestFor>>polyfills.js")
          .get("https://cdn.bronto.com/popup/polyfills.js")
          .headers(Headers.headers_1)))
    .pause(20)
}
   
	
