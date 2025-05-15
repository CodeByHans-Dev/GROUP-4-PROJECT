import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/alumni_system";
    private static final String USER = "root"; // Palitan kung may ibang user
    private static final String PASS = "TVLict@hans098179"; // Palitan kung may password ang MySQL

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Database Connected Successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed: " + e.getMessage());
            return null;
        }
    }
}


