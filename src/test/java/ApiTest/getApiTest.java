package ApiTest;


import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.*;

public class getApiTest {
@Test
	public void getListUser()
	{
		RestAssured.baseURI="https://reqres.in";
	Response response= given()
		.when()
		.queryParams("page",2)
		//.get("/api/users?page=2")
		.get("/api/users")
		.then()
		.extract()
		.response();
	
	int stcode=response.getStatusCode();
	System.out.println(stcode);
	String stline=response.getStatusLine();
	System.out.println(stline);
	System.out.println( response.getHeader("Report-To"));
	
   Headers headers=response.getHeaders();
   for(Header h : headers )
   {
	   System.out.println(h.getName()+""+h.getValue());
   }
	System.out.println(response.asPrettyString());
    Assert.assertEquals(stcode, 200);
    
    System.out.println(response.getContentType());
   Assert.assertTrue(response.getHeader("Content-Type").contains("application/json"));
   //Assert.assertTrue(response.getHeader("Report-To").contains("application/json"));
	}

	//public void postUser
	}


