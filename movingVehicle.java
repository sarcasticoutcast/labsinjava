import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class movingVehicle extends JPanel implements ActionListener {

    private int xPosition = 0; // Initial x position of the car
    private int yPosition = 200; // Fixed y position of the car

    private Timer timer;

    public movingVehicle() {
        // Set up a timer that triggers an action every 30 milliseconds
        timer = new Timer(30, this);
        timer.start(); // Start the timer to initiate the animation
    }

    // Override paintComponent to draw the vehicle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        setBackground(Color.WHITE);

        // Cast to Graphics2D for better control
        Graphics2D g2d = (Graphics2D) g;

        // Set anti-aliasing for smoother rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the body of the car (rectangle)
        g2d.setColor(Color.BLUE);
        g2d.fillRect(xPosition, yPosition, 100, 50);

        // Draw the roof of the car (smaller rectangle)
        g2d.fillRect(xPosition + 20, yPosition - 30, 60, 30);

        // Draw the wheels (circles)
        g2d.setColor(Color.BLACK);
        g2d.fillOval(xPosition + 10, yPosition + 40, 30, 30); // Left wheel
        g2d.fillOval(xPosition + 60, yPosition + 40, 30, 30); // Right wheel
    }

    // Action listener to move the car
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the x position of the car for the animation
        xPosition += 5; // Move the car 5 pixels to the right

        // Check if the car has moved beyond the screen width
        if (xPosition > getWidth()) {
            xPosition = -100; // Reset car to start from the left of the screen again
        }

        // Repaint the screen to update the car's position
        repaint();
    }

    public static void main(String[] args) {
        // Create the frame (window) for the application
        JFrame frame = new JFrame("Moving Vehicle");

        // Create an instance of the MovingVehicle panel
        movingVehicle vehiclePanel = new movingVehicle();

        // Add the panel to the frame
        frame.add(vehiclePanel);

        // Set the size of the window
        frame.setSize(800, 400);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }
}
