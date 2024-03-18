import javax.swing.*;
import java.awt.*;

public class DemoPizzaGUI extends JFrame {
    private JLabel labelToppings;
    private JTextField textFieldToppings;
    private JButton buttonAddTopping;
    private JButton buttonDeliver;
    private JButton buttonNoDeliver;
    private JTextArea textAreaOutput;
    private JLabel title;

    private static final int MAX_TOPPINGS = 10;
    private static final String QUIT = "QUIT";

    private String[] toppings = new String[MAX_TOPPINGS];
    private int numToppings = 0;
    private boolean isDelivered = false;
    private String deliveryAddress;
    private String name;

    public DemoPizzaGUI() {
        setTitle("J's Pizza Delivery Service");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelToppings = new JLabel("Enter Your Toppings (Max 10, type 'QUIT' to close):");
        textFieldToppings = new JTextField(20);
        buttonAddTopping = new JButton("Add Topping");
        buttonDeliver = new JButton("Delivery");
        buttonNoDeliver = new JButton("No Delivery/Pickup");
        textAreaOutput = new JTextArea(15, 36);
        textAreaOutput.setBackground(Color.ORANGE);

        title = new JLabel("Welcome To J's Pizzeria!!");
        title.setFont(new Font("Georgia", Font.BOLD, 20));
        title.setForeground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);


        JScrollPane scrollPane = new JScrollPane(textAreaOutput);

        JPanel panel = new JPanel();
        panel.add(labelToppings);
        panel.add(textFieldToppings);
        panel.add(buttonAddTopping);
        panel.add(buttonDeliver);
        panel.add(buttonNoDeliver);
        panel.add(scrollPane);
        add(panel);

        buttonAddTopping.addActionListener(e -> addTopping());
        buttonDeliver.addActionListener(e -> deliverPizza());
        buttonNoDeliver.addActionListener(e -> pickupPizza());

        setVisible(true);
    }

    private void addTopping() {
        if (numToppings >= MAX_TOPPINGS) {
            JOptionPane.showMessageDialog(this, "You have reached the maximum number of toppings.");
            return;
        }
        String topping = textFieldToppings.getText(); //Close GUI
        if (topping.equalsIgnoreCase(QUIT)) {
            dispose();
            return;
        }
        toppings[numToppings++] = topping;
        textFieldToppings.setText("");
        textAreaOutput.append("Added topping: " + topping + "\n");
    }

    private void deliverPizza() {
        isDelivered = true;
        deliveryAddress = JOptionPane.showInputDialog(this, "Enter delivery address:");
        textAreaOutput.append("Thank you for ordering! Your pizza will be delivered to: " + deliveryAddress + "\n");
        createPizza();
    }

    private void pickupPizza() {
        isDelivered = false;
        name = JOptionPane.showInputDialog(this, "What is your name? (So you can locate your order in the pickup section)");
        textAreaOutput.append("Thank you for ordering, " + name + "!" + " Your pizza will be ready in approximately 15 minutes.\n"); //creativity - prompt user to enter name so that they can identify their pickup order and print
        createPizza();
    }
    private void createPizza() {
        double totalPrice;
        if (isDelivered) {
            DeliveryPizza pizza = new DeliveryPizza(toppings, calculatePrice(), deliveryAddress, numToppings); // Calculate initial price using calculatePrice() method
            pizza.setDeliveryFee();
            totalPrice = pizza.getPrice();
            displayPizza(pizza, totalPrice);
        } else {
            Pizza pizza = new Pizza(toppings, calculatePrice());
            totalPrice = pizza.getPrice(); //
            displayPizza(pizza, totalPrice);
        }
    }

    // Calculate the initial price based on the toppings
    private double calculatePrice() {
        double totalPrice = 14.0; // base price
        int actualNumToppings = 0; //initializing number of toppings to 0
        for (int i = 0; i < MAX_TOPPINGS && toppings[i] != null; i++) {
            actualNumToppings++;
        }
        totalPrice += 2.0 * actualNumToppings; // Add $2 for each topping
        return totalPrice;
    }

    private void displayPizza(Pizza pizza, double totalPrice) {
        textAreaOutput.append("Pizza Details:\n");
        textAreaOutput.append("Toppings: " + pizza.getDescription() + "\n");
        textAreaOutput.append("Price (without delivery fee): $" + pizza.price + "\n");
        textAreaOutput.append("Total Price");
        if (pizza instanceof DeliveryPizza) {
            textAreaOutput.append(" (with delivery fee): $" + totalPrice + "\n");
            textAreaOutput.append("You should probably get a car, don't you think? \n");
        } else {
            textAreaOutput.append(": $" + totalPrice + "\n");
            textAreaOutput.append("Get driving, buddy. \n");
        }
    }

    public static void main(String[] args) {
        new DemoPizzaGUI();
    }
}