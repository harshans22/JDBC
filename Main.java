import javax.swing.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        try{
        Connection c=ConnectionProvider.getCon();
        String q="insert into images(pic) values(?)";
        PreparedStatement pstmt = c.prepareStatement(q);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            String path = jfc.getSelectedFile().getAbsolutePath();
            FileInputStream fis = new FileInputStream(path);
            pstmt.setBinaryStream(1, fis,fis.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Image inserted successfully");
            //show the selected image in the frame
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
