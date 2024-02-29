import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TestWeddingGUI extends JFrame implements ActionListener {
    //sets up all additions to GUI
    JTextField brideFirstName;
    JTextField brideLastName;
    JTextField groomFirstName;
    JTextField groomLastName;
    JTextField weddingDate;
    JTextField weddingLocation;
    JButton createWedding;
    JLabel brideLabel;
    JLabel groomLabel;
    JLabel dateLabel;
    JLabel locationLabel;
    JLabel weddingDetails;
    JRadioButton optionYes;
    JRadioButton optionNo;

    public TestWeddingGUI() {
        //sets up GUI
        setLayout(new FlowLayout());
        setSize(getMaximumSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.BLACK);//sets background color

        //creates the title
        JLabel title = new JLabel("Wedding!!!");
        title.setFont(new Font("Courier New", Font.BOLD, 30));
        title.setForeground(Color.yellow);
        add(title);

        //creates label asking for name of groom
        groomLabel = new JLabel("Enter Groom's Name: ");
        groomLabel.setFont(new Font("Courier New", Font.BOLD, 10));
        groomLabel.setForeground(Color.white);
        add(groomLabel); //adds label

        //text field to get user input
        groomFirstName = new JTextField("                           ");
        add(groomFirstName);

        groomLastName = new JTextField("                            ");
        add(groomLastName);

        //creates label asking for bride's name
        brideLabel = new JLabel("Enter Bride's Name: ");
        brideLabel.setFont(new Font("Courier New", Font.BOLD, 10));
        brideLabel.setForeground(Color.white);
        add(brideLabel); //adds label

        //text field to get user input
        brideFirstName = new JTextField("                           ");
        add(brideFirstName);

        brideLastName = new JTextField("                             ");
        add(brideLastName);

        //creates label asking for date of wedding
        dateLabel = new JLabel("Enter Wedding Date YYYY-MM-DD: ");
        dateLabel.setFont(new Font("Courier New", Font.BOLD, 10));
        dateLabel.setForeground(Color.white);
        add(dateLabel); //adds label

        //text field to get user input
        weddingDate = new JTextField("               ");
        add(weddingDate);

        //creates label asking for wedding location
        locationLabel = new JLabel("Enter Wedding Location: ");
        locationLabel.setFont(new Font("Courier New", Font.BOLD, 10));
        locationLabel.setForeground(Color.white);
        add(locationLabel); //adds label

        //text field to get user input
        weddingLocation = new JTextField("                            ");
        add(weddingLocation);

        //creates label asking if person is bringing a gift
        JLabel giftOptionLabel = new JLabel("Are you bringing a gift?");
        giftOptionLabel.setFont(new Font("Courier New", Font.BOLD, 10));
        giftOptionLabel.setForeground(Color.white);
        add(giftOptionLabel); //adds label

        //creates radio buttons to choose whether person is bringing gift or not
        optionYes = new JRadioButton();
        optionYes.setText("Yes");
        add(optionYes);

        optionNo = new JRadioButton();
        optionNo.setText("No");
        add(optionNo);

        //creates button which will cause print out wedding details
        createWedding = new JButton("Done");
        add(createWedding);
        createWedding.addActionListener(this);


        //creates labels to show wedding details
        weddingDetails = new JLabel();
        weddingDetails.setForeground(Color.pink);
        add(weddingDetails);
    }

    public static void main(String[] args) {
        //creates gui
        TestWeddingGUI example = new TestWeddingGUI();
        example.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //when the button is clicked determines which radio button was selected
        if (e.getSource() == createWedding) {
            if (optionYes.isSelected()) {
                //display if yes was selected
                Person groom = new Person (groomFirstName.getText().strip(), groomLastName.getText().strip());
                Person bride = new Person (brideFirstName.getText().strip(), brideLastName.getText());
                Couple couple = new Couple (bride, groom);
                Wedding wedding = new Wedding(couple, LocalDate.parse(weddingDate.getText().strip()), weddingLocation.getText().strip());
                weddingDetails.setText(" Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName() +
                                       " Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName() +
                                       " Date: " + wedding.getDate() +
                                       " Location: " + wedding.getLocation() +
                                       " You are getting a gift!");
            } else {
                //display if no was selected
                Person groom = new Person (groomFirstName.getText().strip(), groomLastName.getText().strip());
                Person bride = new Person (brideFirstName.getText().strip(), brideLastName.getText());
                Couple couple = new Couple (bride, groom);
                Wedding wedding = new Wedding(couple, LocalDate.parse(weddingDate.getText().strip()), weddingLocation.getText().strip());
                weddingDetails.setText(" Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName() +
                        " Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName() +
                        " Date: " + wedding.getDate() +
                        " Location: " + wedding.getLocation() +
                        " You are not getting a gift :(");
            }
        }
    }
}