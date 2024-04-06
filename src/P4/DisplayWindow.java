package P4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import P6.InsertionWindow;


/**
 * @author Angela Rodrigues 2262027
 * 
 * Details: Main Home Page of the Student Management System a.k.a SMS
 * The Page allow the user to view the student's details all at once or individually
 * by using the buttons allocated at the top of the windoe.
 * On pressing the Insert button the window is closed and The InertionWindow is Opened.
 * 
 */

public class DisplayWindow extends JFrame{
    private JTextField regnoField;
    private JTable resultTable;

    public DisplayWindow() {
        setTitle("Student Details Display");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.white);

        JLabel headingLabel = new JLabel("STUDENT DISPLAY");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        topPanel.add(headingLabel, gbc);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBackground(Color.white);

        regnoField = new JTextField(8);
        JButton searchButton = new JButton("Search by REGNO");
        JButton displayAllButton = new JButton("Display All Students");
        JButton insertButton = new JButton("Insert");

        inputPanel.add(new JLabel("Enter REGNO: "));
        inputPanel.add(regnoField);
        inputPanel.add(searchButton);
        inputPanel.add(displayAllButton);
        inputPanel.add(insertButton);

        searchButton.setBackground(new Color(30, 144, 255));
        searchButton.setForeground(Color.WHITE);
        displayAllButton.setBackground(new Color(50, 205, 50));
        displayAllButton.setForeground(Color.WHITE);
        insertButton.setBackground(new Color(255, 165, 0));
        insertButton.setForeground(Color.WHITE);

        gbc.gridy = 1;
        topPanel.add(inputPanel, gbc);

        add(topPanel, BorderLayout.NORTH);

        resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudentByRegNo();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertionWindow Page6 = new InsertionWindow();
                dispose(); // Close the DisplayWindow
                Page6.OpenInsertion();
            }
        });

        setLocationRelativeTo(null);
        // setVisible(true); // Commented out to make the frame initially invisible
    }

    private void searchStudentByRegNo() {
        int regNo = Integer.parseInt(regnoField.getText());
        displayResults("SELECT * FROM Student_Details WHERE REGNO = " + regNo);
    }

    private void displayAllStudents() {
        displayResults("SELECT * FROM Student_Details");
    }

    private void displayResults(String sqlQuery) {
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "KARS@123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("SNO");
                model.addColumn("REGNO");
                model.addColumn("NAME");
                model.addColumn("PP");
                model.addColumn("OS");
                model.addColumn("PQT");
                model.addColumn("PERCENTAGE");

                while (resultSet.next()) {
                    Object[] row = {
                            resultSet.getInt("SNO"),
                            resultSet.getInt("REGNO"),
                            resultSet.getString("NAME"),
                            resultSet.getInt("PP"),
                            resultSet.getInt("OS"),
                            resultSet.getInt("PQT"),
                            resultSet.getDouble("PERCENTAGE")
                    };
                    model.addRow(row);
                }

                resultTable.setModel(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void OpenDisplayWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayWindow displayWindow = new DisplayWindow();
                displayWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
                displayWindow.setVisible(true);
            }
        });
    }
    public void CloseDisplayWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayWindow displayWindow = new DisplayWindow();
                displayWindow.setVisible(false);
                displayWindow.dispose();
            }
        });
    }
    
}
