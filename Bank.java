import java.util.*;
import java.sql.*;
public class Bank {
    public static void main(String[] args) {
        try
        {   Scanner scn=new Scanner(System.in);
           int ch;
           while(true){
	   System.out.println("------------Welcome to SBI-----------");
            System.out.println("-----------MAIN MENU--------- ");
            System.out.println("1. NEW ACCOUNT  ");
            System.out.println("2. DEPOSIT ACCOUNT ");
            System.out.println("3. WITHDRAW ACCOUNT ");
            System.out.println("4. BALANCE ENQUIRY ");
            System.out.println("5. ALL ACCOUNT HOLDER LIST ");
            System.out.println("6. CLOSE AN ACCOUNT ");
            System.out.println("7. MODIFY AN ACCOUNT ");
            System.out.println("8. EXIT ");
            
            System.out.print("Enter your choice :  ");
           ch=scn.nextInt();
            switch(ch){
                case 1: 
                    System.out.print("Enter Account Number:  ");
                    int accno=scn.nextInt();
			
                    System.out.print("Enter Name : ");
                    String name=scn.next();
			
                     System.out.print("Enter city:  ");
                     String city=scn.next();
			
                     System.out.print("Enter mobileno : ");
                     int mob=scn.nextInt();
			
                     System.out.print("Enter Amount:  ");
                      int amt=scn.nextInt();
			
                     Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                      String q="insert into bank values('"+accno+ "',' "+name+" ',' "+city+ " ',' "+mob+" ',' "+amt+" ')";
                      PreparedStatement pst=con.prepareStatement(q);
                     int i=pst.executeUpdate();
                     if(i>0){
                    System.out.println("Account created");}
                     else{
                     System.out.println("Account not created"); }
			System.out.println( );
                    break;
			
                case 2: 
                    System.out.print("Enter Deposit Amount:  ");
                    int depamt=scn.nextInt();
			
                    System.out.print("Enter Account Number : ");
                    int accno1=scn.nextInt();
			
                    Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                      String q1="update bank set amount=amount+'"+depamt+"'where accno='"+accno1+"'";
                      PreparedStatement pst1=con1.prepareStatement(q1);
                     int j=pst1.executeUpdate();
                     if(j>0){
                    System.out.println("Account deposited");}
                     else{
                     System.out.println("Account not deposited"); }
			System.out.println( );
                    break;
			
                 case 3:
                     System.out.print("Enter Withdraw Amount:  ");
                    int withdamt=scn.nextInt();
			
                    System.out.print("Enter Account Number:  ");
                    int accno2=scn.nextInt();
			
                    Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                      String q2="update bank set amount=amount-'"+withdamt+"'where accno='"+accno2+"'";
                      PreparedStatement pst2=con2.prepareStatement(q2);
                     int k=pst2.executeUpdate();
                     if(k>0){
                    System.out.println("Amount withdrawn");}
                     else{
                     System.out.println("Amount not withdrawn"); }
			System.out.println( );
                    break;
		
                 case 4:
                     System.out.print("Enter Account Number:  ");
                    int accno3=scn.nextInt();
			
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                     String q3="select *from bank where accno='"+accno3+"'";
                     PreparedStatement pst3=con3.prepareStatement(q3);
                     ResultSet rs=pst3.executeQuery();
                     System.out.println("Amount is:");
                     while(rs.next()){
                         System.out.print(rs.getInt(5)+"    ");
                     }System.out.println( );
                      break;
			
                 case 5: 
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                     String q4="select *from bank";
                     PreparedStatement pst4=con4.prepareStatement(q4);
                     ResultSet rs1=pst4.executeQuery();
                     while(rs1.next()){
                         System.out.println(rs1.getInt(1)+"    "+rs1.getString(2)+"    "+rs1.getString(3)+"    "+rs1.getLong(4)+"    "+rs1.getInt(5));
                     }System.out.println( );
                    break;
	
                 case 6:
                      System.out.print("Enter Account Number to Delete:  ");
                    int daccno=scn.nextInt();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                      String q5="delete from bank where accno='"+daccno+"'";
                      PreparedStatement pst5=con5.prepareStatement(q5);
                     int l=pst5.executeUpdate();
                     if(l>0){
                    System.out.println("Account deleted");}
                     else{
                     System.out.println("Account not deleted"); }System.out.println( );
                     break;
			
                 case 7:
                     System.out.print("Enter Account Number to be modified  ");
                    int accno7=scn.nextInt();
		
                    System.out.print("Enter New Name  ");
                    String name1=scn.next();
			
                     System.out.print("Enter  New city  ");
                     String city1=scn.next();
			
                     System.out.print("Enter New mobileno  ");
                     int mob1=scn.nextInt();
			
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con6=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp_78","root","Jajicse@2003");
                      String q6="update bank set name= '"+name1+"' ,city='"+city1+"',mob='"+mob1+"'where accno='"+accno7+"'";
                      PreparedStatement pst6=con6.prepareStatement(q6);
                     int m=pst6.executeUpdate();
                     if(m>0){
                    System.out.println("Account modified");}
                     else{
                     System.out.println("Account not modified"); }System.out.println( );
                    break;
			
                 case 8:
                     return;
            }
           }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
