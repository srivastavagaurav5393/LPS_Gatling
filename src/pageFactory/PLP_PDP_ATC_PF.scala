package pageFactory
	
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
//import akka.util.duration._
import pageHeaders._


object PLP_PDP_ATC_PF{	
	
	
	//AddToCart
	
	val ATC =exec(http("ATC")
			.get("/yacceleratorstorefront/electronics/en/cart")
			.headers(headers.headers_0))
			.pause(7)
	//PDP
	val PDP_3505505 = exec(http("PDP_3505505")
			.get("/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Digital-Cameras/Digital-Compacts/EasyShare-Z915-red/p/3505505")
			.headers(headers.headers_0),
			.post("/yacceleratorstorefront/electronics/en/cart/add")
			.formParam("qty","1")
			.formParam("productCodePost","3505505")
			.formParam("CSRFToken", "${requestVerificationToken}"))
		.pause(8)
	
	val PDP_493683 = exec(http("PDP_493683")
			.get("/yacceleratorstorefront/electronics/en/Open-Catalogue/Cameras/Digital-Cameras/Digital-SLR/Camera-Lenses/SCHNEIDER-KREUZNACH-XENAR-0-7X-Wide-Angle-Lens%2C-55-mm/p/493683")
			.headers(headers.headers_0))
		.pause(5)
	
}
