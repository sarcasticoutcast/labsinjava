import java.awt.*;
import javax.swing.*;

public class MidPointCircle extends JPanel {

    // Method to plot the points in all 8 octants of the circle
    private void drawCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        g.drawLine(xc + x, yc + y, xc + x, yc + y); // Octant 1
        g.drawLine(xc - x, yc + y, xc - x, yc + y); // Octant 2
        g.drawLine(xc + x, yc - y, xc + x, yc - y); // Octant 3
        g.drawLine(xc - x, yc - y, xc - x, yc - y); // Octant 4
        g.drawLine(xc + y, yc + x, xc + y, yc + x); // Octant 5
        g.drawLine(xc - y, yc + x, xc - y, yc + x); // Octant 6
        g.drawLine(xc + y, yc - x, xc + y, yc - x); // Octant 7
        g.drawLine(xc - y, yc - x, xc - y, yc - x); // Octant 8
    }

    // Mid-point circle drawing algorithm
    private void drawMidPointCircle(Graphics g, int xc, int yc, int radius) {
        int x = 0;
        int y = radius;
        int p = 1 - radius; // Initial decision parameter

        drawCirclePoints(g, xc, yc, x, y);

        while (x < y) {
            x++;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y--;
                p = p + 2 * (x - y) + 1;
            }
            drawCirclePoints(g, xc, yc, x, y);
        }
    }

    // Override paintComponent method for custom drawing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color
        setBackground(Color.WHITE);

        // Set drawing color
        g.setColor(Color.BLACK);

        // Center coordinates and radius for the circle
        int xc = getWidth() / 2;
        int yc = getHeight() / 2;
        int radius = 100;

        // Draw the circle
        drawMidPointCircle(g, xc, yc, radius);
    }

    public static void main(String[] args) {
        // Create the frame for the application
        JFrame frame = new JFrame("Mid-point Circle Algorithm");

        // Add the custom JPanel to the frame
        frame.add(new MidPointCircle());

        // Set the size of the window
        frame.setSize(400, 400);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}
