import java.time.LocalDate;
import java.util.Scanner;

public class TestWedding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the bride: ");
        String brideFirstName = sc.next();
        String brideLastName = sc.next();
        Person bride = new Person (brideFirstName, brideLastName);

        System.out.println("Enter the name of the groom: ");
        String groomFirstName = sc.next();
        String groomLastName = sc.next();
        Person groom = new Person (groomFirstName, groomLastName);

        Couple couple = new Couple (bride, groom);

        System.out.println("Enter the date of the wedding: YYYY-MM-DD");
        String date = sc.next();
        LocalDate weddingDate = LocalDate.parse(date);

        System.out.println("Enter the location: ");
        String location = sc.next();
        Wedding wedding = new Wedding(couple, weddingDate, location);

        System.out.println("Details:");
        System.out.println("Bride:" + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName());
        System.out.println("Groom:" + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName());
        System.out.println("Date:" + wedding.getDate());
        System.out.println("Location:" + wedding.getLocation());




    }
}