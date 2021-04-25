package com;
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.payment;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/payment") 
public class paymentService {
	
	payment paymentObj = new payment(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readpayment() 
	{ 
		return paymentObj.readpayment(); 
	} 
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("paymentMethod") String paymentMethod,
	@FormParam("paymentAmount") String paymentAmount,
	@FormParam("paymentStatus") String paymentStatus,
	@FormParam("paymentDesc") String paymentDesc)
	{
	String output = paymentObj.insertpayment(paymentMethod, paymentAmount, paymentStatus, paymentDesc);
	return output;
	}		
	
//	@PUT
//	@Path("/") 
//	@Consumes(MediaType.APPLICATION_JSON) 
//	@Produces(MediaType.TEXT_PLAIN) 
//	public String updatepayment(String paymentData) 
//	{ 
//		//Convert the input string to a JSON object 
//		 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
//		//Read the values from the JSON object
//		 String paymentID = paymentObject.get("paymentID").getAsString(); 
//		 String paymentMethod = paymentObject.get("paymentMethod").getAsString(); 
//		 String paymentAmount = paymentObject.get("paymentAmount").getAsString(); 
//		 String paymentStatus = paymentObject.get("paymentStatus").getAsString(); 
//		 String paymentDesc = paymentObject.get("paymentDesc").getAsString(); 
//		 String output = paymentObject.updatepayment(paymentID, paymentMethod, paymentAmount, paymentStatus, paymentDesc); 
//		 return output; 
//	}
//	
	
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatepayment(String paymentData) 
	{
		//Convert the input string to a JSON object 
		 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
		 //Read the values from the JSON object
		 String paymentID = paymentObject.get("paymentID").getAsString(); 
	 String paymentMethod = paymentObject.get("paymentMethod").getAsString(); 
	 String paymentAmount = paymentObject.get("paymentAmount").getAsString(); 
	 String paymentStatus = paymentObject.get("paymentStatus").getAsString(); 
	 String paymentDesc = paymentObject.get("paymentDesc").getAsString(); 
		 String output = paymentObj.updatepayment(paymentID, paymentMethod, paymentAmount, paymentStatus, paymentDesc); 
		 return output; 
	}
//	
//	
	
	
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletepayment(String paymentData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <userID>
		 String paymentID = doc.select("paymentID").text(); 
		 String output = paymentObj.deletepayment(paymentID); 
		 return output; 
	}

	
	

}






	


