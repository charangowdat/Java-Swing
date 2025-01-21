import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AWTExample {
    public static void main(String[] args) {
        // Create a frame
        Frame frame = new Frame("AWT Example");

        // Set layout manager to null for absolute positioning
        frame.setLayout(null);

        // Create components
        Label label = new Label("Are you dumb?");
        Label label1 = new Label("We Know it");
        Button button1 = new Button("Yes");
        Button button2 = new Button("No");
        Random rand = new Random();

        // Set initial bounds for components
        label.setBounds(200, 50, 100, 30); // x, y, width, height
        button1.setBounds(150, 150, 50, 30);
        button2.setBounds(250, 150, 50, 30);

        // Add event listener to button2 (No Button) for hover action
        button2.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                // Generate random positions for the button when hovered over
                int a = rand.nextInt(330 - 10 + 1) + 10; // x position (within frame)
                int b = rand.nextInt(220 - 40 + 1) + 40; // y position (within frame)
                button2.setBounds(a, b, 50, 30); // Move the button to the new random position
            }
        });

        // Add event listener to button1 (Yes Button)
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setBounds(200, 200, 150, 30); // Position the label
                frame.add(label1); // Add label to the frame
                frame.repaint(); // Refresh the frame to show the label
            }
        });

        // Add components to the frame
        frame.add(label);
        frame.add(button1);
        frame.add(button2);

        // Set frame properties
        frame.setSize(500, 300);
        frame.setVisible(true);

        // Add window closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
