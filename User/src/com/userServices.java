package com;



//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;


import model.user;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;





	 

	@Path("/user") 
	public class userServices 
	{ 
		user userObj = new user(); 
		
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readuser() 
		{ 
			return userObj.readuser(); 
		} 
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertUser(@FormParam("userfirstName") String userfirstName,
		@FormParam("userlastName") String userlastName,
		@FormParam("userpassword") String userpassword,
		@FormParam("userEmail") String userEmail)
		{
		String output = userObj.insertUser(userfirstName, userlastName, userpassword, userEmail);
		return output;
		}		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateUser(String userData) 
		{ 
			//Convert the input string to a JSON object 
			 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
			//Read the values from the JSON object
			 String userID = userObject.get("userID").getAsString(); 
			 String userfirstName = userObject.get("userfirstName").getAsString(); 
			 String userlastName = userObject.get("userlastName").getAsString(); 
			 String userpassword = userObject.get("userpassword").getAsString(); 
			 String userEmail = userObject.get("userEmail").getAsString(); 
			 String output = userObj.updateUser(userID, userfirstName, userlastName, userpassword, userEmail); 
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
		public String deleteuser(String userData) 
		{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <userID>
			 String userID = doc.select("userID").text(); 
			 String output = userObj.deleteuser(userID); 
			 return output; 
		}

		
		

	}





