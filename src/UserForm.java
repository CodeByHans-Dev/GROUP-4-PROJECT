import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UserForm extends JFrame {

    static Connection getConnection(String jdbcmysqllocalhost3306dbname, String root, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private JTable table;
    private DefaultTableModel tableModel;

    public UserForm() {
        setTitle("User Information");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        // Create Table Model
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add columns
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Mobile No.");
        tableModel.addColumn("Email");
        tableModel.addColumn("Address");

        add(scrollPane, java.awt.BorderLayout.CENTER);

        // Load user data
        loadUserData();

        setVisible(true);
    }

    private void loadUserData() {
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, mobileno, email, address FROM appuser")) {

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("mobileno"),
                        rs.getString("email"),
                        rs.getString("address")
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UserForm();
    }
}

