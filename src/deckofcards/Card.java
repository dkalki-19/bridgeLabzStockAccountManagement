package deckofcards;

public class Card {
    String suit;
    String rank;

    public Card(String rank, String suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRankValue() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                          "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(this.rank)) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

