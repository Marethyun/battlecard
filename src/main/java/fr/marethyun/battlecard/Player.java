package fr.marethyun.battlecard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Comparable{

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

    public void shuffleDeck(){
        List<Card> cards = new ArrayList<>(this.deck);
        Collections.shuffle(cards);
        this.deck = new ArrayDeque<>(cards);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Player " + this.number;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return Integer.compare(player.getNumber(), this.getNumber());
    }
}
