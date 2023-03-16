package employeeTest;

import constants.EndPoints;
import static org.hamcrest.Matchers.equalTo;
import constants.SourcePath;
import employeePOJO.CreateDataResponse;
import employeePOJO.EmpCreateResponse;
import employeePOJO.GetDatawithPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import test.helpers.BaseApi;
import test.helpers.ReusableMethods;
import utility.PropUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.Configuration;
import test.helpers.UserHelpers ;
@Listeners(utility.TestListeners.class)


public class GetDataWithPOJOTest1 extends BaseApi {
	public int id;
	Response res;
	@Test (priority = 0)
	public void getdata() {
		GetDatawithPOJO ob = new GetDatawithPOJO();
		res =UserHelpers.getEmployee();
	ReusableMethods.validateRecord(res);
	System.out.println("number of records  :: " + ob.getId().SIZE);
	System.out.println("Message ="+res.jsonPath().getString( "message"));
	System.out.println("Status  ="+res.jsonPath().getString("status"));
		res.prettyPrint();
		
	}
	
	@Test (priority = 1)
	public void createData() throws StreamWriteException, DatabindException, IOException {
		res=UserHelpers.addEmployee() ;
		res.prettyPrint();
		EmpCreateResponse createResponse = res.getBody().as(EmpCreateResponse.class);
	 id = createResponse.getData().getId();
	System.out.println("ID  ="+id);
	ReusableMethods.validateRecord(res);
	int statuscode = res.statusCode();
	Assert.assertEquals(statuscode, 200);		
	}
	
	@Test (priority =2)
	public void delete() {
		//dependsOnMethods = {"createData"}
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.delete(EndPoints.DELETE_DATA+id);
		res.prettyPrint();
		int statuscode = res.statusCode();
		System.out.println("Status code :: "+statuscode);
		res.prettyPrint();
		
		Assert.assertEquals(res.jsonPath().getString("status"), "success");
		System.out.println(res.jsonPath().getString( "message"));
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test(priority =3)
	public void delete_givenID() throws IOException {
		res=UserHelpers.deletedata0();
					
	int statuscode = res.statusCode();
	System.out.println("Status code :: "+statuscode);
	res.prettyPrint();
	Assert.assertEquals(statuscode, 400);
	Assert.assertEquals(res.jsonPath().getString("status"), "error");
	System.out.println(res.jsonPath().getString( "message"));
	System.out.println(res.jsonPath().getString("errors"));
	
	}
	@Test(priority =4)
	public void employee_data() {
	
		res=UserHelpers.getEmployeeRecord();
		GetDatawithPOJO ob = new GetDatawithPOJO();
		res.prettyPrint();
		int statuscode = res.statusCode();
		Assert.assertEquals(statuscode, 200);
		String contentype = res.contentType();
		System.out.println(contentype);
		Assert.assertEquals(contentype,"application/json" );
		ReusableMethods.validateRecord(res);
		//GetDatawithPOJO[] ob = res.as(GetDatawithPOJO[].class);
		System.out.println("2nd record account no ="+ob.getId());
		res.body().asPrettyString();
		String rbody = res.getBody().asString();
	
		
	}

	
	
	
	
	
	
	}


