package Fundingmodel;

import java.sql.*;

public class FundingBodies {

	



		

		
		 //A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fund", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		public String insertItem(String Name, String Email, String Country, String Amount)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for inserting."; }
		// create a prepared statement
		String query = " insert into fundingbodies (`fundID`,`fundOrganizationName`,`fundEmail`,`fundCountry`,`fundAmount`)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, Name);
		preparedStmt.setString(3, Email);
		preparedStmt.setString(4, Country);
		preparedStmt.setString(5, Amount);


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
		public String readFunds()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 
		 output = "<table border='1'><tr><th>fundOrganizationName</th><th>fundEmail</th>" +
		 "<th>fundCountry</th>" +
		 "<th>fundAmount</th>" +
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from fundingbodies";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String fundID = Integer.toString(rs.getInt("fundID"));
		 String fundOrganizationName = rs.getString("fundOrganizationName");
		 String fundEmail = rs.getString("fundEmail");
		 String fundCountry = rs.getString("fundCountry");
		 String fundAmount = rs.getString("fundAmount");

		 

		 output += "<tr><td>" + fundOrganizationName + "</td>";
		 output += "<td>" + fundEmail + "</td>";
		 output += "<td>" + fundCountry + "</td>";
		 output += "<td>" + fundAmount + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='fundingbodies.jsp'>"+ 
				 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='fundID' type='hidden' value='" + fundID
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
		public String updateItem(String ID, String Name, String Email, String Country, String Amount)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE fundingbodies SET fundOrganizationName=?,fundEmail=?,fundCountry=?,fundAmount=? WHERE fundID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, Name);
			 preparedStmt.setString(2, Email);
			 preparedStmt.setString(3, Country);
			 preparedStmt.setString(4, Amount);
			 preparedStmt.setInt(5, Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while updating the fund.";
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
			public String deleteFund(String fundID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from fundingbodies where fundID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(fundID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the item.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			} 




