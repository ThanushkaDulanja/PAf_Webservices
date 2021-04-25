package model;
import java.sql.*;




	


	public class user {
		

		
		 //A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		public String insertUser(String fname, String lname, String pass, String mail)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for inserting."; }
		// create a prepared statement
		String query = " insert into user (`userID`,`userfirstName`,`userlastName`,`userpassword`,`userEmail`)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, fname);
		preparedStmt.setString(3, lname);
		preparedStmt.setString(4, pass);
		preparedStmt.setString(5,mail);


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
		public String readuser()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 
		 output = "<table border='1'><tr><th>userfirstName</th><th>userlastName</th>" +
		 "<th>userpassword</th>" +
		 "<th>userEmail</th>" +
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from user";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String userID = Integer.toString(rs.getInt("userID"));
		 String userfirstName = rs.getString("userfirstName");
		 String userlastName = rs.getString("userlastName");
		 String userpassword = rs.getString("userpassword");
		 String userEmail = rs.getString("userEmail");

		 

		 output += "<tr><td>" + userfirstName + "</td>";
		 output += "<td>" + userlastName + "</td>";
		 output += "<td>" + userpassword + "</td>";
		 output += "<td>" + userEmail + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='user.jsp'>"+ 
				 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='userID' type='hidden' value='" + userID
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
		public String updateUser(String ID,String fname, String lname, String pass, String mail)
		{
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE user SET userfirstName=?,userlastName=?,userpassword=?,userEmail=? WHERE userID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, fname);
			 preparedStmt.setString(2, lname);
			 preparedStmt.setString(3, pass);
			 preparedStmt.setString(4, mail);
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
			public String deleteuser(String userID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from user where userID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(userID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the user.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			} 





