package OOTB_LPS

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._



class demo extends Simulation {

  val httpProtocol = http
    .baseUrl("https://electronics.local:9002")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0")

  val headers_0 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val scn = scenario("ElectronicsCheckout1")
    .exec(http("request_0")
      .get("/yacceleratorstorefront/electronics/en/")
      .headers(headers_0)
    )
    .exec(http("Login")
      .post("/yacceleratorstorefront/electronics/en/j_spring_security_check")
      .headers(headers_0)
      .formParam("j_username", "gauravs@pragiti.com")
      .formParam("j_password", "testing@123")
      .formParam("CSRFToken", "56c28bf7-8201-43e1-a526-c96fa5970025")
    )
    .exec(http("Click On Brands")
      .get("/yacceleratorstorefront/electronics/en/Brands/c/brands")
      .headers(headers_0)
    )
    //Product Information
    .exec(http("Add product into cart")
    .post("/yacceleratorstorefront/electronics/en/cart/add")
    .headers(headers_0)
    .formParam("productCodePost", "3708646")
    .formParam("productNamePost", "EOS 500D   18-55mm IS   EF-S 55-250 IS")
    .formParam("productPostPrice", "970.0")
    .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
  )
    .exec(http("Click on Checkout")
      .get("/yacceleratorstorefront/electronics/en/cart/checkout")
      .headers(headers_0)
    )
    .exec(http("Add delivery address")
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
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
      .formParam("saveInAddressBook", "true")
      .formParam("_saveInAddressBook", "on")
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
    )
    .exec(http("select delivery method")
      .get("/yacceleratorstorefront/electronics/en/checkout/multi/delivery-method/select?delivery_method=standard-gross")
      .headers(headers_0)
    )
    .exec(http("request_839")
      .post("/acceleratorservices/sop-mock/process")
      .headers(headers_0)
      .formParam("orderPage_receiptResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_declineResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_cancelResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_version", "7")
      .formParam("amount", "0")
      .formParam("orderPage_timestamp", "1554298257459")
      .formParam("orderPage_transactionType", "subscription")
      .formParam("merchantID", "your_merchant_id")
      .formParam("orderPage_signaturePublic", "BzPfB1/SwvMbekIa1dGj7KJh/g4=")
      .formParam("currency", "USD")
      .formParam("orderPage_serialNumber", "your_serial_number")
      .formParam("recurringSubscriptionInfo_signaturePublic", "c7DIvc659wAA6NY56XQp6Aujl3k=")
      .formParam("recurringSubscriptionInfo_automaticRenew", "false")
      .formParam("recurringSubscriptionInfo_amount", "0")
      .formParam("recurringSubscriptionInfo_startDate", "20190403")
      .formParam("recurringSubscriptionInfo_numberOfPayments", "0")
      .formParam("recurringSubscriptionInfo_frequency", "on-demand")
      .formParam("billTo_email", "gauravs@pragiti.com")
      .formParam("card_cardType", "001")
      .formParam("card_nameOnCard", "VISA")
      .formParam("card_accountNumber", "4111111111111111")
      .formParam("card_expirationMonth", "4")
      .formParam("card_expirationYear", "2022")
      .formParam("card_cvNumber", "212")
      .formParam("card_issueNumber", "")
      .formParam("savePaymentInfo", "true")
      .formParam("_savePaymentInfo", "on")
      .formParam("useDeliveryAddress", "true")
      .formParam("_useDeliveryAddress", "on")
      .formParam("billTo_email", "gauravs@pragiti.com")
      .formParam("billTo_email", "gauravs@pragiti.com")
      .formParam("billTo_country", "US")
      .formParam("billTo_titleCode", "mr")
      .formParam("billTo_firstName", "Test")
      .formParam("billTo_lastName", "LPS")
      .formParam("billTo_street1", "SMALLSYS INC")
      .formParam("billTo_street2", "795 E DRAGRAM")
      .formParam("billTo_city", "TUCSON")
      .formParam("billTo_state", "AZ")
      .formParam("billTo_postalCode", "85705")
      .formParam("billTo_phoneNumber", "")
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
    )

    .exec(http("request_843")
      .post("/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .headers(headers_0)
      .formParam("billTo_city", "TUCSON")
      .formParam("billTo_email", "gauravs@pragiti.com")
      .formParam("recurringSubscriptionInfo_automaticRenew", "false")
      .formParam("decision_publicSignature", "mEhlMRLCsuPimhp50ElrY94zFyc=")
      .formParam("billTo_titleCode", "mr")
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
      .formParam("billTo_country", "US")
      .formParam("billTo_lastName", "LPS")
      .formParam("billTo_street2", "795 E DRAGRAM")
      .formParam("ccAuthReply_cvCode", "M")
      .formParam("billTo_street1", "SMALLSYS INC")
      .formParam("orderPage_declineResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("orderPage_transactionType", "subscription")
      .formParam("_savePaymentInfo", "on")
      .formParam("card_cardType", "001")
      .formParam("recurringSubscriptionInfo_startDate", "20190403")
      .formParam("useDeliveryAddress", "true")
      .formParam("recurringSubscriptionInfo_frequency", "on-demand")
      .formParam("orderPage_signaturePublic", "BzPfB1/SwvMbekIa1dGj7KJh/g4=")
      .formParam("currency", "USD")
      .formParam("reasonCode", "100")
      .formParam("card_accountNumber", "************1111")
      .formParam("orderPage_serialNumber", "your_serial_number")
      .formParam("recurringSubscriptionInfo_signaturePublic", "c7DIvc659wAA6NY56XQp6Aujl3k=")
      .formParam("paySubscriptionCreateReply_subscriptionID", "4d60c36e-60f4-45fd-afff-05e7b2ce0fe0")
      .formParam("amount", "0")
      .formParam("card_issueNumber", "")
      .formParam("decision", "ACCEPT")
      .formParam("recurringSubscriptionInfo_numberOfPayments", "0")
      .formParam("card_nameOnCard", "VISA")
      .formParam("orderPage_receiptResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("billTo_postalCode", "85705")
      .formParam("orderPage_version", "7")
      .formParam("orderPage_timestamp", "1554298257459")
      .formParam("_useDeliveryAddress", "on")
      .formParam("billTo_firstName", "Test")
      .formParam("billTo_state", "AZ")
      .formParam("card_expirationMonth", "4")
      .formParam("recurringSubscriptionInfo_amount", "0")
      .formParam("merchantID", "your_merchant_id")
      .formParam("orderPage_cancelResponseURL", "https://electronics.local:9002/yacceleratorstorefront/electronics/en/checkout/multi/sop/response")
      .formParam("card_expirationYear", "2022")
      .formParam("billTo_phoneNumber", "")
      .formParam("paySubscriptionCreateReply_subscriptionIDPublicSignature", "m8Lcp80QyfTtFdokfJZfH482f2o=")
      .formParam("savePaymentInfo", "true")
    )

    .exec(http("Placed Order")
      .post("/yacceleratorstorefront/electronics/en/checkout/multi/summary/placeOrder")
      .headers(headers_0)
      .formParam("termsCheck", "true")
      .formParam("_termsCheck", "on")
      .formParam("CSRFToken", "b5aca3b6-51e0-4d9a-b421-5db7ef0f5d33")
    )

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}