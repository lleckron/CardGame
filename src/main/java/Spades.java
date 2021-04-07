import java.util.ArrayList;
import java.util.List;

public class Spades extends Cards {

    public Spades(String suit, String cardName, int cardValue) {
        super(suit, cardName, cardValue);
    }
    public static List<Spades> createSpadesCards() {
        List<Spades> spadesCardsList = new ArrayList<>();
        Spades two = new Spades("Spades", "2", 2);
        spadesCardsList.add(two);
        Spades three = new Spades("Spades", "3", 3);
        spadesCardsList.add(three);
        Spades four = new Spades("Spades", "4", 4);
        spadesCardsList.add(four);
        Spades five = new Spades("Spades", "5", 5);
        spadesCardsList.add(five);
        Spades six = new Spades("Spades", "6", 6);
        spadesCardsList.add(six);
        Spades seven = new Spades("Spades", "7", 7);
        spadesCardsList.add(seven);
        Spades eight = new Spades("Spades", "8", 8);
        spadesCardsList.add(eight);
        Spades nine = new Spades("Spades", "9", 9);
        spadesCardsList.add(nine);
        Spades ten = new Spades("Spades", "10", 10);
        spadesCardsList.add(ten);
        Spades jack = new Spades("Spades", "Jack", 10);
        spadesCardsList.add(jack);
        Spades queen = new Spades("Spades", "Queen", 10);
        spadesCardsList.add(queen);
        Spades king = new Spades("Spades", "King", 10);
        spadesCardsList.add(king);
        Spades ace = new Spades("Spades", "Ace", 11);
        spadesCardsList.add(ace);
        return spadesCardsList;
    }
}
