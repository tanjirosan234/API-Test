import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Location;
import POJO.SampleBody;
public class serializeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleBody sp=new SampleBody();
		sp.setAccuracy(50);
		sp.setAddress("29, side layout, cohen 09");
		sp.setLanguage("Macedonian");
		sp.setPhone_number("(+91) 983 893 3937");
		sp.setWebsite("https://rahulshettyacademy.com");
		sp.setName("Mite");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		sp.setTypes(myList);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		sp.setLocation(l);
		RestAssured.baseURI="https://rahulshettyacademy.com";
	Response res=	given().log().all().queryParam("key", "qaclick123").body(sp)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
		
	}

}
