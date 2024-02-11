import javax.swing.*;
import java.awt.*;

public class PizzaApplication {
    public PizzaApplication() {
        JFrame frame = new JFrame();

        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Number of clicks: 0");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Big Y Pizza Store");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new PizzaApplication();

    }

}