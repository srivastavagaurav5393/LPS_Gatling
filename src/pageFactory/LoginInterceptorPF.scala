package pageFactory
	
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
//import akka.util.duration._
import pageHeaders._


object LoginInterceptorPF{
   
	
	val loginRegistrationPage= exec(http("loginRegistrationPage")
			.get("/yacceleratorstorefront/electronics/en/login")
			.headers(headers.headers_0)
			.check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken"))).pause(3)
	
	val userRegistration = exec(http("userRegistration")
			.post("/yacceleratorstorefront/electronics/en/login/register")
			.headers(headers.headers_0)
			.formParam("titleCode", "${Title}")
			.formParam("firstName", "${FirstName}")
			.formParam("lastName", "${LastName}")
			.formParam("email", "${user}")
			.formParam("pwd", "${password}")
			.formParam("checkPwd", "${checkPassword}")
			.formParam("consentForm.consentTemplateId", "MARKETING_NEWSLETTER")
			.formParam("consentForm.consentTemplateVersion", "0")
			.formParam("termsCheck", "true")
			.formParam("CSRFToken", "${requestVerificationToken}"))
	
	val loginAsRegisteredUser = exec(http("loginAsRegisteredUser")
			.post("/yacceleratorstorefront/electronics/en/login/j_spring_security_check")
			.headers(headers.headers_0)
			.formParam("j_username", "{user}")
			.formParam("j_password", "{password}")
					 
			//.formParam("j_username", "may16_1@gmail.com")
			//.formParam("j_password", "123456")
			.formParam("CSRFToken", "${requestVerificationToken}"))			
	
	val loginAsGuestUser =exec(http("loginAsGuestUser")
			.post("/yacceleratorstorefront/electronics/en/checkout/j_spring_security_check")
			.headers(headers.headers_0)
			//.formParam("j_username", "${user}")
			//.formParam("j_password", "${password}")
					 
			.formParam("j_username", "may16_1@gmail.com")
			.formParam("j_password", "123456")
			.formParam("CSRFToken", "${requestVerificationToken}"))
}
