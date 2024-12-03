import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageSave {
    public static void main(String[] args) {
        try{
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/learningjdbc";
            //create the connection
            Connection con = DriverManager.getConnection(url,"root","Harsh@123");
            String q="insert into images(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            FileInputStream fis = new FileInputStream("C:/Users/pc/Desktop/BABA/baba.jpg");
            pstmt.setBinaryStream(1, fis);
            pstmt.executeUpdate();
            System.out.println("Image inserted successfully");
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
