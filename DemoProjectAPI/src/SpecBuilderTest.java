import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Location;
import POJO.SampleBody;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleBody sp = new SampleBody();
		sp.setAccuracy(50);
		sp.setAddress("29, side layout, cohen 09");
		sp.setLanguage("Macedonian");
		sp.setPhone_number("(+91) 983 893 3937");
		sp.setWebsite("https://rahulshettyacademy.com");
		sp.setName("Mite");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		sp.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		sp.setLocation(l);

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
ResponseSpecification ressspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification res = given().spec(req).body(sp);

		Response respone=res.when().post("/maps/api/place/add/json").then().spec(ressspec).extract().response();

		String responseString = respone.asString();
		System.out.println(responseString);

	}

}
