import java.time.LocalDate;
public class Wedding {
    private Couple couple;
    private LocalDate date;
    private String location;

    public Wedding(Couple couple, LocalDate date, String location) {
        this.couple = couple;
        this.date = date;
        this.location = location;
    }
    public Couple getCouple() {
        return couple;
    }
    public LocalDate getDate() {return date;}
    public String getLocation() {
        return location;
    }

}
