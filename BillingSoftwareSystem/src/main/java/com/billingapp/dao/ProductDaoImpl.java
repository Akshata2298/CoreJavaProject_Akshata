package com.billingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.billingapp.model.Product;


public class ProductDaoImpl implements ProductDao {

	public void addProducts(Product product) {
		
		int pcode;
		int quantity;
		String category;
		String name;
		String desc;
		float price;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your product id");
		 pcode=scanner.nextInt();
		 System.out.println("Enter your product quantity");
		 quantity=scanner.nextInt();
		 System.out.println("Enter your product category");
		 category=scanner.next();
		 System.out.println("Enter your product name");
		 name=scanner.next();
		 System.out.println("Enter your product description");
		 desc=scanner.next();
		 System.out.println("Enter your product price");
		 price=scanner.nextFloat();

		 try 
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			 Statement statement=con.createStatement();
			 String query="INSERT into product_info VALUES('"+pcode+"','"+quantity+"','"+category+"','"+name+"','"+desc+"','"+price+"')";
			 statement.executeUpdate(query);
			 System.out.println("Did you want to add more product");
			 char choice=scanner.next().charAt(0);
			 
			 if(choice=='y'||choice=='Y')
			 {
				 //addProducts(product);
				 System.out.println("hi");
				 ProductDaoImpl productDaoImpl = new ProductDaoImpl();
				productDaoImpl.addProducts(product);
			
				//addProducts(product);
				//loginProduct.main(args);
			 }
			else
			{
				System.exit(1);
			}
		 }
		catch(Exception e)
		 {
			System.out.println(e);
	}
	}

	public float buyProducts(Product product) {
		
		try 
		{
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			 Statement statement=con.createStatement();
		     ResultSet set=statement.executeQuery("select * from product_info");
		     int id[]=new int[10];
		     int quantity[]=new int[10];
		     String category[]=new String[100];
		     String name[]=new String[100];
			String descp[]=new String[200];
			float price[]=new float[200];
			int i=0;
			while(set.next())
			{
				id[i]=set.getInt(1);
				quantity[i]=set.getInt(2);
				category[i]=set.getString(3);
				name[i]=set.getString(4);
				descp[i]=set.getString(5);
				price[i]=set.getFloat(6);
				i++;
			}
			
			for(int j=1;j<=6;j++)
			{
				System.out.println(id[j]+"   "+quantity[j]+"  "+category[j]+"   "+name[j]+"  "+descp[j]+"  "+price[j]);
			}
			
			System.out.println("How many items  you want to buy");
			Scanner scanner=new Scanner(System.in);
			int item=scanner.nextInt();
			double bill=0;
			System.out.println("enter product id to buy");		
			int id1=scanner.nextInt();
			System.out.println("enter product price");
			float price1=scanner.nextFloat();
			System.out.println("enter product quantity to buy");
			int quant=scanner.nextInt();
			
		    bill=bill+quant*price1;
			
			
	System.out.println("Total bill will be=" +bill);
	
		}
	catch(Exception e)
		{
		System.out.println(e);
		
		}
		return 0;
		
}
	}


		
	

	
	
	
	
	
	

