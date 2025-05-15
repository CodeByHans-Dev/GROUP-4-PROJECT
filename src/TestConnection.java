/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xx
 */
public class TestConnection {
   
    public static void main(String[] args) {
        if (DBConnection.connect() != null) {
            System.out.println("✅ MySQL Connection Successful!");
        } else {
            System.out.println("❌ Connection Failed.");
        }
    }
}

