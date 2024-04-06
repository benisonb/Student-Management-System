package P6;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Test2 {
    JFrame frame6 = new JFrame();
    JPanel op = new JPanel();
    JPanel ip = new JPanel();
    JPanel p = new JPanel();
    JLabel title = new JLabel("Student Details:");
    JTextField rt = new JTextField();
    JLabel jLabel3 = new JLabel();
    
    JButton b1=new JButton("Back");
    JButton b2=new JButton("Apply");

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
        JTextField rt = new JTextField();
        gbc.gridx++;
        gbc.gridwidth = 2; // Span across two columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        rt.setPreferredSize(new Dimension(200, 50)); // width
        rt.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        rt.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(rt, gbc);

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
        JTextField regNoTextField = new JTextField();
        gbc.gridx++; // Move to the next column
        gbc.gridwidth = 2; // Span across two columns
        regNoTextField.setPreferredSize(new Dimension(200, 50)); // width
        regNoTextField.setFont(new Font("Arial", Font.PLAIN, 12)); // font size
        regNoTextField.setBorder(new RoundedBorder(15, Color.BLACK)); // Black border color
        p.add(regNoTextField, gbc);

        // Label "PP:"
        JLabel ppLabel = new JLabel("PP: ");
        ppLabel.setForeground(Color.BLACK);
        ppLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0; // Reset to the first column
        gbc.gridy++; // Move to the next row
        p.add(ppLabel, gbc);

        // PP TextBox
        JTextField ppTextField = new JTextField();
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
        JTextField osTextField = new JTextField();
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
        JTextField pqtTextField = new JTextField();
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
        gbc.insets = new Insets(20, 5, 5, 5); // Adjusted insets for better spacing
        p.add(b1, gbc);

        // Add b2 (Apply) button
        gbc.gridy++; // Move to the next row
        p.add(b2, gbc);

        frame6.add(op);
        frame6.add(ip);
        frame6.add(p);
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
