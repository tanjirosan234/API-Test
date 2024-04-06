import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.CoursePrice());
		// Print number of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		// Print Title of the first course
		String courseTitle = js.getString("courses[0].title");
		System.out.println(courseTitle);
		// Print all Prices of the courses
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println(js.get("courses[" + i + "].price").toString());
			System.out.println(courseTitles);
		}
		// Print number or copies sold by RPA Course
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("Appium")) {
				int copies = js.get("courses[" + i + "].copies");
				System.out.println("number of copies sold: " + copies);
				break;
			}
		}
//Verify if Sum of all Courses prices matches with Purchase Amount
	
	}
	}
