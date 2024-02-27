import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstNames = {"Aidan", "Brandy", "Cai", "Drake", "Eian", "Frank", "Ginobili", "Hasan", "Isak", "James"}; //array containing names
        int userInput;

        try {
            System.out.println("Choose a number between 1 and 10");
            userInput = sc.nextInt();
            userInput = userInput - 1; //allows for proper navigation of array i.e. If the user enters 1, they will get Aidan, 2 Brandy and so on.
            System.out.println(firstNames[userInput]);
            }
            catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("You must choose a number in between 1 and 10"); //print exception message

            }
        }
    }