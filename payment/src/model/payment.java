package model;
import java.sql.*;




	


	public class payment {
		

		
		 //A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		public String insertpayment(String pMethod, String pAmount, String pStatus, String pDesc)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for inserting."; }
		// create a prepared statement
		String query = " insert into payment (`paymentID`,`paymentMethod`,`paymentAmount`,`paymentStatus`,`paymentDesc`)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, pMethod);
		preparedStmt.setString(3, pAmount);
		preparedStmt.setString(4, pStatus);
		preparedStmt.setString(5,pDesc);


		preparedStmt.execute();
		con.close();
		output = "Inserted successfully";
		}
		catch (Exception e)
		{
		output = "Error while inserting the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
//		public String readItems()
//		 {
//		 String output = "";
//		 try
//		 {
//		 Connection con = connect();
//		 if (con == null)
//		 {return "Error while connecting to the database for reading."; }
//		 
//		 output = "<table border='1'><tr><th>Item Code</th><th>Item Name</th>" +
//		 "<th>Item Price</th>" +
//		 "<th>Item Description</th>" +
//		 "<th>Update</th><th>Remove</th></tr>";
	//
//		 String query = "select * from items";
//		 Statement stmt = con.createStatement();
//		 ResultSet rs = stmt.executeQuery(query);
//		 // iterate through the rows in the result set
//		 while (rs.next())
//		 {
//		 String itemID = Integer.toString(rs.getInt("itemID"));
//		 String itemCode = rs.getString("itemCode");
//		 String itemName = rs.getString("itemName");
//		 String itemPrice = Double.toString(rs.getDouble("itemPrice"));
//		 String itemDesc = rs.getString("itemDesc");
	//
//		 output += "<tr><td>" + itemCode + "</td>";
//		 output += "<td>" + itemName + "</td>";
//		 output += "<td>" + itemPrice + "</td>";
//		 output += "<td>" + itemDesc + "</td>";
//		 // buttons
//		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
//		 + "<td><form method='post' action='items.jsp'>"+ 
//				 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
//		 + "<input name='itemID' type='hidden' value='" + itemID
//		 + "'>" + "</form></td></tr>";
//		 }
//		 con.close();
	//
//		 output += "</table>";
//		 }
//		 catch (Exception e)
//		 {
//		 output = "Error while reading the items.";
//		 System.err.println(e.getMessage());
//		 }
//		 return output;
//		 }
////		public String insertItem(String Name, String Email, String Country, String Amount)
////		{
////		String output = "";
////		try
////		{
//		Connection con = connect();
//		if (con == null)
//		{return "Error while connecting to the database for inserting."; }
//		// create a prepared statement
//		String query = " insert into fundingbodies (`fundID`,`fundOrganizationName`,`fundEmail`,`fundCountry`,`fundAmount`)"
//		+ " values (?, ?, ?, ?, ?)";
//		PreparedStatement preparedStmt = con.prepareStatement(query);
//		// binding values
//		preparedStmt.setInt(1, 0);
//		preparedStmt.setString(2, Name);
//		preparedStmt.setString(3, Email);
//		preparedStmt.setString(4, Country);
//		preparedStmt.setDouble(5, Double.parseDouble(Amount));
	//
//		preparedStmt.execute();
//		con.close();
//		output = "Inserted successfully";
//		}
//		catch (Exception e)
//		{
//		output = "Error while inserting the item.";
//		System.err.println(e.getMessage());
//		}
//		return output;
//		}
		public String readpayment()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 
		 output = "<table border='1'><tr><th>paymentMethod</th><th>paymentAmount</th>" +
		 "<th>paymentStatus</th>" +
		 "<th>paymentDesc</th>" +
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from payment";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String paymentID = Integer.toString(rs.getInt("paymentID"));
		 String paymentMethod = rs.getString("paymentMethod");
		 String paymentAmount = rs.getString("paymentAmount");
		 String paymentStatus = rs.getString("paymentStatus");
		 String paymentDesc = rs.getString("paymentDesc");

		 

		 output += "<tr><td>" + paymentMethod + "</td>";
		 output += "<td>" + paymentAmount + "</td>";
		 output += "<td>" + paymentStatus + "</td>";
		 output += "<td>" + paymentDesc + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='payment.jsp'>"+ 
				 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='paymentID' type='hidden' value='" + paymentID
		 + "'>" + "</form></td></tr>";
		 }
		 con.close();

		 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		public String updatepayment(String ID,String pMethod, String pAmount, String pStatus, String pDesc)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE payment SET paymentMethod=?,paymentAmount=?,paymentStatus=?,paymentDesc=? WHERE paymentID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, pMethod);
			 preparedStmt.setString(2, pAmount);
			 preparedStmt.setString(3, pStatus);
			 preparedStmt.setString(4, pDesc);
			 preparedStmt.setInt(5, Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while updating the payment.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
//		public String updateFund(String ID, String Name, String Email, String Country, String Amount)
//		{
//			 String output = "";
//			 try
//			 {
//			 Connection con = connect();
//			 if (con == null)
//			 {return "Error while connecting to the database for updating."; }
//			 // create a prepared statement
//			 String query = "UPDATE fundingbodies SET fundOrganizationName=?,fundEmail=?,fundCountry=?,fundAmount=? WHERE fundID=?";
//			 PreparedStatement preparedStmt = con.prepareStatement(query);
//			 // binding values
//			 preparedStmt.setString(1, Name);
//			 preparedStmt.setString(2, Email);
//			 preparedStmt.setString(3, Country);
//			 preparedStmt.setDouble(4, Double.parseDouble(Amount));
//			 preparedStmt.setInt(5, Integer.parseInt(ID));
//			 // execute the statement
//			 preparedStmt.execute();
//			 con.close();
//			 output = "Updated successfully";
//			 }
//			 catch (Exception e)
//			 {
//			 output = "Error while updating the Fund.";
//			 System.err.println(e.getMessage());
//			 }
//			 return output;
//			 }
			public String deletepayment(String paymentID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from payment where paymentID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(paymentID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the payment.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			} 





