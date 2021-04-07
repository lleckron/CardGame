import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    public List<Cards> buildDeck(){
        List<Cards> deck = new ArrayList<>();
        deck.addAll(Hearts.createHeartsCards());
        deck.addAll(Diamonds.createDiamondsCards());
        deck.addAll(Spades.createSpadesCards());
        deck.addAll(Clubs.createClubsCards());
        return deck;
    }

    public List<Cards> shuffleDeck(List<Cards> originalDeck){
        List<Cards> deck = new ArrayList<>(originalDeck);
        Collections.shuffle(deck, new Random());
        return deck;
    }

    public Cards deal(List<Cards> shuffledDeck) {
        List<Cards> deck = new ArrayList<>(shuffledDeck);
        Random random = new Random();
        return deck.get(random.nextInt(deck.size()));
    }
}
