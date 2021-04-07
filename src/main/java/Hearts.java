import java.util.ArrayList;
import java.util.List;

public class Hearts extends Cards {

    public Hearts(String suit, String cardName, int cardValue) {
        super(suit, cardName, cardValue);
    }

    public static List<Hearts> createHeartsCards() {
        List<Hearts> heartsCardsList = new ArrayList<>();
        final Hearts two = new Hearts("Hearts", "2", 2);
        heartsCardsList.add(two);
        final Hearts three = new Hearts("Hearts", "3", 3);
        heartsCardsList.add(three);
        final Hearts four = new Hearts("Hearts", "4", 4);
        heartsCardsList.add(four);
        final Hearts five = new Hearts("Hearts", "5", 5);
        heartsCardsList.add(five);
        final Hearts six = new Hearts("Hearts", "6", 6);
        heartsCardsList.add(six);
        final Hearts seven = new Hearts("Hearts", "7", 7);
        heartsCardsList.add(seven);
        final Hearts eight = new Hearts("Hearts", "8", 8);
        heartsCardsList.add(eight);
        final Hearts nine = new Hearts("Hearts", "9", 9);
        heartsCardsList.add(nine);
        final Hearts ten = new Hearts("Hearts", "10", 10);
        heartsCardsList.add(ten);
        final Hearts jack = new Hearts("Hearts", "Jack", 10);
        heartsCardsList.add(jack);
        final Hearts queen = new Hearts("Hearts", "Queen", 10);
        heartsCardsList.add(queen);
        final Hearts king = new Hearts("Hearts", "King", 10);
        heartsCardsList.add(king);
        final Hearts ace = new Hearts("Hearts", "Ace", 11);
        heartsCardsList.add(ace);

        return heartsCardsList;
    }
}
