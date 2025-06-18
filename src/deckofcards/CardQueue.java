package deckofcards;

class Node {
    Player player;
    Node next;

    public Node(Player player) {
        this.player = player;
        this.next = null;
    }
}

public class CardQueue {
    Node front, rear;

    public CardQueue() {
        front = rear = null;
    }

    public void enqueue(Player player) {
        Node newNode = new Node(player);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Player dequeue() {
        if (front == null) return null;
        Player player = front.player;
        front = front.next;
        if (front == null) rear = null;
        return player;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

