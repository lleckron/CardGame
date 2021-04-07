import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GUI extends Application {
    private final Button newGameButton = new Button("New Game");
    private final Button dealButton = new Button("Deal");
    private final Button hitButton = new Button("Hit");
    private final Button stayButton = new Button("Stay");
    private final Label playerCardOneInfo = new Label();
    private final Label playerCardTwoInfo = new Label();
    private final Label playerCardThreeInfo = new Label();
    private final Label playerCardsTotal = new Label();
    private final Label dealerCardOneInfo = new Label();
    private final Label dealerCardTwoInfo = new Label();
    private final Label dealerCardThreeInfo = new Label();
    private final Label dealerCardsTotal = new Label();
    private final Label gameEnd = new Label();

    private final Deck deck = new Deck();
    private List<Cards> gameDeck = new ArrayList<>();
    private Cards dealtCard;
    private int playerCardOneValue;
    private int playerCardTwoValue;
    private int playerCardThreeValue;
    private int playerTotalCardsValue;
    private int dealerCardOneValue;
    private int dealerCardTwoValue;
    private int dealerCardThreeValue;
    private int dealerTotalCardsValue;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(blackjackTable());
        scene.getStylesheets().add("styles.css");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("Blackjack!");
        primaryStage.show();
    }

    private HBox blackjackTable() {
        HBox gameBox = new HBox();
        VBox buttonBox = new VBox();
        VBox playerCardInfoBox = new VBox();
        VBox dealerCardInfoBox = new VBox();
        gameBox.setAlignment(Pos.CENTER);
        playerCardInfoBox.setMinWidth(250);
        playerCardInfoBox.setMinHeight(500);
        playerCardInfoBox.setAlignment(Pos.CENTER_LEFT);
        dealerCardInfoBox.setMinHeight(500);
        dealerCardInfoBox.setMinWidth(250);
        dealerCardInfoBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        gameBox.getChildren().add(buttonBox);
        buttonBox.getChildren().add(newGameButton);
        newGameButton.setOnMouseClicked(event -> {
            gameDeck = newGame();
            buttonBox.getChildren().remove(newGameButton);
            buttonBox.getChildren().remove(dealButton);
            gameBox.getChildren().remove(playerCardInfoBox);
            gameBox.getChildren().remove(dealerCardInfoBox);
            playerCardInfoBox.getChildren().remove(playerCardOneInfo);
            playerCardInfoBox.getChildren().remove(playerCardTwoInfo);
            playerCardInfoBox.getChildren().remove(playerCardThreeInfo);
            playerCardInfoBox.getChildren().remove(playerCardsTotal);
            playerCardInfoBox.getChildren().remove(gameEnd);
            dealerCardInfoBox.getChildren().remove(dealerCardOneInfo);
            dealerCardInfoBox.getChildren().remove(dealerCardTwoInfo);
            dealerCardInfoBox.getChildren().remove(dealerCardThreeInfo);
            dealerCardInfoBox.getChildren().remove(dealerCardsTotal);
            buttonBox.getChildren().add(dealButton);
        });
        dealButton.setOnMouseClicked(event -> {
            buttonBox.getChildren().remove(dealButton);
            gameBox.getChildren().add(playerCardInfoBox);
            gameBox.getChildren().add(dealerCardInfoBox);
            playerCardInfoBox.getChildren().add(playerCardOneInfo);
            playerCardInfoBox.getChildren().add(playerCardTwoInfo);
            dealerCardInfoBox.getChildren().add(dealerCardOneInfo);
            dealerCardInfoBox.getChildren().add(dealerCardTwoInfo);
            dealtCard = deck.deal(gameDeck);
            gameDeck.remove(dealtCard);
            playerCardOneValue = dealtCard.cardValue;
            playerCardOneInfo.setText("Player Card One: " + dealtCard.cardName + " of " + dealtCard.suit);
            dealtCard = deck.deal(gameDeck);
            gameDeck.remove(dealtCard);
            dealerCardOneValue = dealtCard.cardValue;
            dealerCardOneInfo.setText("Dealer Card One: " + dealtCard.cardName + " of " + dealtCard.suit);
            dealtCard = deck.deal(gameDeck);
            gameDeck.remove(dealtCard);
            playerCardTwoValue = dealtCard.cardValue;
            playerCardTwoInfo.setText("\nPlayer Card Two: " + dealtCard.cardName + " of " + dealtCard.suit);
            dealtCard = deck.deal(gameDeck);
            gameDeck.remove(dealtCard);
            dealerCardTwoValue = dealtCard.cardValue;
            dealerCardTwoInfo.setText("\nDealer Card Two: " + dealtCard.cardName + " of " + dealtCard.suit);
            playerDealtCardsValue();
            dealerDealtCardsValue();
            playerCardInfoBox.getChildren().add(playerCardsTotal);
            dealerCardInfoBox.getChildren().add(dealerCardsTotal);
            playerCardsTotal.setText("\nPlayer Total: " + playerTotalCardsValue);
            dealerCardsTotal.setText("\nDealer Total: " + dealerTotalCardsValue);
            buttonBox.getChildren().add(hitButton);
            buttonBox.getChildren().add(stayButton);
        });
        hitButton.setOnMouseClicked(event -> {
            buttonBox.getChildren().remove(hitButton);
            buttonBox.getChildren().remove(stayButton);
            playerCardInfoBox.getChildren().remove(playerCardsTotal);
            playerCardInfoBox.getChildren().add(playerCardThreeInfo);
            dealtCard = deck.deal(gameDeck);
            gameDeck.remove(dealtCard);
            playerCardThreeValue = dealtCard.cardValue;
            playerCardThreeInfo.setText("\nPlayer Card Three: " + dealtCard.cardName + " of " + dealtCard.suit);
            playerDealtCardsValue();
            playerCardInfoBox.getChildren().add(playerCardsTotal);
            playerCardsTotal.setText("\nPlayer Total: " + playerTotalCardsValue);
            if (dealerTotalCardsValue < 17) {
                dealerCardInfoBox.getChildren().remove(dealerCardsTotal);
                dealerCardInfoBox.getChildren().add(dealerCardThreeInfo);
                dealtCard = deck.deal(gameDeck);
                gameDeck.remove(dealtCard);
                dealerCardThreeValue = dealtCard.cardValue;
                dealerCardThreeInfo.setText("\nDealer Card Three: " + dealtCard.cardName + " of " + dealtCard.suit);
                dealerDealtCardsValue();
                dealerCardInfoBox.getChildren().add(dealerCardsTotal);
                dealerCardsTotal.setText("\nDealer Total: " + dealerTotalCardsValue);
            }
            playerCardInfoBox.getChildren().add(gameEnd);
            gameEnd.setText(gameOutcome());
            buttonBox.getChildren().remove(hitButton);
            buttonBox.getChildren().remove(stayButton);
            buttonBox.getChildren().add(newGameButton);
        });
        stayButton.setOnMouseClicked(event -> {
            playerCardInfoBox.getChildren().remove(hitButton);
            playerCardInfoBox.getChildren().remove(stayButton);
            if (dealerTotalCardsValue < 17) {
                dealerCardInfoBox.getChildren().remove(dealerCardsTotal);
                dealerCardInfoBox.getChildren().add(dealerCardThreeInfo);
                dealtCard = deck.deal(gameDeck);
                gameDeck.remove(dealtCard);
                dealerCardThreeValue = dealtCard.cardValue;
                dealerCardThreeInfo.setText("\nDealer Card Three: " + dealtCard.cardName + " of " + dealtCard.suit);
                dealerDealtCardsValue();
                dealerCardInfoBox.getChildren().add(dealerCardsTotal);
                dealerCardsTotal.setText("\nDealer Total: " + dealerTotalCardsValue);
            }
            playerCardInfoBox.getChildren().add(gameEnd);
            gameEnd.setText(gameOutcome());
            buttonBox.getChildren().remove(hitButton);
            buttonBox.getChildren().remove(stayButton);
            buttonBox.getChildren().add(newGameButton);
            });
        gameBox.setSpacing(15);
        return gameBox;
    }

    private List<Cards> newGame() {
        List<Cards> fullDeck = deck.buildDeck();
        List<Cards> shuffledDeck = deck.shuffleDeck(fullDeck);
        playerCardOneValue = 0;
        playerCardTwoValue = 0;
        playerCardThreeValue = 0;
        dealerCardOneValue = 0;
        dealerCardTwoValue = 0;
        dealerCardThreeValue = 0;
        return shuffledDeck;
    }

    private void playerDealtCardsValue() {
        playerTotalCardsValue = playerCardOneValue + playerCardTwoValue + playerCardThreeValue;
    }

    private void dealerDealtCardsValue() {
        dealerTotalCardsValue = dealerCardOneValue + dealerCardTwoValue + dealerCardThreeValue;
    }

    private String gameOutcome() {
        if (playerTotalCardsValue == 21 && dealerTotalCardsValue != 21) {
            return "\nBLACKJACK! Congratulations! Play again?";
        }
        else if (playerTotalCardsValue == 21 && dealerTotalCardsValue == 21) {
            return "\nDouble Blackjack! It is a tie! Play again?";
        }
        else if ((playerTotalCardsValue < 21) && dealerTotalCardsValue == 21) {
            return "\nThe dealer beat you with a Blackjack! Play again?";
        }
        else if ((playerTotalCardsValue > dealerTotalCardsValue) && (playerTotalCardsValue < 21)) {
            return "\nYou beat the dealer! Play again?";
        }
        else if (playerTotalCardsValue < 21 && dealerTotalCardsValue > 21) {
            return "\nYou beat the dealer! Play again?";
        }
        else if ((playerTotalCardsValue < 21 && dealerTotalCardsValue <= 21) && (playerTotalCardsValue < dealerTotalCardsValue)) {
            return "\nOh no! You lost to the dealer. Play again?";
        }
        else if (playerTotalCardsValue > 21 && dealerTotalCardsValue <= 21) {
            return "\nOh no! You lost to the dealer. Play again?";
        }
        else if ((playerTotalCardsValue == dealerTotalCardsValue) && (playerTotalCardsValue < 21)) {
            return "\nYou tied the dealer! Play again?";
        }
        else {
            return "You and the dealer went bust! Play again?";
        }
    }
}
