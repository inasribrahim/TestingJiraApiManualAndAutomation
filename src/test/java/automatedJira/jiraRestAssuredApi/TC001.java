package automatedJira.jiraRestAssuredApi;
import org.testng.annotations.Test;
import files.*;
import SessionCookie.Session;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
public class TC001 {
	private static String issueId = null ;
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		// E:\software testing\GeneralStoreTest\jiraAPI\jiraRestAssuredApi\src\test\java\files\env.properties
		FileInputStream fis=new FileInputStream("E:\\software testing\\GeneralStoreTest\\jiraAPI\\jiraRestAssuredApi\\src\\test\\java\\files\\env.properties");
		prop.load(fis);
		
		
	}
	
	@Test
	public void CreateIssue() {
		//RestAssured.baseURI= (String) prop.getProperty("HOST");
		RestAssured.baseURI= "http://localhost:8080";
		
		Response res=
				given().
		
				header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+Session.getSessionKey()).
				body(payLoad.postCreateIssue()).log().all().
		when().
		post(resources.resourceCreateIssue()).
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).
		extract().response();
		
		JsonPath js= RawData.rawToJson(res);
		issueId=js.get("id");
		System.out.println("Create Issue ... ");
		System.out.println("In Create issue :"+issueId );


	}
	public String getIssueId() {
		return issueId;
	}
	
	@Test(dependsOnMethods = { "CreateIssue" })
	public void DeleteIssue() {
	
		given().
		header("Cookie","JSESSIONID="+Session.getSessionKey()).

		when().
		delete("/rest/api/2/issue/"+issueId ).
		then().assertThat().statusCode(204).and().contentType(ContentType.JSON);
		System.out.println("Delete Issue ... ");
		
	}	

}
