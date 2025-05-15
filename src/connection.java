import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static Connection con = null;

    static {
        try {
            // Load the JDBC driver (for MySQL, it's com.mysql.cj.jdbc.Driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "root", "TVLict@hans098179");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to return the connection
    public static Connection getCon() {
        return con;
    }
}