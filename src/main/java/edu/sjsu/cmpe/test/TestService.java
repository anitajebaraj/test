package edu.sjsu.cmpe.test;



import static spark.Spark.get;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import edu.sjsu.cmpe.test.resources.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
//import java.io.FileWriter;

public class TestService {

  public static void main(String[] args) {  

    try {
  
      
      get(new Route("/test") {
    	  
    	    Configuration cfg = new Configuration();
          @Override
          public Object handle(Request request, Response response) {
        	  //Writer out = new OutputStreamWriter(System.out);
        	  System.out.println("initial");
        	  StringWriter file = null;
        	  String queryParam = request.queryString();
        	  String uname;
        	  System.out.println(queryParam);
        	  
              //template.process(input, file);
              //file.flush();
        	 
        	  
        	  
        	  try{
        	   file = new StringWriter();
        	  cfg.setDirectoryForTemplateLoading(new File("templates"));
              // load template
              Template template = cfg.getTemplate("hello.ftl");        	 
              System.out.println("1");
              // data-model
              Map<String, Object> input = new HashMap<String, Object>();              

              // create list
              List<SampleObject> systems = new ArrayList<SampleObject>();

              systems.add(new SampleObject("SJSU","Computer Science"));
              systems.add(new SampleObject("ASU","Computer Science"));
              systems.add(new SampleObject("IUB","Computer Science"));
              systems.add(new SampleObject("ABCD","Computer Science"));
              systems.add(new SampleObject("DEFG","Computer Science"));
            
              SampleObject exampleObject = new SampleObject("San Jose State University","abcd");
              exampleObject.setName("San Jose State University");
              exampleObject.setBranchName("Computer Science");
              input.put("test", exampleObject);
              input.put("systems", systems);
              System.out.println("2");
        	  //Writer out = new OutputStreamWriter(System.out);
              //template.process(input, out);
              template.process(input, file);
              
              if(queryParam == null)
        	  {        	  
        	  System.out.println("null");
        	  }
        	 else
        	 {
        		 System.out.println(queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&")));
        		 uname = queryParam.substring((queryParam.indexOf("=")+1),queryParam.indexOf("&"));
        		 if(queryParam.contains("submit"))
        		 {
        			 System.out.println(uname+" is presnt");
        		 }
        	 }
              
              
              
              
             // System.out.println(file.toString());
                  	  
        	
        	  }catch(Exception e)
          {
        	  System.out.println(e.getMessage());
          }
        	 
        	return file;
          }
       });
                 
    } catch (Exception e) {
      System.out.println(e.getMessage());

    } 

  }
} 