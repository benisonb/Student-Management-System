package P3;

import java.awt.*;
import javax.swing.*;

import P4.DisplayWindow;

/**
 * @author Benison Binoy    2262044
 * 
 * Details: Loading Page while traversing between Login Page and Main Menu of
 * the Student Management System a.k.a SMS.
 * The Page inserts a 2 second delay in the event of a successfull login from the Login Page.
 * After the 2 second delay the program automatically redirects the window
 * to the Homepage closing the current windows including 
 * the Login Page and Loading Screen.
 * 
 */

public class LoadingPage extends JPanel {

    private Image image;

    public LoadingPage() {
        // Load the image using a MediaTracker for proper loading
        Toolkit t = Toolkit.getDefaultToolkit();
        image = t.getImage("lib/loading.gif");
        try {
            MediaTracker tracker = new MediaTracker(this);
            tracker.addImage(image, 0);
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Calculate scaled image dimensions (50% of original)
        int scaledWidth = image.getWidth(this) / 2;
        int scaledHeight = image.getHeight(this) / 2;

        // Center the image within the panel
        int xOffset = (getWidth() - scaledWidth) / 2;
        int yOffset = (getHeight() - scaledHeight) / 2;

        g.drawImage(image, xOffset, yOffset, scaledWidth, scaledHeight, this);
    }

    public void OpenLoading() {

        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Loading...");
            LoadingPage m = new LoadingPage();
            f.add(m);
            f.setSize(400, 300); // Set window size (adjust as needed)
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            DisplayWindow Page4 = new DisplayWindow();
                            Page4.OpenDisplayWindow();
                            f.setVisible(false);
                            f.dispose();
                        }
                    },
                    2000);
        });
    }
}
