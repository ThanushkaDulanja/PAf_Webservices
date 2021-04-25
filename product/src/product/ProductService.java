package product;


	
	
	//For REST Service
	import javax.ws.rs.*; 
	import javax.ws.rs.core.MediaType;

import com.Product;
//For JSON
	import com.google.gson.*; 
	//For XML
	import org.jsoup.*; 
	import org.jsoup.parser.*; 
	import org.jsoup.nodes.Document; 

	@Path("/Products") 
	public class ProductService 
	{ 
		Product productObj = new Product(); 
		
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readItems() 
		{ 
			return productObj.readProducts(); 
		} 
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("productCode") String productCode,
		@FormParam("productName") String productName,
		@FormParam("productPrice") String productPrice,
		@FormParam("productDesc") String productDesc)
		{
		String output = productObj.insertProduct(productCode, productName, productPrice, productDesc);
		return output;
		}
		
		
		
		
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateProduct(String productData) 
		{ 
			//Convert the input string to a JSON object 
			 JsonObject productObject = new JsonParser().parse(productData).getAsJsonObject(); 
			//Read the values from the JSON object
			 String productID = productObject.get("productID").getAsString(); 
			 String productCode = productObject.get("productCode").getAsString(); 
			 String productName = productObject.get("productName").getAsString(); 
			 String productPrice = productObject.get("productPrice").getAsString(); 
			 String productDesc = productObject.get("productDesc").getAsString(); 
			 String output = productObj.updateProduct(productID, productCode, productName, productPrice, productDesc); 
			 return output; 
		}
		
		
		
		
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteProduct(String productData) 
		{ 
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(productData, "", Parser.xmlParser()); 
			 
			//Read the value from the element <productID>
			 String productID = doc.select("productID").text(); 
			 String output = productObj.deleteProduct(productID); 
			 return output; 
		}

		
		

	}


