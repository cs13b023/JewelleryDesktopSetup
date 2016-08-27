package mastersetup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay
 */
//STEP 1. Import required packages
import java.sql.*;

public class Mastersetup {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/t2";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      String sql="CREATE TABLE chitfundmembers(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),phonenumber VARCHAR(11),adderss VARCHAR(30))";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE chitslist(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,chitname VARCHAR(20),totalmembers int(3),totalmonths INT(2),totalamount INT(10),installmentscompleted INT(2),pooledmoney INT(10),startdate date,comission int(2))";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE chitfundcustomerdetails(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,customerid INT(5),chitfundid INT(4),Dueamount INT(10),amonttaken INT(10),datetaken DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE payments(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,customerid INT(4),chitfundid INT(4),amountpaid INT(7),givendate DATE)";
      //stmt.executeUpdate(sql);
      sql="CREATE TABLE chitspartof(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),totalmembers int(3),totalmonths INT(2),totalamount INT(10),installmentscompleted INT(2),pooledmoney INT(10),startdate date,manager varchar(20))";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE paymentspartof(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,chitfundid INT(4),amountpaid INT(7),givendate DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE detailspartof(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,chitfundid  INT(3),amonttaken INT(10),datetaken DATE)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE paymentspartof ADD CONSTRAINT fk_chitspartofid FOREIGN KEY (chitfundid) REFERENCES chitspartof(id)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE detailspartof ADD CONSTRAINT fk_chitdetailsid FOREIGN KEY (chitfundid) REFERENCES chitspartof(id)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE chitfundcustomerdetails ADD CONSTRAINT fk_customerid FOREIGN KEY (customerid) REFERENCES chitfundmembers(id)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE chitfundcustomerdetails ADD CONSTRAINT fk_chitid FOREIGN KEY (chitfundid) REFERENCES chitslist(id);";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE payments ADD CONSTRAINT fk_chitpaymentid FOREIGN KEY (chitfundid) REFERENCES chitslist(id)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE payments ADD CONSTRAINT fk_customerpaymentid FOREIGN KEY (customerid) REFERENCES chitfundmembers(id)";
      stmt.executeUpdate(sql);
      stmt = conn.createStatement();
      sql="CREATE TABLE Item (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Customer VARCHAR(30),Material VARCHAR(10),Type VARCHAR(30),Weight_in_grams int(4),Purity_in_percent int(3),Amount_given_as_loan VARCHAR(10),Type_of_repayment VARCHAR(10),Date_of_pledging DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE Loan (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Loan_giver VARCHAR(30),Loan_taker VARCHAR(30),Date_of_giving DATE,Status_of_Loan VARCHAR(30),Date_of_repaying DATE,Repaid_on_time VARCHAR(3))";
      stmt.executeUpdate(sql);
      stmt = conn.createStatement();
      sql="CREATE TABLE orderlist(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Customer_name VARCHAR(50),Karigar_name VARCHAR(50),Total_cost INT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE dispatchlist(id INT NOT NULL,Order_ID INT NOT NULL PRIMARY KEY,Karigar_name VARCHAR(50),Manufacturing_cost INT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE deliverylist(id INT NOT NULL,Order__ID INT NOT NULL PRIMARY KEY,Customer_name VARCHAR(50),Ornament_cost INT,Mobile MEDIUMTEXT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE karigarlist(id INT NOT NULL,Karigar_ID INT NOT NULL PRIMARY KEY,Karigar_name VARCHAR(20),Factory_name VARCHAR(50),rating INT,Punctuality INT,ThopeIn VARCHAR(20))";
      stmt.executeUpdate(sql); 
      sql = "create table customer (id varchar(6) primary key,name varchar(15),ph varchar(11),visits int(11),purchase float,type varchar(15),capacity float)";
      stmt.executeUpdate(sql);
      
      sql = "create table customer_loyal (id varchar(6) ,prog varchar(20),status int(11),revenue float)";
      stmt.executeUpdate(sql);
      
      sql = "create table customer_rating (type varchar(20))";
      stmt.executeUpdate(sql);
      
      sql = "create table emp_attendance (date date primary key)";
      stmt.executeUpdate(sql);
      
      
      sql = "create table employee (emp_id varchar(6) primary key, name varchar(20),ph_no varchar(10),salary decimal(10,2),attendance int(11))";
      stmt.executeUpdate(sql);
      
      sql = "create table orn_rating (type varchar(15) primary key)";
      stmt.executeUpdate(sql);
      
      sql = "create table prog1 (visit int(11) primary key, offer float)";
      stmt.executeUpdate(sql);
      
      sql = "create table prog2 (visit int(11) primary key, offer float)";
      stmt.executeUpdate(sql);
      
      sql = "create table prog3 (visit int(11) primary key, offer float)";
      stmt.executeUpdate(sql);
      
      sql = "create table prog_list (name varchar(15) primary key,min_visit int(11),min_purchase float,req int(11),total_revenue float)";
      stmt.executeUpdate(sql);
      
      //Inventory Tables
      sql="CREATE TABLE INVENTORY(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,BARCODE VARCHAR(20),WHOLESALER_NAME VARCHAR(50),DATE_OF_PURCHASE DATE,TYPE VARCHAR(25),MATERIAL VARCHAR(25),DESIGN_NAME VARCHAR(25),PURITY FLOAT,NET_WEIGHT FLOAT,GROSS_WEIGHT FLOAT,COST_PRICE LONG,SELLING_PRICE LONG)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE NEW_INVENTORY(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,BARCODE VARCHAR(20),IMAGE LONGBLOB,WHOLESALER_NAME VARCHAR(50),DATE_OF_PURCHASE DATE,MATERIAL VARCHAR(25),TYPE VARCHAR(25),DESIGN_NAME VARCHAR(25),SUB_ITEM VARCHAR(25),MAKING_CHARGES FLOAT,HALLMARK VARCHAR(20),PURITY FLOAT,NET_WEIGHT FLOAT,STONE_WEIGHT FLOAT,GROSS_WEIGHT FLOAT,BUYING_PRICE LONG,SELLING_PRICE LONG)";
      stmt.executeUpdate(sql);
       String sql1="CREATE TABLE STONE_DETAILS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,ORN_FK_ID INT,STONE_NAME VARCHAR(25),CLASS VARCHAR(25),CLARITY FLOAT,CUT FLOAT,PIECES FLOAT,WEIGHT FLOAT,WT_PER_GM FLOAT,CWP_TYPE_RATE LONG)";
      stmt.executeUpdate(sql1);
      
       String sql2="ALTER TABLE STONE_DETAILS ADD CONSTRAINT FK_ORNID FOREIGN KEY (ORN_FK_ID) REFERENCES INVENTORY(ID)";
       stmt.executeUpdate(sql2);
    
      String sql3="CREATE TABLE INV_MAT(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,MATERIAL VARCHAR(25),IMAGE LONGBLOB )";
     stmt.executeUpdate(sql3);
     String sql4="CREATE TABLE INV_STATISTICS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,TYPE VARCHAR(25),MATERIAL VARCHAR(25),DESIGN_NAME VARCHAR(25),QUANTITY INT,SALES INT,TOTAL_REVENUE LONG,PROFIT LONG)";
      stmt.executeUpdate(sql4);
      String sql5="CREATE TABLE INV_TYPE(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,TYPE VARCHAR(25),IMAGE LONGBLOB )";
     stmt.executeUpdate(sql5);
       String sql6="CREATE TABLE RATES(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,DAY DATE,GOLD_RATE DOUBLE,SILVER_RATE DOUBLE)";
      stmt.executeUpdate(sql6);
      String sql7="CREATE TABLE SOLD_ITEMS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,BARCODE VARCHAR(20),CUSTOMER_ID INT,DATE_OF_PURCHASE DATE,TRANSACTION_NO VARCHAR(25),TYPE VARCHAR(25),MATERIAL VARCHAR(25),DESIGN_NAME VARCHAR(25),PURITY FLOAT,NET_WEIGHT FLOAT,STONE_WEIGHT FLOAT,GROSS_WEIGHT FLOAT,SELLING_PRICE LONG,PROFIT LONG)";
      stmt.executeUpdate(sql7);
       String sql8="CREATE TABLE SOLD_STAT_DAY(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,DATE DATE,NO_OF_TRANSACTIONS INT,NO_OF_SALES INT,TOTAL_REVENUE LONG,PROFIT LONG)";
     stmt.executeUpdate(sql8);
      String sql9="CREATE TABLE SOLD_STATISTICS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,DATE DATE,TYPE VARCHAR(25),MATERIAL VARCHAR(25),DESIGN_NAME VARCHAR(25),NO_OF_SALES INT,TOTAL_REVENUE LONG,PROFIT LONG)";
      stmt.executeUpdate(sql9);
      String sql10="CREATE TABLE STONE_CLASS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(25),CLASS VARCHAR(50))";
     stmt.executeUpdate(sql10);
      String sql11="CREATE TABLE STONE_NAMES(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(25))";
     stmt.executeUpdate(sql11);
     String sql12="CREATE TABLE WHOLESALER(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(25),ADDRESS VARCHAR(100),PHONE_NO VARCHAR(15),EMAIL VARCHAR(25))";
     stmt.executeUpdate(sql12);

     
      sql="CREATE TABLE CUSTOMER(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(50),MOBILE VARCHAR(50),CITY VARCHAR(50))";
      stmt.executeUpdate(sql);
      sql="create table items( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, invoiceid int(5), material varchar(20), item varchar(20), grosswt float(15), purity float(10), value INT(10), priceagreed INT(10), presentinbank varchar(10))";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE invoice(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,customer VARCHAR(20),amount INT(10),interestrate FLOAT,dateoflending DATE,paymentmode varchar(20),description varchar(100),interest INT(10),payable INT(10),last_paid DATE,principal INT(10),last_interest_added DATE)";
      stmt.executeUpdate(sql);

      sql="CREATE TABLE payments(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,invoiceid INT(4),amount INT(10),dateofpayment DATE,paymentmode VARCHAR(10),interestcut INT(10),principalcut INT(10))";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE payments ADD CONSTRAINT fk_customerpaymentid FOREIGN KEY (invoiceid) REFERENCES invoice(id)";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE items ADD CONSTRAINT fk_customeritemid FOREIGN KEY (invoiceid) REFERENCES invoice(id)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE assets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,customer VARCHAR(20),address VARCHAR(20),amount INT(10),interestrate FLOAT,compoundafter INT(10),dateoflending DATE,interest INT(10),payable INT(10),last_paid DATE,principal INT(10),last_interest_added DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE assetspayments(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,assetsid INT(4),amount INT(10),dateofpayment DATE,paymentmode VARCHAR(10),interestcut INT(10),principalcut INT(10))";
      stmt.executeUpdate(sql);

      sql="ALTER TABLE assetspayments ADD CONSTRAINT fk_assetsid FOREIGN KEY (assetsid) REFERENCES assets(id)";
      stmt.executeUpdate(sql);
      
      sql="CREATE TABLE liabilities(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,customer VARCHAR(20),address VARCHAR(20),amount INT(10),interestrate FLOAT,compoundafter INT(10),dateoflending DATE,interest INT(10),payable INT(10),last_paid DATE,principal INT(10),last_interest_added DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE liabilitiespayments(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,liabilitiesid INT(4),amount INT(10),dateofpayment DATE,paymentmode VARCHAR(10),interestcut INT(10),principalcut INT(10))";
      stmt.executeUpdate(sql);
      sql="ALTER TABLE liabilitiespayments ADD CONSTRAINT fk_liabilitiesid FOREIGN KEY (liabilitiesid) REFERENCES liabilities(id)";
      stmt.executeUpdate(sql);
      
     
      
      System.out.println("Database created successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample