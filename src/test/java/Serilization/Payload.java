package Serilization;

public class Payload {
	String summary; 
	String description ; 
	IssueType issuetype ; 
	Project key ; 
	
	public Payload (Project key ,String summary , String description ,  IssueType issuetype  ) {
		this.summary = summary;
		this.description = description;
		this.issuetype = issuetype;
		this.key = key;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IssueType getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}
	public Project getKey() {
		return key;
	}
	public void setKey(Project key) {
		this.key = key;
	}

}
