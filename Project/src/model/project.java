package model;

import java.sql.*;




		


		public class project {
			

			
			 //A common method to connect to the DB
			private Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");

			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project", "root", "");
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 }
			public String insertProject(String code, String name, String desc, String investment)
			{
			String output = "";
			try
			{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for inserting."; }
			// create a prepared statement
			String query = " insert into project (`projectID`,`projectCode`,`projectName`,`projectDesc`,`projectInvestment`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, desc);
			preparedStmt.setString(5,investment);


			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
			}
			catch (Exception e)
			{
			output = "Error while inserting the project.";
			System.err.println(e.getMessage());
			}
			return output;
			}
//			public String readItems()
//			 {
//			 String output = "";
//			 try
//			 {
//			 Connection con = connect();
//			 if (con == null)
//			 {return "Error while connecting to the database for reading."; }
//			 
//			 output = "<table border='1'><tr><th>Item Code</th><th>Item Name</th>" +
//			 "<th>Item Price</th>" +
//			 "<th>Item Description</th>" +
//			 "<th>Update</th><th>Remove</th></tr>";
		//
//			 String query = "select * from items";
//			 Statement stmt = con.createStatement();
//			 ResultSet rs = stmt.executeQuery(query);
//			 // iterate through the rows in the result set
//			 while (rs.next())
//			 {
//			 String itemID = Integer.toString(rs.getInt("itemID"));
//			 String itemCode = rs.getString("itemCode");
//			 String itemName = rs.getString("itemName");
//			 String itemPrice = Double.toString(rs.getDouble("itemPrice"));
//			 String itemDesc = rs.getString("itemDesc");
		//
//			 output += "<tr><td>" + itemCode + "</td>";
//			 output += "<td>" + itemName + "</td>";
//			 output += "<td>" + itemPrice + "</td>";
//			 output += "<td>" + itemDesc + "</td>";
//			 // buttons
//			 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
//			 + "<td><form method='post' action='items.jsp'>"+ 
//					 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
//			 + "<input name='itemID' type='hidden' value='" + itemID
//			 + "'>" + "</form></td></tr>";
//			 }
//			 con.close();
		//
//			 output += "</table>";
//			 }
//			 catch (Exception e)
//			 {
//			 output = "Error while reading the items.";
//			 System.err.println(e.getMessage());
//			 }
//			 return output;
//			 }
////			public String insertItem(String Name, String Email, String Country, String Amount)
////			{
////			String output = "";
////			try
////			{
//			Connection con = connect();
//			if (con == null)
//			{return "Error while connecting to the database for inserting."; }
//			// create a prepared statement
//			String query = " insert into fundingbodies (`fundID`,`fundOrganizationName`,`fundEmail`,`fundCountry`,`fundAmount`)"
//			+ " values (?, ?, ?, ?, ?)";
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//			// binding values
//			preparedStmt.setInt(1, 0);
//			preparedStmt.setString(2, Name);
//			preparedStmt.setString(3, Email);
//			preparedStmt.setString(4, Country);
//			preparedStmt.setDouble(5, Double.parseDouble(Amount));
		//
//			preparedStmt.execute();
//			con.close();
//			output = "Inserted successfully";
//			}
//			catch (Exception e)
//			{
//			output = "Error while inserting the item.";
//			System.err.println(e.getMessage());
//			}
//			return output;
//			}
			public String readproject()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 
			 output = "<table border='1'><tr><th>projectCode</th><th>projectName</th>" +
			 "<th>projectDesc</th>" +
			 "<th>projectInvestment</th>" +
			 "<th>Update</th><th>Remove</th></tr>";

			 String query = "select * from project";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
			 String projectID = Integer.toString(rs.getInt("projectID"));
			 String projectCode = rs.getString("projectCode");
			 String projectName = rs.getString("projectName");
			 String projectDesc = rs.getString("projectDesc");
			 String projectInvestment = rs.getString("projectInvestment");

			 

			 output += "<tr><td>" + projectCode + "</td>";
			 output += "<td>" + projectName + "</td>";
			 output += "<td>" + projectDesc + "</td>";
			 output += "<td>" + projectInvestment + "</td>";
			 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
			 + "<td><form method='post' action='project.jsp'>"+ 
					 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
			 + "<input name='projectID' type='hidden' value='" + projectID
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
			public String updateProject(String ID,String code, String name, String desc, String investment)
			{
				 String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 // create a prepared statement
				 String query = "UPDATE project SET projectCode=?,projectName=?,projectDesc=?,projectInvestment=? WHERE projectID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setString(1, code);
				 preparedStmt.setString(2, name);
				 preparedStmt.setString(3, desc);
				 preparedStmt.setString(4, investment);
				 preparedStmt.setInt(5, Integer.parseInt(ID));
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Updated successfully";
				 }
				 catch (Exception e)
				 {
				 output = "Error while updating the project.";
				 System.err.println(e.getMessage());
				 }
				 return output;
				 }
//			public String updateFund(String ID, String Name, String Email, String Country, String Amount)
//			{
//				 String output = "";
//				 try
//				 {
//				 Connection con = connect();
//				 if (con == null)
//				 {return "Error while connecting to the database for updating."; }
//				 // create a prepared statement
//				 String query = "UPDATE fundingbodies SET fundOrganizationName=?,fundEmail=?,fundCountry=?,fundAmount=? WHERE fundID=?";
//				 PreparedStatement preparedStmt = con.prepareStatement(query);
//				 // binding values
//				 preparedStmt.setString(1, Name);
//				 preparedStmt.setString(2, Email);
//				 preparedStmt.setString(3, Country);
//				 preparedStmt.setDouble(4, Double.parseDouble(Amount));
//				 preparedStmt.setInt(5, Integer.parseInt(ID));
//				 // execute the statement
//				 preparedStmt.execute();
//				 con.close();
//				 output = "Updated successfully";
//				 }
//				 catch (Exception e)
//				 {
//				 output = "Error while updating the Fund.";
//				 System.err.println(e.getMessage());
//				 }
//				 return output;
			
					
			
			public String deleteproject(String projectID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from project where projectID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(projectID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the project.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			} 


//			
////				 }
//				public String deleteproject(String projectID)
//				 {
//				 String output = "";
//				 try
////				 {
//				 Connection con = connect();
//				 if (con == null)
//				 {return "Error while connecting to the database for deleting."; }
//				 // create a prepared statement
//				 String query = "delete from user where projectID=?";
//				 PreparedStatement preparedStmt = con.prepareStatement(query);
//				 // binding values
//				 preparedStmt.setInt(1, Integer.parseInt(projectID));
//				 // execute the statement
//				 preparedStmt.execute();
//				 con.close();
//				 output = "Deleted successfully";
//				 }
//				 catch (Exception e)
//				 {
//				 output = "Error while deleting the project.";
//				 System.err.println(e.getMessage());
//				 }
//				 return output;
//				 }
//				} 








