package requestBody;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import pojo.Location;
import pojo.allRequest;

public class newRequest {
	
	
	
	@Test(priority = 0, description = "This code is used to pass payload through Code",groups = "Sanity", invocationCount = 1)
	public void reqBody() {
		Location l= new Location();
		allRequest req=new allRequest();
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		req.setLocation(l);
		req.setAccuracy(50);
		req.setName("Frontline house");
		req.setPhone_number("(+91) 983 893 3937");
		req.setAddress("29, side layout, cohen 09");
		List<String> ty= new ArrayList<>();
		ty.add("shoe park");
		ty.add("shop");
		req.setTypes(ty);
		req.setWebsite("http://google.com");
		req.setLanguage("French-IN");
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(req).
		when().post("maps/api/place/add/json").
		then().and().log().all().assertThat().statusCode(200);	
		
	}

}
