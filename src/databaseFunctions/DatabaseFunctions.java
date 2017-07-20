/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFunctions;
import Interface.WelcomeCustomer;
import static databaseFunctions.DatabaseFunctions.conn;
import static databaseFunctions.DatabaseFunctions.connectToDatabase;
import static databaseFunctions.DatabaseFunctions.currentUserId;
import loginMechanism.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class DatabaseFunctions {
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/ecommercedatabase?zeroDateTimeBehavior=convertToNull";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public static Connection conn = null;
   static String currentUserId;
   
public static void connectToDatabase(){
    
       try{
      
      Class.forName(JDBC_DRIVER);

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
   
      }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
    }finally{}
    }//end try
   
    public static void loginCustomer(User current){
       
      connectToDatabase();
      
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
        
            String sql = "SELECT * FROM userdata WHERE userId='"+current.getUserId()+"' AND password='"+current.getPassword()+"';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!rs.next()){
                System.out.println("Retry");
                LoginFrameCustomer.main(null);
            }
            else{
                currentUserId = rs.getString("userId");
                current.loggedIn();
            }
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
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
  }
    
    public static void loginAdmin(User current){
       
      connectToDatabase();
      
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
        
            String sql = "SELECT * FROM admindetails WHERE adminId='"+current.getUserId()+"' AND password='"+current.getPassword()+"';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!rs.next()){
                System.out.println("Retry");
                LoginFrameCustomer.main(null);
            }
            else{
                current.loggedIn();
            }
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
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
    }
    public static boolean isSignupCustomer(User current){
       connectToDatabase();
        try{
            Statement stmt = null;
            stmt = conn.createStatement();
        
            String sql = "SELECT * FROM userdata WHERE userId='"+current.getUserId()+"' AND password='"+current.getPassword()+"';";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if(!rs.next()){
                
             String query = "INSERT INTO userdata (userId,password)"+"VALUES(?,?)";
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, current.getUserId());
             ps.setString(2, current.getPassword());
             ps.execute();
             return true;
            } 
            else{
                return false;
            }
        }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
        return false;
   }
 public static void addToCart(int productId) throws SQLException{
    
        connectToDatabase();
        updateStock(productId,0);
        Statement stmt = null;
        stmt=conn.createStatement();
        String sql = "SELECT amount FROM productdetails WHERE id="+productId;
        ResultSet rs = stmt.executeQuery(sql);
        try{
            String query = "INSERT INTO orders (userId,productId,amount)"+"VALUES(?,?,?)";
            while(rs.next()){
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, currentUserId);
             ps.setInt(2, productId);
             ps.setFloat(3,rs.getFloat("amount"));
             ps.execute();   
            }
            UpdateMyCart();
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
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}
    public static void UpdateMyCart(){
        WelcomeCustomer.clearCartTable();
        connectToDatabase();
        Statement stmt1 = null;
        Statement stmt2 = null;
        int thisProductId;
        String sql1 = "SELECT productId,amount FROM orders WHERE status='InCart' AND userId='"+currentUserId+"'";
        try{
            stmt1=DatabaseFunctions.conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql1);
            int i=0;
            while(rs1.next()){
                thisProductId = rs1.getInt("productId");
                String sql2 = "SELECT catagory,subCatagory,modelName,brand FROM productdetails WHERE id="+thisProductId;
                stmt2=DatabaseFunctions.conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);
                while(rs2.next()){
                	DefaultTableModel m2 = (DefaultTableModel) WelcomeCustomer.MyCart.getModel();
                	m2.addRow(new Object []{i,rs2.getString("catagory")+"/"+rs2.getString("subCatagory"),rs2.getString("modelName"),rs2.getString("brand"),rs1.getFloat("amount")});
                	i++;
                }
            }
            System.out.println("Cart Updated");
        updateTotalAmount();
        }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            conn.close();
      }catch(SQLException se){
      }try{
         if(stmt2!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
    }

    public static void updateStock(int productId,int index){
        Statement statement = null;
       try {
           statement=conn.createStatement();
           String sql=null;
           if(index==0){
                sql="UPDATE productdetails SET stock=stock-1 WHERE id="+productId;           
           }else if(index==1){
               sql="UPDATE productdetails SET stock=stock+1 WHERE id="+productId;
           }
           
           statement.execute(sql);
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public static void removeFromCart(String removeMe){
        connectToDatabase();
        Statement stmt1 = null;
        Statement stmt2 = null;
        System.out.println(removeMe);
        String sql1 = "SELECT id FROM productdetails WHERE modelName='"+removeMe+"'";
       try {
           stmt1=conn.createStatement();
           ResultSet rs1 = stmt1.executeQuery(sql1);
           
           while(rs1.next()){
               int myProductId = rs1.getInt("id");
               String sql2 = "DELETE FROM orders WHERE userId='"+currentUserId+"' AND productId="+myProductId;
               stmt2 = conn.createStatement();
               stmt2.execute(sql2);
               updateStock(myProductId,1);
           }
           UpdateMyCart();
           
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
       WelcomeCustomer.clearCartTable();
       UpdateMyCart();
    }
    public static void updateTotalAmount(){
        float netAmount = 0;
        connectToDatabase();
        Statement statement = null;
       try {
           statement=conn.createStatement();
           String sql=null;
               sql="SELECT amount FROM orders WHERE status='InCart' AND userId = '" + currentUserId + "'";
           ResultSet rs = statement.executeQuery(sql);
           while(rs.next()){
               netAmount+=rs.getFloat(1);
           }
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
        WelcomeCustomer.jLabel11.setText(String.valueOf(netAmount));
        WelcomeCustomer.jLabel20.setText(String.valueOf(netAmount));
    }
    public static void updateMyHomeAddress(String address,String city,int pincode){
        connectToDatabase();
        Statement stmt = null;
       try {
           stmt = conn.createStatement();
           String query = "UPDATE userdata SET address = '"+address+"', city = '"+city+"', pincode = "+pincode+" WHERE userId = '"+currentUserId+"'";
           stmt.execute(query);
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static ResultSet getMyHomeAddress(){
        connectToDatabase();
        Statement statement = null;
       try {
           statement=conn.createStatement();
           String sql=null;
           sql="SELECT address,city,pincode FROM userdata WHERE userId = '" + currentUserId + "'";
           ResultSet rs = statement.executeQuery(sql);
           return rs;
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    public static void confirmOrder(String address, String city, int pincode){
        connectToDatabase();
        Statement stmt = null;
       try {
           stmt = conn.createStatement();
           String query = "UPDATE orders SET address = '"+address+"', city = '"+city+"', pincode = "+pincode+", status='Delivered' WHERE userId = '"+currentUserId+"'";
           stmt.execute(query);
          }catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static void addImage(String URL, int id){
       try {
           connectToDatabase();
           Statement stmt = null;
           stmt = conn.createStatement();
           String sql="UPDATE productdetails SET imageURL = '"+URL+"' WHERE id = "+id;
           stmt.execute(sql);
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    public static void getImage(int id){
       try {
           connectToDatabase();
           Statement stmt = null;
           stmt=conn.createStatement();
           String sql="SELECT imageURL from productdetails WHERE id ="+id;
           ResultSet rs =stmt.executeQuery(sql);
           while(rs.next()){
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
   
    
    
    


