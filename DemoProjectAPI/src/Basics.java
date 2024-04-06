import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.ReusableMethods;
import files.payload;
public class Basics {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//Validate if ADD Pace API is working as expected
		
		//given - all input details
		//when - Submit the API - resource, http method
		//then - validate the response
		//Add place and update Place with new address then Get Place to validate if new address is present in response
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(GenerateStringFromResource("C:\\User\\")).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		 JsonPath js=	ReusableMethods.rawToJson1(response);//for passing Json
	String placeId=	js.getString("place_id");
	System.out.println( "placeID:" + placeId);
		
		
		//update place
	String newAddress = "71 winter walk, USA";
	
	given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json")
	.body("{\n"
			+ "\"place_id\":\""+placeId+"\",\n"
			+ "\"address\":\""+newAddress+"\",\n"
			+ "\"key\":\"qaclick123\"\n"
			+ "}")
	.when().put("maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	
		//get place
	String getPlaceResponse=  given().log().all().queryParam("key","qaclick123")
	  .queryParam("place_id",placeId)
	.when().get("maps/api/place/get/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	 JsonPath js1= ReusableMethods.rawToJson(getPlaceResponse);
	String actualAdress=  js1.getString("address");
	System.out.println( "address:" + actualAdress);
	Assert.assertEquals(actualAdress, newAddress);
	
	
	
	}
	public static String GenerateStringFromResource(String path) throws IOException {



	    return new String(Files.readAllBytes(Paths.get(path)));



	}
}
