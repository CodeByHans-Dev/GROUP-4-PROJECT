import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection1 {
    public static Connection connect() {
        try {
            // Database URL, username, and password for connection
            String url = "jdbc:mysql://localhost:3306/alumni_db"; // Make sure to match the database name
            String username = "root"; // Your new username
            String password = "TVLict@hans098179"; // Your new password

            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}