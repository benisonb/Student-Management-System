package P2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import P3.LoadingPage;

/**
 * @author Athul Nambior    2262041
 * 
 * Details: Login Page of the Student Management System a.k.a SMS.
 * In the event of a succesfull Login the user is presented with
 * a Login Successful pop-up window and a Loading scren on clicking ok.
 * If the Password or ID seem to be incorect the user is presented with
 * a pop-up window indicating that the ologin details are incorrect.
 * 
 */

public class App implements ActionListener{

    JButton b1 = new JButton("Log In");
    JPanel outerPanel = new JPanel();
    JPanel innerPanel = new JPanel();
    JPanel loginPanel = new JPanel(); // Panel for login components
    JPanel imagePanel = new JPanel(); // Panel for the image
    JFrame frame2 = new JFrame();
    JTextField uid = new JTextField();
    JPasswordField pw = new JPasswordField();
    JLabel title = new JLabel("Login to your Account!");
    JLabel imageLabel;

    public App() {
        frame2.setVisible(true);
        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame2 to full screen
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Outer Panel with BorderLayout
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBackground(Color.WHITE); // White background color

        // Inner Panel with BorderLayout
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setBackground(new Color(225, 225, 225)); // #cecece background color
        innerPanel.setBorder(BorderFactory.createEmptyBorder(50, 400, 100, 400)); // Adjusted insets for better spacing
        innerPanel.setPreferredSize(new Dimension(1200, 500));

        // Add title to the top of the login panel with a gap
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);
        loginPanel.add(title, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 0, 0, 0), 0, 0));

        // Create a panel for login components
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        imagePanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Set the components to the left column
        gbc.gridy = 1; // Start below the title with a gap
        gbc.anchor = GridBagConstraints.CENTER; // Center the components
        gbc.insets = new Insets(5, 5, 5, 5); // Adjusted insets for better spacing

        // UID Text
        JLabel s = new JLabel("User ID: ");
        s.setForeground(Color.black);
        s.setFont(new Font("Arial", Font.PLAIN, 16));
        loginPanel.add(s, gbc);

        // UID TextBox
        gbc.gridy++;
        uid.setPreferredSize(new Dimension(200, 50)); // width
        uid.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        uid.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        loginPanel.add(uid, gbc);

        // Pw Box
        gbc.gridy++;
        JLabel p = new JLabel("Password: ");
        p.setFont(new Font("Arial", Font.PLAIN, 16));
        p.setForeground(Color.black);
        loginPanel.add(p, gbc);

        gbc.gridy++;
        pw.setPreferredSize(new Dimension(200, 50)); // width
        pw.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        pw.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        loginPanel.add(pw, gbc);

        // Log in button
        gbc.gridy++;
        b1.setFont(new Font("Arial", Font.PLAIN, 16));
        b1.setPreferredSize(new Dimension(200, 50)); // width
        b1.setBackground(new Color(0x1c77ff)); // Set background color to #1c77ff
        b1.setForeground(Color.WHITE); // Set text color to white
        b1.setBorderPainted(false);
        b1.setBorder(new RoundedBorder(15, Color.WHITE));
        b1.setFocusPainted(false);
        b1.setBorder(new RoundedBorder(15, new Color(0x1c77ff))); // Set border color to #1c77ff
        b1.setOpaque(true);
        b1.addActionListener(this);
        

        loginPanel.add(b1, gbc);

        // Add the login panel to the center of the inner panel
        innerPanel.add(loginPanel, BorderLayout.WEST); // Move the login panel to the left

        // Panel for the image on the right side
        imagePanel.setLayout(new BorderLayout());
        // Load and set the image with a specific size
        ImageIcon originalImageIcon = new ImageIcon("lib\\ManChair.png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledImageIcon);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Add the image panel to the right of the inner panel
        innerPanel.add(imagePanel, BorderLayout.CENTER);

        // Add the inner panel to the outer panel
        outerPanel.add(innerPanel, BorderLayout.CENTER);

        // Add the outer panel to the frame2
        frame2.add(outerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        if (e.getSource() == b1) {
            String usernameInput = uid.getText();
            char[] passwordInput = pw.getPassword();
            String passwordString = new String(passwordInput);

            // Replace "test" and "123" with your actual username and password
            String correctUsername = "test";
            String correctPassword = "123";

            if (usernameInput.equals(correctUsername) && passwordString.equals(correctPassword)) {
                JOptionPane.showMessageDialog(frame2, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame2.dispose();
                frame2.setVisible(false);
                LoadingPage Page3=new LoadingPage();
                Page3.OpenLoading();
            } else {
                JOptionPane.showMessageDialog(frame2, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void OpenHome() {
        SwingUtilities.invokeLater(() -> new App());
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
}
