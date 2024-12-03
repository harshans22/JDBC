import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC {
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
//            String q="create table employee(empId int primary key auto_increment,name varchar(20) not null,city varchar(20),address varchar(20),phone varchar(20),email varchar(20))";
            String q="create table images(id int primary key auto_increment, pic longblob)";

            //create a statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            //do error handling if statement is not executed
            System.out.println("Table created successfully");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
