import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class DynamicJson {

	
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
	String response=	 given().header("Content-Type","application/json").
		 body(payload.Addbook(isbn,aisle)).
		 when()
		 .post("/Library/Addbook.php")
		 .then().log().all().assertThat().statusCode(200)
		 .extract().response().asString();
	JsonPath js=ReusableMethods.rawToJson(response);
	String id=js.get("ID");
		System.out.println(id);
		
		
		
	}
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		//array= collections of elements and you need to put it like this []
		//multidimensional array= collections of arrays and you need to put it like this [][]
	return new Object[][]{{"nino","2499"}, {"mite","3095"}, {"bobo","0798"}};
	}
}
