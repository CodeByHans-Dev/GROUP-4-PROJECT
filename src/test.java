import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        try {
            // Load the driver (ensure you have the correct driver class)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumni_system", "root", "TVLict@hans098179");

            if (con != null) {
                System.out.println("Database connected successfully!");
                con.close(); // Close connection after testing
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found! Check your library.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}