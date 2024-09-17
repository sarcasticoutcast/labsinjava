import java.awt.*;
import javax.swing.*;

public class SmileyFace extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Cast to Graphics2D for better control over rendering
        Graphics2D g2d = (Graphics2D) g;
        
        // Set anti-aliasing for smoother drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw the face (circle)
        g2d.setColor(Color.YELLOW); // Yellow color for the face
        g2d.fillOval(100, 50, 200, 200); // x, y, width, height
        
        // Draw the left eye
        g2d.setColor(Color.BLACK); // Black color for the eyes
        g2d.fillOval(150, 100, 20, 30); // x, y, width, height
        
        // Draw the right eye
        g2d.fillOval(230, 100, 20, 30); // x, y, width, height
        
        // Draw the smile (arc)
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5)); // Set the thickness of the smile
        g2d.drawArc(150, 150, 100, 50, 0, -180); // x, y, width, height, start angle, arc angle
    }

    public static void main(String[] args) {
        // Create the frame (window) for the application
        JFrame frame = new JFrame("Smiley Face");
        
        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the custom JPanel to the frame
        frame.add(new SmileyFace());
        
        // Set the size of the window
        frame.setSize(400, 400);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
