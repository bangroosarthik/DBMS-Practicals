package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class student {
	String dbname;
	String Tbname;
	String attributes;
	String insert;
	String upd;
	String del;
	Scanner sc=new Scanner(System.in);
	
	public void createDatabase() {
		// TODO Auto-generated method stub
		//1. Load jar file
		//2. get connection
		//3. create a statement 
		//4. execute our query
		//5. close connection
		try {
			String url="jdbc:mysql://localhost:3306/";
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
			
			//statement creation
			Statement st=con.createStatement();
			
			System.out.println("Enter the database name:");
			dbname=sc.nextLine();
			
			String Query="CREATE DATABASE "+dbname;
			
			st.execute(Query);
			
			System.out.println("Database created successfully");
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createTable() {
		// TODO Auto-generated method stub
		try {
			String url="jdbc:mysql://localhost:3306/"+dbname;
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			
			
			//statement creation
			Statement st=con.createStatement();
			
			System.out.println("Enter the Table name:");
			Tbname=sc.nextLine();
			
			System.out.println("Enter attibutes and the datatype");
			attributes=sc.nextLine();
			
			String Query="CREATE Table "+Tbname+"("+attributes+")";
			
			st.execute(Query);
			
			System.out.println("Table created successfully");
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insertData() {
		// TODO Auto-generated method stub
		
		try {
			String url="jdbc:mysql://localhost:3306/"+dbname;
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			
			//statement creation
			Statement st=con.createStatement();
			
			int n;
			System.out.println("Enter the number of records you wish to enter");
			n=sc.nextInt();
			sc.nextLine();
			int i=1;
			while(n>0) {
				System.out.println("Enter record "+i+" inside table "+Tbname);
				insert=sc.nextLine();
				String Query="INSERT INTO "+Tbname+" VALUES("+insert+")";
				st.execute(Query);
				System.out.println("Record inserted successfully");
				++i;
				n--;
				
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void readData() {
		// TODO Auto-generated method stub
		try {
			String url="jdbc:mysql://localhost:3306/"+dbname;
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			
			
			//statement creation
			Statement st=con.createStatement();
			
			//retrieve 
			String Query="SELECT * FROM "+Tbname;
			ResultSet rs=st.executeQuery(Query);
			
			int i=1;
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Salary: "+rs.getInt(3));
				i++;
			}
			con.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateData() {
		// TODO Auto-generated method stub
		try {
			String url="jdbc:mysql://localhost:3306/"+dbname;
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			System.out.println("Enter Attribute and its value you wish to update ");
			
			upd=sc.nextLine();
			
			String text;
			System.out.println("Enter text");
			text=sc.nextLine();
			
			//statement creation
			String Query="UPDATE "+Tbname+" SET "+upd+" WHERE "+text;
			st.executeUpdate(Query);
			
			con.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteData() {
		// TODO Auto-generated method stub
		try {
			String url="jdbc:mysql://localhost:3306/"+dbname;
			String username="root";
			String password="123456789";
			//created connection
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			
			
			
			System.out.println("Enter text");
			del=sc.nextLine();
			
			//statement creation
			String Query="DELETE FROM "+Tbname+" WHERE "+del;
			st.executeUpdate(Query);
			
			con.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
