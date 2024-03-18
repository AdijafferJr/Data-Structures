public class DeliveryPizza extends Pizza {
    public int deliveryFee;
    public String deliveryAddress;

    public DeliveryPizza(String[] toppings, double price, String deliveryAddress, int numToppings) {
        super(toppings, price);
        this.deliveryAddress = deliveryAddress;
        this.deliveryFee = 0;
    }

    public void setDeliveryFee() {
        double totalPrice = getPrice(); // Get the total price of the pizza
        if (totalPrice >= 18) { // Check if the total price is greater than or equal to 18
            deliveryFee = 5; // Set the delivery fee to 5
        } else {
            deliveryFee = 3; // Set the delivery fee to 3
        }
    }

    @Override
    public double getPrice() {
        return super.getPrice() + deliveryFee;
    }
}
