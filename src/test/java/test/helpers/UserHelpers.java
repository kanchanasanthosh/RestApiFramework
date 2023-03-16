package test.helpers;
import java.io.IOException;

import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import constants.EndPoints;
import employeePOJO.EmpCreateResponse;
import employeePOJO.GetDatawithPOJO;
import employeeTest.GetDataWithPOJOTest1;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import utility.ExtentReportManager;
import utility.PropUtility;

public class UserHelpers {
	//static PropUtility prop = new PropUtility();
	public static Response res ;
	
	
	public static RequestSpecification getRequestSpecification(Response res) {
		return  RestAssured.given().log().all()
				.contentType(ContentType.JSON)
				.when();
	}
	
	public static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		ExtentReportManager.logInfoDetails(queryableRequestSpecification.getBaseUri());
		ExtentReportManager.logInfoDetails(queryableRequestSpecification.getMethod());
		
	}
	public static void printResponseLogInReport(Response res) {
		ExtentReportManager.logInfoDetails("Response status:"+res.getStatusCode());
		
		
	}
	
	
	
	public static Response getEmployee() {
		
		RequestSpecification requestSpecification=	getRequestSpecification( res);
		Response res=requestSpecification.	get(EndPoints.EMPLOYEES);
		 printResponseLogInReport(res);
		return res;
		
	}
	
	public static Response addEmployee() {
		
			GetDatawithPOJO ob1 = new GetDatawithPOJO();
			ob1.setEmployeeName("test");
			ob1.setEmployeeSalary(123);
			ob1.setEmployeeAge(23);
			ob1.setProfileImage("");
			RequestSpecification requestSpecification=	getRequestSpecification( res);
			Response res=	requestSpecification.post(EndPoints.ADD_DATA);
			return res;
	}
	
public static Response deletedata0() throws IOException {
	RequestSpecification requestSpecification=	getRequestSpecification( res);
					
	Response res=requestSpecification.delete(EndPoints.DELETE_DATA+0);
		return res;
	
		
	}



public static Response delete_data(Integer id) throws IOException {
		
	RequestSpecification requestSpecification=	getRequestSpecification( res);
	Response res=requestSpecification.delete(EndPoints.DELETE_DATA);
		return res;
	
		
	}

public static Response getEmployeeRecord( ) {
	RequestSpecification requestSpecification=	getRequestSpecification( res);
	Response res=requestSpecification.get(EndPoints.EMP_DATA);
	 return res;
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

	

}
