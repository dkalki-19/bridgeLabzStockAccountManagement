package deckofcards;

public class Player {
    String name;
    Card[] cards;
    int cardCount;

    public Player(String name) {
        this.name = name;
        cards = new Card[9];
        cardCount = 0;
    }

    public void addCard(Card card) {
        if (cardCount < 9) {
            cards[cardCount++] = card;
        }
    }

    public void sortCardsByRank() {
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getRankValue() > cards[j].getRankValue()) {
                    Card temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    public void printCards() {
        System.out.println(name + "'s cards:");
        for (Card card : cards) {
            System.out.println("  " + card);
        }
        System.out.println();
    }
}

