
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xx
 */
public class TestConnection1 {
    public static void main(String[] args) {
        Connection con = DatabaseConnection.getConnection();
        if (con != null) {
            System.out.println("✅ Database connected successfully!");
        } else {
            System.out.println("❌ Database connection failed!");
        }
    }
}
