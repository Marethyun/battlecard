package fr.marethyun.battlecard;

import java.util.ArrayDeque;

public class Player {

    private static int instances = 0;

    private int number;

    private ArrayDeque<Card> deck;

    public Player(ArrayDeque<Card> deck) {
        instances++;
        this.deck = deck;
        number = instances;
    }

    public Player() {
        this(new ArrayDeque<>());
    }

    public ArrayDeque<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayDeque<Card> deck) {
        this.deck = deck;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "The player " + number;
    }
}
