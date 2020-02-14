package pageFactory
	
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
//import akka.util.duration._
import pageHeaders._


object homepagePF{

	val landingHomepage = exec(http("landingHomepage")
			.get("/yacceleratorstorefront/electronics/en/?site=electronics")
			.headers(headers.headers_0))
		.pause(5)
	
	//PLP
	val Brand_PLP = exec(http("canon")
			.get("/yacceleratorstorefront/electronics/en/Brands/Canon/c/brand_10")
			.headers(headers.headers_0))
		.pause(14)	
	
	val Brand_PLP_2= exec(http("Brand_PLP_2_kodak")
			.get("/yacceleratorstorefront/electronics/en/Brands/Kodak/c/brand_88")
			.headers(headers.headers_0))
		.pause(6)
}
