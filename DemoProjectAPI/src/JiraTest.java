import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="http://localhost:8080";

SessionFilter session=new SessionFilter();

String response=given().relaxedHTTPSValidation().header("Content-Type","application/json").body("{ \"username\": \"mite\", \n"
		+ "\"password\": \"irakoski123\" }").log().all()
.filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();

String expectedMessage="Hi How are you";
//add comment
	String addCommentResponse =	given().pathParam("id", "10003").log().all().header("Content-Type","application/json").body("{\n"
				+ "    \"body\": \""+expectedMessage+"\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js1=new JsonPath(addCommentResponse);
	String commentId=	js1.getString("id");
		//Add attachment
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id", "10003")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("jira.txt")).when()
		.post("/rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);
		
		
		//Get issue
	String issuesDetails=	given().filter(session).pathParam("id", "10003")
			.queryParam("fields", "comment")
			.log().all()
		.when().get("/rest/api/2/issue/{id}")
		.then().log().all().extract().response().asString();
		System.out.println(issuesDetails);
		
		JsonPath js=new JsonPath(issuesDetails);
		int commentsCount=js.getInt("fields.comment.comments.size()");
		for(int i=0;i<commentsCount;i++)
		{
		String commentIdIssue=js.get("fields.comment.comments["+i+"].id").toString();
		if(commentIdIssue.equalsIgnoreCase(commentId))
		{
			String message=js.get("fields.comment.comments["+i+"].body").toString();
			System.out.println(message);
			Assert.assertEquals(message, expectedMessage);
		}
		}
	}

}
