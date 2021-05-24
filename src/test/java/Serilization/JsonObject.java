package Serilization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObject {
public static void main(String[] args ) {
	IssueType issue = new IssueType("Bug");
	Project key = new Project("TEST");
	Payload p = new Payload(key,"REST ye merry gentlemen", "Creating of an issue using project keys and issue type names using the REST API issuetype", issue);
	Fields fields = new Fields(p);
	ObjectMapper objMapper = new ObjectMapper();
	String myObject = null ;
	try {
		//Serialize the object 
		myObject = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fields);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(myObject);
}
}
