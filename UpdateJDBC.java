import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJDBC {
    public static void main(String[] args) {
        try{
            Connection connection = ConnectionProvider.getCon();
            String query = "update employee set phone=?, email=? where empId=?";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the phone");
            String phone = bufferedReader.readLine();
            System.out.println("Enter the email");
            String email = bufferedReader.readLine();
            System.out.println("Enter the empId");
            int empId = Integer.parseInt(bufferedReader.readLine());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, empId);
            preparedStatement.executeUpdate();
            System.out.println("Data updated successfully");
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
