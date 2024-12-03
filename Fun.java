import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Fun {
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

            //create a query
            String q="insert into employee(name,city,address,phone,email) values(?,?,?,?,?)";
              PreparedStatement pstmt = con.prepareStatement(q);
              //manually set the values
//            pstmt.setString(1,"Anshika");
//            pstmt.setString(2,"Delhi");
//            pstmt.setString(3,"Lucknow");
//            pstmt.setString(4,"1234567890");
//            pstmt.setString(5,"harsh@gmail.com");

            //input from keyboard
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the name");
            String name = br.readLine();
            System.out.println("Enter the city");
            String city = br.readLine();
            System.out.println("Enter the address");
            String address = br.readLine();
            System.out.println("Enter the phone");
            String phone = br.readLine();
            System.out.println("Enter the email");
            String email = br.readLine();
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setString(3,address);
            pstmt.setString(4,phone);
            pstmt.setString(5,email);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }}
}
