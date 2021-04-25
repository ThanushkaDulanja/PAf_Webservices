package com;

import java.sql.*;
import java.sql.Connection;


public class Product
{ //A common method to connect to the DB
private Connection connect()
 {
 Connection con = null;
 try
 {
 Class.forName("com.mysql.jdbc.Driver");

 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb", "root", "");
 }
 catch (Exception e)
 {e.printStackTrace();}
 return con;
 }
public String insertProduct(String code, String name, String price, String desc)
{
String output = "";
try
{
Connection con = connect();
if (con == null)
{return "Error while connecting to the database for inserting."; }
// create a prepared statement
String query = " insert into products (`productID`,`productCode`,`productName`,`productPrice`,`productDesc`)"
+ " values (?, ?, ?, ?, ?)";
PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
preparedStmt.setInt(1, 0);
preparedStmt.setString(2, code);
preparedStmt.setString(3, name);
preparedStmt.setDouble(4, Double.parseDouble(price));
preparedStmt.setString(5, desc);

preparedStmt.execute();
con.close();
output = "Inserted successfully";
}
catch (Exception e)
{
output = "Error while inserting the product.";
System.err.println(e.getMessage());
}
return output;
}
public String readProducts()
 {
 String output = "";
 try
 {
 Connection con = connect();
 if (con == null)
 {return "Error while connecting to the database for reading."; }
 
 output = "<table border='1'><tr><th>Product Code</th><th>Product Name</th>" +
 "<th>Product Price</th>" +
 "<th>Product Description</th>" +
 "<th>Update</th><th>Remove</th></tr>";

 String query = "select * from products";
 Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery(query);
 // iterate through the rows in the result set
 while (rs.next())
 {
 String productID = Integer.toString(rs.getInt("productID"));
 String productCode = rs.getString("productCode");
 String productName = rs.getString("productName");
 String productPrice = Double.toString(rs.getDouble("productPrice"));
 String productDesc = rs.getString("productDesc");

 output += "<tr><td>" + productCode + "</td>";
 output += "<td>" + productName + "</td>";
 output += "<td>" + productPrice + "</td>";
 output += "<td>" + productDesc + "</td>";
 // buttons
 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
 + "<td><form method='post' action='items.jsp'>"+ 
		 "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
 + "<input name='productID' type='hidden' value='" + productID
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
public String updateProduct(String ID, String code, String name, String price, String desc)
{
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE products SET productCode=?,productName=?,productPrice=?,productDesc=? WHERE productID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, code);
	 preparedStmt.setString(2, name);
	 preparedStmt.setDouble(3, Double.parseDouble(price));
	 preparedStmt.setString(4, desc);
	 preparedStmt.setInt(5, Integer.parseInt(ID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the product.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String deleteProduct(String productID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from products where productID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(productID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the product.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	}