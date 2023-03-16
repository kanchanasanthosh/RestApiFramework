package test.helpers;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import utility.PropUtility;

public class BaseApi {
	
	 PropUtility prop = new PropUtility();
		@BeforeClass
		public void init() {
			try {
				RestAssured.baseURI=PropUtility.getBaseUri("BASE_URI");
				System.out.println("loaded uri");
				//return res;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
			
	
	
	

}
