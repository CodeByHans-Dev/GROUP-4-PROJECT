

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ogin {
    public static boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); 

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("📝 Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("🔒 Enter Password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("✅ Login Successful! Welcome, " + username + "!");
        } else {
            System.out.println("❌ Invalid Username or Password.");
        }

        scanner.close();
    }
}
    