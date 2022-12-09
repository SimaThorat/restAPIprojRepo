package ApiTest;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.*;
public class PostApi {
	
	public String registerpayload(String email,String pass)
	{
		/*return "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}";*/
		return "{\r\n"
		+ "    \"email\": \""+email+"\",\r\n"
		+ "    \"password\": \""+pass+"\"\r\n"
		+ "}";
	}
	
	@Test
	public void registerUser()
	{
		// https://reqres.in/api/register
	RestAssured.baseURI="https://reqres.in";
	Response response= given()
			.contentType(ContentType.JSON)
			/*.body("{\r\n"
					+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
					+ "    \"password\": \"pistol\"\r\n"
					+ "}")*/
			.body(registerpayload("eve.holt@reqres.in","pistol"))
			.when()
			.get("/api/register")		
			.then()
			.extract()
			.response();
	System.out.println(response.asPrettyString());
	System.out.println(response.getStatusCode());
	
	}

}
