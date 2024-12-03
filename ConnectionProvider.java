import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection con;
    public static Connection getCon() {
        try {
            if(con==null){
                //load the driver
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/learningjdbc";
                //create the connection
                con = DriverManager.getConnection(url,"root","Harsh@123");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
