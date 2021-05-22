package SessionCookie;
import files.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Session {
	Properties prop=new Properties();
	private static String sessionId = null ;

	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\files\\env.properties");
		prop.load(fis);
			
	}
	//body("{ \"username\":"+prop.getProperty("USERNAME")+",\"password\":"+prop.getProperty("PASSWORD")+"}").
	public static String getSessionKey() {
		
		RestAssured.baseURI= "http://localhost:8080";
		Response res=
				given().
				header("Content-Type", "application/json").
				body("{ \"username\": \"ibrahim_nasr\", \"password\": \"enter_you_password\" }").
		when().
		post(resources.resourceAuth()).
		then().statusCode(200).extract().response();
		
		JsonPath js= RawData.rawToJson(res);
		return sessionId=js.get("session.value");
		
}
}
