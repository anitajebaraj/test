package edu.sjsu.cmpe.test.resources;


public class SampleObject {
	  private String name;
	  private String branchName;

	  public SampleObject(String name,String branchName) {
	    super();
	    this.name = name;
	    this.branchName=branchName;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }
	  public String getBranchName() {
		    return branchName;
		  }
	  public void setBranchName(String branchName) {
		    this.branchName = branchName;
		  }
}

