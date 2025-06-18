package deckofcards;

import java.util.Random;

public class DeckOfCardsGame {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                                           "Jack", "Queen", "King", "Ace"};

    private Card[] deck = new Card[52];
    private Player[] players = new Player[4];

    public DeckOfCardsGame() {
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = new Card(rank, suit);
            }
        }

        // Initialize players
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + rand.nextInt(deck.length - i);
            Card temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public void distribute() {
        int cardIndex = 0;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 4; i++) {
                players[i].addCard(deck[cardIndex++]);
            }
        }
    }

    public void runGame() {
        shuffle();
        distribute();

        // Create queue
        CardQueue queue = new CardQueue();

        // Sort and enqueue players
        for (Player player : players) {
            player.sortCardsByRank();
            queue.enqueue(player);
        }

        // Display player cards in queue order
        System.out.println("🃏 Final Sorted Player Hands (in Queue):\n");
        while (!queue.isEmpty()) {
            Player p = queue.dequeue();
            p.printCards();
        }
    }

    public static void main(String[] args) {
        DeckOfCardsGame game = new DeckOfCardsGame();
        game.runGame();
    }
}

