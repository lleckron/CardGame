import java.util.ArrayList;
import java.util.List;

public class Clubs extends Cards {

    public Clubs(String suit, String cardName, int cardValue) {
        super(suit, cardName, cardValue);
    }
    public static List<Clubs> createClubsCards() {
        List<Clubs> clubsCardsList = new ArrayList<>();
        Clubs two = new Clubs("Clubs", "2", 2);
        clubsCardsList.add(two);
        Clubs three = new Clubs("Clubs", "3", 3);
        clubsCardsList.add(three);
        Clubs four = new Clubs("Clubs", "4", 4);
        clubsCardsList.add(four);
        Clubs five = new Clubs("Clubs", "5", 5);
        clubsCardsList.add(five);
        Clubs six = new Clubs("Clubs", "6", 6);
        clubsCardsList.add(six);
        Clubs seven = new Clubs("Clubs", "7", 7);
        clubsCardsList.add(seven);
        Clubs eight = new Clubs("Clubs", "8", 8);
        clubsCardsList.add(eight);
        Clubs nine = new Clubs("Clubs", "9", 9);
        clubsCardsList.add(nine);
        Clubs ten = new Clubs("Clubs", "10", 10);
        clubsCardsList.add(ten);
        Clubs jack = new Clubs("Clubs", "Jack", 10);
        clubsCardsList.add(jack);
        Clubs queen = new Clubs("Clubs", "Queen", 10);
        clubsCardsList.add(queen);
        Clubs king = new Clubs("Clubs", "King", 10);
        clubsCardsList.add(king);
        Clubs ace = new Clubs("Clubs", "Ace", 11);
        clubsCardsList.add(ace);
        return clubsCardsList;
    }
}
