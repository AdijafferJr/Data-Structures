import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaStoreGUI {
    // components created using SwingUIDesigner
    private JPanel panel1;
    private JRadioButton radpepperoni;
    private JRadioButton radpineapple;

    private JRadioButton radchicken;
    private JCheckBox chksmall;
    private JCheckBox chkmedium;
    private JCheckBox chklarge;
    private JTextPane texsub;
    private JTextPane textax;
    private JTextPane textot;
    private JCheckBox chksuper;
    private JButton enterButton;
    private JButton clearButton;
    private JButton exitButton;
    private JRadioButton radextracheese;
    private JLabel logo;

    public PizzaStoreGUI() {
        GUIcalculator calculator = new GUIcalculator();
        enterButton.addActionListener(calculator);
        clearButton.addActionListener(calculator);
        exitButton.addActionListener(calculator);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza Store GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PizzaStoreGUI().panel1);

        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // Add Company Logo
        logo = new JLabel(new ImageIcon("bigypizzaguilogo.png"));
        logo.setVisible(true);
    }

    private class GUIcalculator implements ActionListener {
        private double subtotal;
        private double tax;

        private double total;
        @Override
        public void actionPerformed(ActionEvent e) {
            //call calculateSubtotal, calculateTax and calculateTotal if enterButton is clicked
            if (e.getSource() == enterButton) {
                subtotal = calculateSubtotal();
                texsub.setText("$" + String.format("%.2f", subtotal));

                tax = calculateTax();
                textax.setText("$" + String.format("%.2f", tax));

                total = calculateTotal();
                textot.setText("$" + String.format("%.2f", total));

            // call clearselections if clearButton is clicked
            } else if (e.getSource() == clearButton) {

                clearSelections();
            } else if (e.getSource() == exitButton) {
            //close GUI if exitButton is clicked
                System.exit(0);
            }
        }

        public double calculateSubtotal() {
            double subtotal = 0;
            int numtoppings = 0;
            // add to subtotal depending on chosen pizza(s)
            if (chksmall.isSelected()) {
                subtotal += 5;
            } else if (chkmedium.isSelected()) {
                subtotal += 10;
            } else if (chklarge.isSelected()) {
                subtotal += 15;
            } else if (chksuper.isSelected()) {
                subtotal += 20;
            }
            // find out number of chosen toppings(s)
            if (radpepperoni.isSelected()) {
                numtoppings++;
            }
            if (radpineapple.isSelected()) {
                numtoppings++;
            }
            if (radchicken.isSelected()) {
                numtoppings++;
            }
            if (radextracheese.isSelected()) {
                System.out.println("You requested extra cheese");
            }
            // add to subtotal depending on number of chosen topping(s)
            if (numtoppings == 1) {
                subtotal += 0.50;
            } else if (numtoppings == 2) {
                subtotal += 1;
            } else if (numtoppings == 3) {
                subtotal += 1.25;
            }
            return subtotal;
        }

        public void clearSelections() {
            // this function clears the radio buttons, check boxes and text panes
            chksmall.setSelected(false);
            chkmedium.setSelected(false);
            chklarge.setSelected(false);
            chksuper.setSelected(false);
            radpepperoni.setSelected(false);
            radpineapple.setSelected(false);
            radchicken.setSelected(false);
            radextracheese.setSelected(false);

            texsub.setText("");
            textax.setText("");
            textot.setText("");
        }
        public double calculateTax() {
            //this function calculates the tax by adding 15% to the subtotal
            tax = subtotal * 0.15;
            return tax;
        }
        public double calculateTotal() {
            // this function calculates the total by adding the subtotal and the tax
            total = subtotal + tax;
            return total;
        }
    }
}



