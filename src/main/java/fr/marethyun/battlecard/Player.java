package fr.marethyun.battlecard;

import java.util.ArrayDeque;

public class Player {
    private ArrayDeque<Card> deck;

    public Player() {
        this.deck = new ArrayDeque<>();
    }

    public Player(ArrayDeque<Card> deck) {
        this.deck = deck;
    }

    public ArrayDeque<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayDeque<Card> deck) {
        this.deck = deck;
    }
}
