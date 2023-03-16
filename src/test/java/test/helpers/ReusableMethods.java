package test.helpers;

import java.io.IOException;

import org.testng.Assert;

import employeePOJO.EmpCreateResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReusableMethods {
	
	public static RequestSpecification getRequestSpecification(Response res) {
		return RestAssured.given()
				.contentType(ContentType.JSON);	
				
	}
	
	public static String getname(Response res) {
		String empname =res.jsonPath().get("employee_name");
		System.out.println(empname);
		return empname;
	}
	
	public static String getsalary(Response res) {
		String empsal =res.jsonPath().get("employee_salary");
		System.out.println(empsal);
		return empsal;
	}
	public static String getage(Response res) {
		String empage =res.jsonPath().get("employee_age");
		System.out.println(empage);
		return empage;
	}
	
	
	
	
	

	public static Integer extractId(EmpCreateResponse createResponse)
	{
		Integer id1 = createResponse.getData().getId();
		return id1;
	}

    public static void verifyData(EmpCreateResponse createResponse) {
    	
    }
public static Integer delete_data(Integer id) throws IOException {
		
		return id;
	
		
	}

public static void validateRecord(Response res) {
	String contentype =res.contentType();
	res.then().assertThat().statusCode(200);
	
	Assert.assertEquals(res.jsonPath().   getString("status"), "success");
	System.out.println("Status  ="+res.jsonPath().getString("status"));
	System.out.println("Status code :: "+res.statusCode());
	System.out.println("message displayed :"+res.body().jsonPath().getString("message"));
	String name = res.body().jsonPath().getString("data.employee_name");
	String salary = res.body().jsonPath().getString("data.employee_salary");
String age = res.body().jsonPath().getString("data.employee_age");
}
	
	
	
}
