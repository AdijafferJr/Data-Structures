public class Pizza {
    String[] toppings = new String[10];
    double price;

    public Pizza(String[] toppings, double price) {
        int numToppings = 0;
        for (int i = 0; i < toppings.length && i < this.toppings.length; i++) {
            if (toppings[i] != null) {
                this.toppings[numToppings++] = toppings[i];
            }
        }
        this.price = 14.0 + (2.0 * numToppings);
    }

    public String getDescription() {
        String description = "";

        for (int i = 0; i < toppings.length && toppings[i] != null; i++) {
            description += toppings[i];
            if (i < toppings.length - 1 && toppings[i + 1] != null) {
                description += ", ";
            }
        }

        return description;

    }
    public String toString() {
        return getDescription();
    }
    public double getPrice() {
        return price;
    }

    }
