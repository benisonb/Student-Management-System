package P6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import P4.DisplayWindow;

/**
 * @author Benison Binoy    2262044
 * 
 * Details: Data Insertion Page of the Student Management System a.k.a SMS
 * This window offers the user with the capability to insert Student details such as Name, SNo ,
 * RegNo and Marks of 3 Subjects to the MySQL Database.
 * In case the user wants to go back to the previeous window the Back button allows the user
 * to go back to the previous window which offers the Display capabilites.
 * 
 */

public class InsertionWindow implements ActionListener {
    static String nm;
    static int sno, id, m1, m2, m3;
    JFrame frame6 = new JFrame();
    JPanel op = new JPanel();
    JPanel ip = new JPanel();
    JPanel p = new JPanel();
    JLabel title = new JLabel("Student Details:");
    JLabel jLabel3 = new JLabel();
    JTextField sNoTxt = new JTextField();
    JTextField regNoTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField ppTextField = new JTextField();
    JTextField osTextField = new JTextField();
    JTextField pqtTextField = new JTextField();

    JButton b1 = new JButton("Back");
    JButton b2 = new JButton("Apply");

    public void Insertion() {

        frame6.setVisible(true);
        frame6.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame2 to full screen
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer Panel with BorderLayout
        op.setLayout(new BorderLayout());
        op.setBackground(Color.WHITE); // White background color

        // Inner Panel with BorderLayout
        ip.setLayout(new BorderLayout());
        ip.setBackground(new Color(225, 225, 225)); // #cecece background color
        ip.setBorder(BorderFactory.createEmptyBorder(50, 400, 100, 400)); // Adjusted insets for better spacing
        ip.setPreferredSize(new Dimension(1200, 500));

        // Add title to the top of the login panel with a gap
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);
        p.add(title, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 0, 0, 0), 0, 0));

        // Create a panel for login components
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Set the components to the left column
        gbc.gridy = 1; // Start below the title with a gap
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(5, 5, 5, 5); // Adjusted insets for better spacing

        // Label "S No:"
        JLabel s = new JLabel("S No: ");
        s.setForeground(Color.BLACK);
        s.setFont(new Font("Arial", Font.PLAIN, 16));
        p.add(s, gbc);

        // SNo TextBox
        gbc.gridx++;
        gbc.gridwidth = 2; // Span across two columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        sNoTxt.setPreferredSize(new Dimension(200, 50)); // width
        sNoTxt.setFont(new Font("Arial", Font.PLAIN, 12)); // Sfont size
        sNoTxt.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(sNoTxt, gbc);

        // Reset gridwidth to 1 for subsequent components
        gbc.gridwidth = 1;

        // Label "Reg No:"
        JLabel regNoLabel = new JLabel("Reg No: ");
        regNoLabel.setForeground(Color.BLACK);
        regNoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(regNoLabel, gbc);

        // Reg No TextBox
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        regNoTextField.setPreferredSize(new Dimension(200, 50)); // width
        regNoTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        regNoTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(regNoTextField, gbc);

        // Label "Name:"
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(nameLabel, gbc);

        // Name TextBox
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        nameTextField.setPreferredSize(new Dimension(200, 50)); // width
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        nameTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(nameTextField, gbc);

        // Label "PP:"
        JLabel ppLabel = new JLabel("PP: ");
        ppLabel.setForeground(Color.BLACK);
        ppLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(ppLabel, gbc);

        // PP TextBox
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        ppTextField.setPreferredSize(new Dimension(200, 50)); // width
        ppTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        ppTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(ppTextField, gbc);

        // Label "OS:"
        JLabel osLabel = new JLabel("OS: ");
        osLabel.setForeground(Color.BLACK);
        osLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(osLabel, gbc);

        // OS TextBox
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        osTextField.setPreferredSize(new Dimension(200, 50)); // width
        osTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        osTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(osTextField, gbc);

        // Label "PQT:"
        JLabel pqtLabel = new JLabel("PQT: ");
        pqtLabel.setForeground(Color.BLACK);
        pqtLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(pqtLabel, gbc);

        // PQT TextBox
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        pqtTextField.setPreferredSize(new Dimension(200, 50)); // width
        pqtTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        pqtTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(pqtTextField, gbc);

        // Add Apply and Cancel buttons just below the PQT label and text field
        gbc.gridy++; // Move to the next row
        gbc.gridx = 0; // Reset to the first column
        gbc.gridwidth = 3; // Span across three columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally

        // Add b1 (Back) button
        gbc.gridy++; // Move to the next row
        gbc.anchor = GridBagConstraints.CENTER; // Align button to the center
        gbc.fill = GridBagConstraints.NONE; // Set to no fill
        gbc.weightx = 0; // Reset weight
        gbc.gridwidth = 1; // Set grid width to 1
        gbc.insets = new Insets(20, 5, 5, 5); // Adjusted insets for better spacing
        b1.setPreferredSize(new Dimension(200, 50)); // Set button size
        b1.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font
        b1.setBackground(new Color(0x1c77ff)); // Set background color to #1c77ff
        b1.setForeground(Color.WHITE); // Set text color to white
        b1.setBorderPainted(false); // Disable border painting
        b1.setFocusPainted(false); // Disable focus painting
        b1.setOpaque(true); // Set opaque to true for background color
        b1.setBorder(new RoundedBorder(15, Color.WHITE)); // Apply rounded border
        p.add(b1, gbc); // Add button to panel

        // Add b2 (Apply) button
        gbc.gridx++; // Move to the next column
        gbc.insets = new Insets(20, 5, 5, 5); // Adjusted insets for better spacing
        b2.setPreferredSize(new Dimension(200, 50)); // Set button size
        b2.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font
        b2.setBackground(new Color(0x1c77ff)); // Set background color to #1c77ff
        b2.setForeground(Color.WHITE); // Set text color to white
        b2.setBorderPainted(false); // Disable border painting
        b2.setFocusPainted(false); // Disable focus painting
        b2.setOpaque(true); // Set opaque to true for background color
        b2.setBorder(new RoundedBorder(15, Color.WHITE)); // Apply rounded border
        p.add(b2, gbc); // Add button to panel

        frame6.add(op);
        frame6.add(ip);
        frame6.add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    class RoundedBorder implements Border {
        private int radius;
        private Color borderColor;

        public RoundedBorder(int radius, Color borderColor) {
            this.radius = radius;
            this.borderColor = borderColor;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(borderColor);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    
    @SuppressWarnings("static-access")
    @Override
    public void actionPerformed(ActionEvent e) {
        SQL_q qr = new SQL_q();
        if ((e.getSource() == b2)) {
            nm = nameTextField.getText();
            sno = Integer.parseInt(sNoTxt.getText());
            id = Integer.parseInt(regNoTextField.getText());
            m1 = Integer.parseInt(ppTextField.getText());
            m2 = Integer.parseInt(osTextField.getText());
            m3 = Integer.parseInt(pqtTextField.getText());
            qr.runQuery();
        }
        if (e.getSource() == b1) { // Go back to the previous window
            // Hide and dispose the Insertion window
            frame6.setVisible(false);
            frame6.dispose();
            // Show the Display Window
            DisplayWindow Page4 = new DisplayWindow();
            Page4.OpenDisplayWindow();
        }
    }
    public void OpenInsertion(){
        Insertion();
    }
}
