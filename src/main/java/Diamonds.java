import java.util.ArrayList;
import java.util.List;

public class Diamonds extends Cards {

    public Diamonds(String suit, String cardName, int cardValue) {
        super(suit, cardName, cardValue);
    }
    public static List<Diamonds> createDiamondsCards() {
        List<Diamonds> diamondsCardsList = new ArrayList<>();
        Diamonds two = new Diamonds("Diamonds", "2", 2);
        diamondsCardsList.add(two);
        Diamonds three = new Diamonds("Diamonds", "3", 3);
        diamondsCardsList.add(three);
        Diamonds four = new Diamonds("Diamonds", "4", 4);
        diamondsCardsList.add(four);
        Diamonds five = new Diamonds("Diamonds", "5", 5);
        diamondsCardsList.add(five);
        Diamonds six = new Diamonds("Diamonds", "6", 6);
        diamondsCardsList.add(six);
        Diamonds seven = new Diamonds("Diamonds", "7", 7);
        diamondsCardsList.add(seven);
        Diamonds eight = new Diamonds("Diamonds", "8", 8);
        diamondsCardsList.add(eight);
        Diamonds nine = new Diamonds("Diamonds", "9", 9);
        diamondsCardsList.add(nine);
        Diamonds ten = new Diamonds("Diamonds", "10", 10);
        diamondsCardsList.add(ten);
        Diamonds jack = new Diamonds("Diamonds", "Jack", 10);
        diamondsCardsList.add(jack);
        Diamonds queen = new Diamonds("Diamonds", "Queen", 10);
        diamondsCardsList.add(queen);
        Diamonds king = new Diamonds("Diamonds", "King", 10);
        diamondsCardsList.add(king);
        Diamonds ace = new Diamonds("Diamonds", "Ace", 11);
        diamondsCardsList.add(ace);

        return diamondsCardsList;
    }
}
