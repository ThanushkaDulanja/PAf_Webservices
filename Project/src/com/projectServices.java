package com;




//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.project;


//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;





	 

	@Path("/project") 
	public class projectServices 
	{ 
		project projectObj = new project(); 
		
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readproject() 
		{ 
			return projectObj.readproject(); 
		} 
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertProject(@FormParam("projectCode") String projectCode,
		@FormParam("projectName") String projectName,
		@FormParam("projectDesc") String projectDesc,
		@FormParam("projectInvestment") String projectInvestment)
		{
		String output = projectObj.insertProject(projectCode, projectName, projectDesc, projectInvestment);
		return output;
		}		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateProject(String projectData) 
		{ 
			//Convert the input string to a JSON object 
			 JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject(); 
			//Read the values from the JSON object
			 String projectID = projectObject.get("projectID").getAsString(); 
			 String projectCode = projectObject.get("projectCode").getAsString(); 
			 String projectName = projectObject.get("projectName").getAsString(); 
			 String projectDesc = projectObject.get("projectDesc").getAsString(); 
			 String projectInvestment = projectObject.get("projectInvestment").getAsString(); 
			 String output = projectObj.updateProject(projectID, projectCode, projectName, projectDesc, projectInvestment); 
			 return output; 
		}
		
		
		
		
//		@PUT
//		@Path("/") 
//		@Consumes(MediaType.APPLICATION_JSON) 
//		@Produces(MediaType.TEXT_PLAIN) 
//		public String updateFund(String itemData) 
//		{ 
//			//Convert the input string to a JSON object 
//			 JsonObject fundObject = new JsonParser().parse(itemData).getAsJsonObject(); 
//			 //Read the values from the JSON object
//			 String fundID = fundObject.get("fundID").getAsString(); 
//			 String fundOrganizationName = fundObject.get("fundOrganizationName").getAsString(); 
//			 String fundEmail = fundObject.get("fundEmail").getAsString(); 
//			 String fundCountry = fundObject.get("fundCountry").getAsString(); 
//			 String fundAmount = fundObject.get("fundAmount").getAsString(); 
//			 String output = fundObj.updateFund(fundID, fundOrganizationName, fundEmail, fundCountry, fundAmount); 
//			 return output; 
//		}
//		
//		
		
		
	
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteproject(String projectData) 
		{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(projectData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <userID>
			 String projectID = doc.select("projectID").text(); 
			 String output = projectObj.deleteproject(projectID); 
			 return output; 
		}
		

	}





