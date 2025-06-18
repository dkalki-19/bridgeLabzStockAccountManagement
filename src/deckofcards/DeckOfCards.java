package deckofcards;

import java.util.Random;

public class DeckOfCards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                                           "Jack", "Queen", "King", "Ace"};

    private String[] deck = new String[52];
    private String[][] playerCards = new String[4][9];

    public DeckOfCards() {
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + rand.nextInt(deck.length - i);  // Swap with a random index
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public void distributeCards() {
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {        // 4 players
            for (int j = 0; j < 9; j++) {    // 9 cards each
                playerCards[i][j] = deck[cardIndex++];
            }
        }
    }

    public void printPlayerCards() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (int j = 0; j < 9; j++) {
                System.out.println("  " + playerCards[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DeckOfCards game = new DeckOfCards();

        System.out.println("Shuffling cards...");
        game.shuffle();

        System.out.println("Distributing cards to players...\n");
        game.distributeCards();

        game.printPlayerCards();
    }
}

