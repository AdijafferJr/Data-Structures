import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstNames = {"Aidan", "Brandy", "Cai", "Drake", "Eian", "Frank", "Ginobili", "Hasan", "Isak", "James"};
        int userInput;

        try {
            System.out.println("Choose a number between 1 and 10");
            userInput = sc.nextInt();
            userInput = userInput - 1;
            System.out.println(firstNames[userInput]);
            }
            catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("You must choose a number in between 1 and 10");

            }
        }
    }