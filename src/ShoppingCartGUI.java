import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartGUI extends JFrame implements ActionListener {
    private JLabel title;
    private List<Item> availableItems;
    private List<ItemOrder> cartItems;

    private JTextArea cartTextArea;
    private JLabel totalLabel;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JButton viewCartButton;

    public ShoppingCartGUI() {
        // Initialize available items and cart
        availableItems = new ArrayList<>();
        availableItems.add(new Item("Tissues", 2.75));
        availableItems.add(new Item("Soda", 1.99));
        availableItems.add(new Item("Chips", 1.75));
        availableItems.add(new Item("Peanut Butter", 4.99));
        availableItems.add(new Item("Milk", 3.25));
        availableItems.add(new Item("Gum", 0.99));

        cartItems = new ArrayList<>();

        // Set up GUI
        setTitle("J's Convenience Store");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // User Welcome Title
        title = new JLabel("Welcome To J's Convenience Store!!");
        title.setFont(new Font("Georgia", Font.BOLD, 20));
        title.setForeground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // Total label
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalLabel, BorderLayout.EAST);

        // Display cart contents
        cartTextArea = new JTextArea(10, 30);
        cartTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        cartTextArea.setBackground(Color.LIGHT_GRAY);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Button for adding items
        addItemButton = new JButton("Add Item");
        addItemButton.addActionListener(this);
        buttonPanel.add(addItemButton);

        // Button for removing items
        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(this);
        buttonPanel.add(removeItemButton);

        // Button to view cart
        viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(this);
        buttonPanel.add(viewCartButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI();
        shoppingCartGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            String[] itemNames = availableItems.stream().map(Item::getName).toArray(String[]::new);
            String selectedItemName = (String) JOptionPane.showInputDialog(this, "Select item to add:", "Add Item",
                    JOptionPane.QUESTION_MESSAGE, null, itemNames, itemNames[0]);

            // Add chosen item to cart
            if (selectedItemName != null) {
                Item selectedItem = availableItems.stream().filter(item -> item.getName().equals(selectedItemName)).findFirst().orElse(null);
                if (selectedItem != null) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter quantity:", "Quantity", JOptionPane.QUESTION_MESSAGE));
                    cartItems.add(new ItemOrder(selectedItem, quantity));
                    updateTotalLabel(); // Update total label
                }
            }
        } else if (e.getSource() == removeItemButton) {
            String[] itemNames = cartItems.stream().map(itemOrder -> itemOrder.getItem().getName()).toArray(String[]::new);
            String selectedItemName = (String) JOptionPane.showInputDialog(this, "Select item to remove:", "Remove Item",
                    JOptionPane.QUESTION_MESSAGE, null, itemNames, itemNames[0]);

            // Remove chosen item from cart
            if (selectedItemName != null) {
                cartItems.removeIf(itemOrder -> itemOrder.getItem().getName().equals(selectedItemName));
                updateTotalLabel(); // Update total label
            }
        } else if (e.getSource() == viewCartButton) {
            // Update cart with contents
            cartTextArea.setText("Current Cart:\n");
            for (ItemOrder itemOrder : cartItems) {
                cartTextArea.append(itemOrder.getItem().getName() + " - $" + itemOrder.getItem().getPrice() + " (Quantity: " + itemOrder.getQuantity() + ")\n");
            }
            updateTotalLabel();
        }
    }

    private double calculateTotal() {
        double total = 0.0;
        for (ItemOrder itemOrder : cartItems) {
            total += itemOrder.getTotal();
        }
        return total;
    }
    private void updateTotalLabel() {
        double total = calculateTotal();
        totalLabel.setText("Total: $" + String.format("%.2f", total));
    }


    }
