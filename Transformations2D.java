import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class Transformations2D extends JPanel {

    // Override paintComponent method for custom drawing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast Graphics object to Graphics2D for advanced operations
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smooth drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Original square (before any transformation)
        drawSquare(g2d, 50, 50, Color.BLACK, 1.0);

        // Apply translation
        AffineTransform translation = new AffineTransform();
        translation.translate(150, 0);
        g2d.setTransform(translation);
        drawSquare(g2d, 50, 50, Color.RED, 1.0);

        // Apply scaling (scale by 2x)
        AffineTransform scaling = new AffineTransform();
        scaling.translate(0, 150); // Move it down to visualize separately
        scaling.scale(2.0, 2.0); // Scale by 2x in both x and y directions
        g2d.setTransform(scaling);
        drawSquare(g2d, 50, 50, Color.BLUE, 0.5); // The square gets scaled down to 50%

        // Apply rotation (rotate by 45 degrees)
        AffineTransform rotation = new AffineTransform();
        rotation.translate(250, 250); // Translate to the center point of rotation
        rotation.rotate(Math.toRadians(45)); // Rotate 45 degrees
        g2d.setTransform(rotation);
        drawSquare(g2d, 0, 0, Color.GREEN, 1.0); // Rotated square
    }

    // Method to draw a square
    private void drawSquare(Graphics2D g2d, int x, int y, Color color, double scaleFactor) {
        g2d.setColor(color);
        int size = (int) (100 * scaleFactor); // Size of the square
        g2d.fillRect(x, y, size, size); // Draw the square at (x, y) with the specified size
    }

    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("2D Transformations Demo");

        // Add the custom JPanel to the frame
        frame.add(new Transformations2D());

        // Set the size of the window
        frame.setSize(400, 400);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}
