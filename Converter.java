import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //create variable to show number of coins
        int n_quarters, n_dimes, n_nickels, n_pennies;

        //create variable for user entry
        float amount;

        System.out.println("Welcome to Jonathan's Caribbean Cuisine!");
        System.out.println("What is your budget? Enter amount $ ");
        amount = sc.nextFloat();

        int remainder = (int) (amount * 100);

        //find out number of quarters present
        n_quarters = remainder / 25;
        remainder %= 25;

        //find out number of dimes present
        n_dimes = remainder / 10;
        remainder %= 10;

        // find out the number of nickels present
        n_nickels = remainder / 5;
        remainder %= 5;

        // find out the number of pennies present
        n_pennies = remainder;

        System.out.println("Here is your amount broken down into coins");
        System.out.println("Quarters: " + n_quarters);
        System.out.println("Dimes: " + n_dimes);
        System.out.println("Nickels: " + n_nickels);
        System.out.println("Pennies " + n_pennies);

        //add penny each time amount is divisible by 8 in order to account for errors
        if (amount >= 8 && amount % 8 == 0) {
            n_pennies += 1;
        }

        Map<String, Double> menu = new HashMap<>();
        menu.put("Breakfast Burrito", 5.99);
        menu.put("Chicken Roti", 7.99);
        menu.put("Bake and Shark", 8.99);
        menu.put("Ducana and Saltfish", 6.99);
        menu.put("Pholourie (3)", 3.99);
        menu.put("Goat Roti", 11.99);
        menu.put("Sorrel", 4.99);
        menu.put("Ginger Beer", 4.99);

        System.out.println("Our Full Menu:");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("Here are the items you are able to purchase based on your entered amount:");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            if (entry.getValue() <= amount) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
        }
        sc.close();
    }
}




