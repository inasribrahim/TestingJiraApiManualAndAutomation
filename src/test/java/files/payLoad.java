package files;

public class payLoad {
	public static String postCreateIssue() {
		
		return "{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"RES\""+
			       "},"+
			       "\"summary\": \"Eclipse defactt\","+
			       "\"description\": \"Creating my first bug using REST Assured \","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}"+
			   "}}"	;
	}
	
	public static String postUpdateIssue() {
		
		return "{"+ 
			"\"fields\":{"+
				"\"summary\": \"Updated Eclipse defact to fix defect\""+
	
			"}}"	;	
	}
	

}
