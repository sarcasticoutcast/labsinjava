import java.awt.*;
import javax.swing.*;

public class hutScene extends JPanel {

    // Override the paintComponent method to draw the scene
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast Graphics to Graphics2D for more control
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother shapes
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the sky (light blue background)
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the ground (green grass)
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, getHeight() / 2, getWidth(), getHeight() / 2);

        // Draw mountains
        drawMountain(g2d, 50, 150, 200, 200, Color.DARK_GRAY); // Left mountain
        drawMountain(g2d, 200, 100, 300, 250, Color.GRAY); // Center mountain
        drawMountain(g2d, 400, 150, 200, 200, Color.DARK_GRAY); // Right mountain

        // Draw the hut
        drawHut(g2d, 250, 300);

        // Draw trees around the hut
        drawTree(g2d, 100, 350);
        drawTree(g2d, 400, 350);
    }

    // Method to draw a mountain as a triangle
    private void drawMountain(Graphics2D g2d, int x, int y, int width, int height, Color color) {
        g2d.setColor(color);
        int[] xPoints = { x, x + width / 2, x + width };
        int[] yPoints = { y + height, y, y + height };
        g2d.fillPolygon(xPoints, yPoints, 3); // Draw a triangle as a mountain
    }

    // Method to draw a hut
    private void drawHut(Graphics2D g2d, int x, int y) {
        // Draw the base of the hut (brown rectangle)
        g2d.setColor(new Color(139, 69, 19)); // Brown color
        g2d.fillRect(x, y, 120, 80); // Base of the hut

        // Draw the roof (red triangle)
        g2d.setColor(Color.RED);
        int[] xPoints = { x, x + 60, x + 120 };
        int[] yPoints = { y, y - 60, y };
        g2d.fillPolygon(xPoints, yPoints, 3); // Roof of the hut

        // Draw the door (black rectangle)
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + 45, y + 40, 30, 40); // Door in the center of the hut
    }

    // Method to draw a tree (trunk and leaves)
    private void drawTree(Graphics2D g2d, int x, int y) {
        // Draw the trunk (brown rectangle)
        g2d.setColor(new Color(139, 69, 19)); // Brown color for trunk
        g2d.fillRect(x + 20, y, 20, 60); // Trunk of the tree

        // Draw the leaves (green ovals)
        g2d.setColor(Color.GREEN);
        g2d.fillOval(x, y - 30, 60, 50); // Leaves of the tree
        g2d.fillOval(x - 10, y - 60, 80, 50);// More leaves on top
    }

    // Main method to create the frame and display the drawing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hut Scene with Trees and Mountains");
        hutScene scene = new hutScene();

        // Add the panel to the frame
        frame.add(scene);

        // Set the frame size and behavior
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
