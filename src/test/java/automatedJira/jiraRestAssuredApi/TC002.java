package automatedJira.jiraRestAssuredApi;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SessionCookie.Session;
import files.payLoad;
import io.restassured.http.ContentType;

public class TC002 {
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		// E:\software testing\GeneralStoreTest\jiraAPI\jiraRestAssuredApi\src\test\java\files\env.properties
		FileInputStream fis=new FileInputStream("E:\\software testing\\GeneralStoreTest\\jiraAPI\\jiraRestAssuredApi\\src\\test\\java\\files\\env.properties");
		prop.load(fis);
		
	}
	@Test
	public void updateIssue() {
		TC001 ob = new TC001();
		ob.CreateIssue();
		String issueId=ob.getIssueId();
		System.out.println("In update issue :"+issueId );
		given().
		header("Content-Type", "application/json").
		header ("Accept" ," application /json").
		header("Cookie","JSESSIONID="+Session.getSessionKey()).
		body(payLoad.postUpdateIssue()).log().all().
		when().
		put("/rest/api/2/issue/"+issueId ).
		then().assertThat().statusCode(204).and().contentType(ContentType.JSON);
		System.out.println("Update Issue ... ");
	}
}
