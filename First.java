import java.sql.*;

public class First {
    public static void main(String[] args) {
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/learningjdbc";
            //create the connection
            Connection con = DriverManager.getConnection(url,"root","Harsh@123");
            if(con.isClosed()){
                System.out.println("Connection is closed");
            }else{
                System.out.println("Connection is open");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
