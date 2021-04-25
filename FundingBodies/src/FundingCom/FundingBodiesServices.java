package FundingCom;


//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import Fundingmodel.FundingBodies;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;





	 

	@Path("/fundingbodies") 
	public class FundingBodiesServices 
	{ 
		FundingBodies fundObj = new FundingBodies(); 
		
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readFunds() 
		{ 
			return fundObj.readFunds(); 
		} 
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("fundOrganizationName") String fundOrganizationName,
		@FormParam("fundEmail") String fundEmail,
		@FormParam("fundCountry") String fundCountry,
		@FormParam("fundAmount") String fundAmount)
		{
		String output = fundObj.insertItem(fundOrganizationName, fundEmail, fundCountry, fundAmount);
		return output;
		}		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateItem(String fundData) 
		{ 
			//Convert the input string to a JSON object 
			 JsonObject fundObject = new JsonParser().parse(fundData).getAsJsonObject(); 
			//Read the values from the JSON object
			 String fundID = fundObject.get("fundID").getAsString(); 
			 String fundOrganizationName = fundObject.get("fundOrganizationName").getAsString(); 
			 String fundEmail = fundObject.get("fundEmail").getAsString(); 
			 String fundCountry = fundObject.get("fundCountry").getAsString(); 
			 String fundAmount = fundObject.get("fundAmount").getAsString(); 
			 String output = fundObj.updateItem(fundID, fundOrganizationName, fundEmail, fundCountry, fundAmount); 
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
		public String deletefund(String fundData) 
		{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(fundData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <itemID>
			 String fundID = doc.select("fundID").text(); 
			 String output = fundObj.deleteFund(fundID); 
			 return output; 
		}

		
		

	}





