package myjdbc;

import java.util.Scanner;

public class Firstclass {
	
	public static void main(String[] args) {
		student s1=new student();
		// TODO Auto-generated method stub
		do {
			System.out.println("MENU");
			System.out.println("Enter 1 for creating db");
			System.out.println("Enter 2 to create table");
			System.out.println("Enter 3 to insert records");
			System.out.println("Enter 4 to read records");
			System.out.println("Enter 5 to update record");
			System.out.println("Enter 6 to delete record");
			int n;
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			if(n==1) {
				s1.createDatabase();
			}
			else if(n==2) {
				s1.createTable();
			}
			else if(n==3) {
				s1.insertData();
			}else if(n==4) {
				s1.readData();
			}else if(n==5) {
				s1.updateData();
			}else if(n==6) {
				s1.deleteData();
			}
			else {
				System.out.println("Invalid input");
			}
			
		}while(true);
		
		
	}

}
