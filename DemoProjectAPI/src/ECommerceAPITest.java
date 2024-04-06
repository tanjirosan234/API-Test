import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import POJO.LoginRequest;
import POJO.LoginResponse;
import POJO.OrderDetails;
import POJO.Orders;
import POJO.ViewResponse;

public class ECommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
//login
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("vihynyr@getnada.com");
		loginRequest.setUserPassword("Irakoski123");

		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract()
				.response().as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();
		System.out.println(loginResponse.getUserId());
		String userId = loginResponse.getUserId();

//Add product
		RequestSpecification addporductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();
		RequestSpecification reqAddproduct = given().log().all().spec(addporductBaseReq).param("productName", "Laptop")
				.param("productAddedBy", userId).param("productCategory", "fashion")
				.param("productSubCategory", "shirts").param("productPrice", "11500")
				.param("productDescription", "Addidas Originals").param("productFor", "women")
				.multiPart("productImage", new File("//home//inellipse//Pictures//2024-03-01_10-41.png"));

		String addProductResponse = reqAddproduct.when().post("/api/ecom/product/add-product").then().log().all()
				.extract().response().asString();
		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");

//Create order
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setCountry("Macedonia");
		orderDetail.setProductOrderedId(productId);

		List<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
		orderDetailList.add(orderDetail);
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);

		RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);
		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
				.extract().response().asString();

		System.out.println(responseAddOrder);
		JsonPath js2 = new JsonPath(responseAddOrder);
		ArrayList<String> viewOrder = js2.get("orders");

		// view order
		RequestSpecification viewProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();

		RequestSpecification reqviewProduct = given().log().all().spec(viewProductBaseReq).param("id",
				viewOrder.get(0));
		ViewResponse viewProductResponse = reqviewProduct.when().get("api/ecom/order/get-orders-details").then().log()
				.all().extract().response().as(ViewResponse.class);
		System.out.println("view id " + viewProductResponse.getData().toString());
		// delete

		RequestSpecification deleteProductBasReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();

		RequestSpecification deleteProductReq = given().log().all().spec(deleteProductBasReq).pathParam("productId",
				productId);
		String deleteproductResponse = deleteProductReq.when().delete("/api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();
		JsonPath js1 = new JsonPath(deleteproductResponse);
		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
//		RequestSpecification deleteProduc= given().log().all().spec(deleteProductBasReq);
//		String deleteRes= deleteProduc.when().delete("/api/ecom/product/delete-product/"+viewProductResponse.getData().getProductOrderedId()).then().log().all().extract().response().asString();
		//
//		System.out.println("deleted " +deleteRes);

	}

}
