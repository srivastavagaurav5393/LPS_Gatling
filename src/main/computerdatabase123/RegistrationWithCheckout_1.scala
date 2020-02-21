package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._



class RegistrationWithCheckout_1 extends Simulation {

  val httpProtocol = http
    .baseUrl("https://electronics.local:9002")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0")

  val headers_0 = Map(
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val uri1 = "https://electronics.local:9002/yacceleratorstorefront/electronics/en"

  val scn = scenario("NewUserRegistration2")
    .exec(http("request_0")
      .get("/yacceleratorstorefront/electronics/en")
      .headers(headers_0)
      .check(status.is(200))
    )
    .pause(6)
    .exec(http("request_1")
      .get("/yacceleratorstorefront/electronics/en/login")
      .headers(headers_0)
      .check(status.is(200))
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
        .saveAs("requestVerificationToken"))
    )
    .exec(http("request_2")
      .post("/yacceleratorstorefront/electronics/en/login/register")
      .headers(headers_0)
      .formParam("titleCode", "mrs")
      .formParam("firstName", "test92")
      .formParam("lastName", "demo")
      .formParam("email", "test92@gmail.com")
      .formParam("pwd", "123456")
      .formParam("checkPwd", "123456")
      .formParam("consentForm.consentTemplateId", "MARKETING_NEWSLETTER")
      .formParam("consentForm.consentTemplateVersion", "0")
      .formParam("termsCheck", "true")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .check(status.is(200))
    )
    .exec(http("request_3")
      .get("/yacceleratorstorefront/electronics/en")
      .headers(headers_0)
    )

    .pause(18)
    .exec(http("request_4")
      .get("/yacceleratorstorefront/electronics/en/Open-Catalogue/Data-storage/Flash-Memory/32GB-SDHC-Card/p/1641905")
      .headers(headers_0)
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
      .check(status.is(200))
    )

    .pause(1)
    .exec(http("request_5")
      .post("/yacceleratorstorefront/electronics/en/cart/add")
      .headers(headers_0)
      .formParam("qty", "1")
      .formParam("productCodePost", "1641905")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .check(status.is(200))
    )
    .exec(http("request_6")
      .get("/yacceleratorstorefront/electronics/en/cart")
      .headers(headers_0))
    .exec(http("request_7")
      .get("/yacceleratorstorefront/electronics/en/cart/checkout")
      .headers(headers_0)
      .check(status.is(200))
    )
    .exec(http("request_8")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/delivery-address/add")
      .headers(headers_0)
      .check(status.is(200))
    )

    /*	.exec(http("request_9")
           .get("/yacceleratorstorefront/electronics/en/my-account/addressform?addressCode=&countryIsoCode=US")
            .headers(headers_0)
            .check(status.is(200))
            )*/
    .exec(http("request_10")
    .get("/yacceleratorstorefront/electronics/en/my-account/addressform?addressCode=&countryIsoCode=US")
    .headers(headers_0)
    .check(status.is(200))
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
  )
    .exec(http("request_11")
      .post("/yacceleratorstorefront/electronics/en/checkout/multi/delivery-address/add")
      .headers(headers_0)
      .formParam("addressId", "")
      .formParam("bill_state", "")
      .formParam("countryIso", "US")
      .formParam("titleCode", "mr")
      .formParam("firstName", "Test")
      .formParam("lastName", "LPS")
      .formParam("line1", "SMALLSYS INC")
      .formParam("line2", "795 E DRAGRAM")
      .formParam("townCity", "TUCSON")
      .formParam("regionIso", "US-AZ")
      .formParam("postcode", "85705")
      .formParam("phone", "")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .formParam("saveInAddressBook", "true")
      .formParam("_saveInAddressBook", "on")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .check(status.is(200))
    )

    .exec(http("request_12")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/delivery-method/choose")
      .headers(headers_0)
      .check(status.is(200))
      //.check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
    )
    .exec(http("request_13")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/delivery-method/select?delivery_method=standard-gross")
      .headers(headers_0)
    )



    .exec(http("request_15")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/payment-method/add")
      .headers(headers_0)
      .check(status.is(200))
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
    )

    .exec(http("request_14")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/sop/billingaddressform?countryIsoCode=US&useDeliveryAddress=true")
      .headers(headers_0)
      .check(status.is(200))
    )


    .exec(http("request_17")
      .post("/acceleratorservices/sop-mock/process")
      //.post("/yacceleratorstorefront/electronics/en/checkout/multi/payment-method/add")
      .headers(headers_0)
      .formParam("orderPage_receiptResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_declineResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_cancelResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_version", "7")
      .formParam("amount", "0")
      .formParam("orderPage_timestamp", "1554897396128")
      .formParam("orderPage_transactionType", "subscription")
      .formParam("merchantID", "your_merchant_id")
      .formParam("orderPage_signaturePublic", "bol26Moh382PfX+32QpqbbRLo1A=")
      .formParam("currency", "USD")
      .formParam("orderPage_serialNumber", "your_serial_number")
      .formParam("recurringSubscriptionInfo_signaturePublic", "g69zjEUumCsLHUbiKOroeFixcyg=")
      .formParam("recurringSubscriptionInfo_automaticRenew", "false")
      .formParam("recurringSubscriptionInfo_amount", "0")
      .formParam("recurringSubscriptionInfo_startDate", "20190410")
      .formParam("recurringSubscriptionInfo_numberOfPayments", "0")
      .formParam("recurringSubscriptionInfo_frequency", "on-demand")
      .formParam("billTo_email", "gh@gmail.com")
      .formParam("card_cardType", "001")
      .formParam("card_nameOnCard", "Gaurav")
      .formParam("card_accountNumber", "4111111111111111")
      .formParam("card_expirationMonth", "10")
      .formParam("card_expirationYear", "2028")
      .formParam("card_cvNumber", "123")
      .formParam("card_issueNumber", "")
      .formParam("_savePaymentInfo", "on")
      .formParam("useDeliveryAddress", "true")
      .formParam("_useDeliveryAddress", "on")
      .formParam("billTo_email", "gh@gmail.com")
      .formParam("billTo_email", "gh@gmail.com")
      .formParam("billTo_country", "US")
      .formParam("billTo_titleCode", "Mr.")
      .formParam("billTo_firstName", "Gaurav")
      .formParam("billTo_lastName", "Srivastava")
      .formParam("billTo_street1", "795+E+DRAGRAM")
      .formParam("billTo_street2", "")
      .formParam("billTo_city", "TUCSON")
      .formParam("billTo_state", "AZ")
      .formParam("billTo_postalCode", "85705")
      .formParam("billTo_phoneNumber", "")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .check(status.is(200))
    )
    .exec(http("request_18")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/summary/view")
      .headers(headers_0)
      // .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
      .check(status.is(200))
    )
    .exec(http("request_19")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/summary/placeOrder")
      .headers(headers_0)
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))
      .check(status.is(200))
    )
    .exec(http("request_20")
      .post("/yacceleratorstorefront/electronics/en/checkout/multi/summary/placeOrder")
      .headers(headers_0)
      .formParam("termsCheck", "true")
      .formParam("_termsCheck", "on")
      .formParam("CSRFToken", "${requestVerificationToken}")
      .check(status.is(200))
    )
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}