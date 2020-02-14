package pageFactory

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
//import akka.util.duration._
import pageHeaders._


object SearchOperation_SLP_TO_PDP {


  val uri01 = "https://connect.facebook.net"
  val uri2 = "https://mauijim.zendesk.com/embeddable_blip"
  val uri3 = "https://vars.hotjar.com/box-90f3a29ef7448451db5af955688970d7.html"
  val uri04 = "https://www.google-analytics.com"
  val uri09 = "https://cdn.bronto.com"
  val uri19 = "https://assets.zendesk.com/embeddable_framework/main.js"
  val uri29 = "https://px.steelhousemedia.com/st"
  val uri30 = "https://ds-aksb-a.akamaihd.net"
  val uri31 = "https://mauijim.zendesk.com/embeddable_blip"


  val SearchOperation = exec(http("request_181")
    .get("/US/en_US/search/?text=mav")
    .headers(Headers.headers_74))
    .pause(30)
    .exec(http("request_182")
      .get("/ruxitagentjs_ICA2SVfqru_10169190521113456.js")
      .headers(Headers.headers_1))
    .exec(http("request_241")
      .get(uri19 + "")
      .headers(Headers.headers_6))
    .pause(20)


  val SLP_TO_PDP = exec(http("request_273")
    .get(uri09 + "/popup/polyfills.js")
    .headers(Headers.headers_1)
    .resources(http("request_274")
      .get(uri30 + "/2/227028/b?dE=0&cS=0&cE=0&rqS=52&rsS=3616&rsE=3651&sS=-20&dl=3629&di=6011&fp=&dlS=6707&dlE=6834&dc=11361&leS=11363&leE=11411&to=&ol=0&cr=123&mt=&mb=&b=133377&u=https%3A//www.mauijim.com/US/en_US/search/&ua=Mozilla/5.0%20%28X11%3B%20Ubuntu%3B%20Linux%20x86_64%3B%20rv%3A67.0%29%20Gecko/20100101%20Firefox/67.0&pl=Linux%20x86_64&us=&gh=23.43.48.38&t=&rid=49661cc&r=31212&akM=b&akN=ae&vc=14:17&bpcip=dce35500&akTX=1&akTI=49661cc&ai=432276&pmgn=&pmgi=&pmp=")
      .headers(Headers.headers_70),
      http("request_275")
        .get(uri09 + "/popup/eac4422f-79b9-4308-9e87-ccd41cf97942/config.js")
        .headers(Headers.headers_1),
      http("request_276")
        .get(uri31 + "?type=userAction&data=eyJjaGFubmVsIjoid2ViX3dpZGdldCIsInVzZXJBY3Rpb24iOnsiY2F0ZWdvcnkiOiJhcGkiLCJhY3Rpb24iOiIkem9waW0ubGl2ZWNoYXQuZGVwYXJ0bWVudHMuZ2V0RGVwYXJ0bWVudCIsImxhYmVsIjpudWxsLCJ2YWx1ZSI6eyJhcmdzIjoiQ3VzdG9tZXIgU2VydmljZSJ9fSwiYnVpZCI6IjdiMGJlZTQwNmJhODVkNTkwODZhNWNiNDRiZjM2MjllIiwic3VpZCI6IjRhZjcyN2FjMTY4NjFiMzNiNWRkY2RjMTE4ZTFlM2Y2IiwidmVyc2lvbiI6ImFhZWYzMzE2OSIsInRpbWVzdGFtcCI6IjIwMTktMDYtMTNUMDg6MjM6MTMuNTczWiIsInVybCI6Imh0dHBzOi8vd3d3Lm1hdWlqaW0uY29tL1VTL2VuX1VTL3NlYXJjaC8%2FdGV4dD1tYXYifQ%3D%3D")
        .headers(Headers.headers_47),
      http("request_277")
        .get(uri04 + "/analytics.js")
        .headers(Headers.headers_1),
      http("request_278")
        .get(uri04 + "/gtm/js?id=GTM-W7LZ9ND&cid=317398722.1560406655")
        .headers(Headers.headers_1)))
    .pause(10)
    .exec(http("request_279")
      .get("/US/en_US/shop/sunglasses/aviators/mavericks?variantCode=B264-17")
      .headers(Headers.headers_74))
    .pause(20)

    .exec(http("request_390")
      .get(uri01 + "/signals/config/122084984869781?v=2.8.52&r=stable")
      .headers(Headers.headers_1)
      .resources(http("request_391")
        .get(uri29 + "?fdx=1&ga_tracking_id=UA-15587398-7&ga_client_id=317398722.1560406655&shpt=Mavericks%20Polarized%20Sunglasses%20%7C%20Maui%20Jim%C2%AE&ga_info=%7B%22status%22%3A%22OK%22%2C%22ga_tracking_id%22%3A%22UA-15587398-7%22%2C%22ga_client_id%22%3A%22317398722.1560406655%22%2C%22shpt%22%3A%22Mavericks%20Polarized%20Sunglasses%20%7C%20Maui%20Jim%C2%AE%22%2C%22execution_workflow%22%3A%7B%22iteration%22%3A1%2C%22getTrackingIdByGA%22%3A%22OK%22%2C%22getClientIdByTracker%22%3A%22FAILED%22%2C%22getClientIdByGA%22%3A%22OK%22%2C%22shpt%22%3A%22OK%22%7D%7D&shaid=30596&tdr=https%3A%2F%2Fwww.mauijim.com%2FUS%2Fen_US%2Fsearch%2F%3Ftext%3Dmav&plh=https%3A%2F%2Fwww.mauijim.com%2FUS%2Fen_US%2Fshop%2Fsunglasses%2Faviators%2Fmavericks%3FvariantCode%3DB264-17&dxver=4.0.0&cb=32928158843371636term%3Dvalue&shpn=MAVERICKS&shpp=299.00&shps=MAVERICKS&shpc=Maui%20Jim&shcq=0&shpic=1&shpi=https%3A%2F%2Fimages.mauijim.com%2Fsunglasses%2F264%2FB264-17_front.jpg%3Fimwidth%3D900")
        .headers(Headers.headers_6),
        http("request_392")
          .get(uri31 + "?type=userAction&data=eyJjaGFubmVsIjoid2ViX3dpZGdldCIsInVzZXJBY3Rpb24iOnsiY2F0ZWdvcnkiOiJhcGkiLCJhY3Rpb24iOiIkem9waW0ubGl2ZWNoYXQuZGVwYXJ0bWVudHMuZ2V0RGVwYXJ0bWVudCIsImxhYmVsIjpudWxsLCJ2YWx1ZSI6eyJhcmdzIjoiQ3VzdG9tZXIgU2VydmljZSJ9fSwiYnVpZCI6IjdiMGJlZTQwNmJhODVkNTkwODZhNWNiNDRiZjM2MjllIiwic3VpZCI6IjRhZjcyN2FjMTY4NjFiMzNiNWRkY2RjMTE4ZTFlM2Y2IiwidmVyc2lvbiI6ImFhZWYzMzE2OSIsInRpbWVzdGFtcCI6IjIwMTktMDYtMTNUMDg6MjM6MjEuOTIwWiIsInVybCI6Imh0dHBzOi8vd3d3Lm1hdWlqaW0uY29tL1VTL2VuX1VTL3Nob3Avc3VuZ2xhc3Nlcy9hdmlhdG9ycy9tYXZlcmlja3M%2FdmFyaWFudENvZGU9QjI2NC0xNyJ9")
          .headers(Headers.headers_47)))
    .pause(30)
    .exec(http("request_393")
      .get("/_ui/responsive/theme-mauijimb2c/js/utils.js")
      .headers(Headers.headers_364)
      .resources(http("request_394")
        .get(uri09 + "/popup/polyfills.js")
        .headers(Headers.headers_1),
        http("request_395")
          .get(uri30 + "/2/227028/b?dE=0&cS=0&cE=0&rqS=72&rsS=243&rsE=253&sS=1&dl=290&di=1794&fp=&dlS=1799&dlE=1937&dc=9403&leS=9407&leE=9469&to=&ol=0&cr=123&mt=&mb=&b=133409&u=https%3A//www.mauijim.com/US/en_US/shop/sunglasses/aviators/mavericks&ua=Mozilla/5.0%20%28X11%3B%20Ubuntu%3B%20Linux%20x86_64%3B%20rv%3A67.0%29%20Gecko/20100101%20Firefox/67.0&pl=Linux%20x86_64&us=&gh=23.43.48.38&t=&rid=49692ab&r=31212&akM=b&akN=ae&vc=14:17&bpcip=dce35500&akTX=1&akTI=49692ab&ai=432276&pmgn=&pmgi=&pmp=")
          .headers(Headers.headers_70),
        http("request_396")
          .get(uri09 + "/popup/eac4422f-79b9-4308-9e87-ccd41cf97942/config.js")
          .headers(Headers.headers_1),
        http("request_397")
          .get(uri04 + "/analytics.js")
          .headers(Headers.headers_1),
        http("request_398")
          .get(uri04 + "/gtm/js?id=GTM-W7LZ9ND&cid=317398722.1560406655")
          .headers(Headers.headers_1)))
}
