package fr.marethyun.battlecard;

import java.util.*;

public class Bet {
    private List<Card> bank = new ArrayList<>();

    private HashMap<Card, Player> bets = new HashMap<>(); // volatile

    private List<Player> players;

    public Bet(List<Player> players) {
        this.players = players;
    }

    @SuppressWarnings("unchecked")
    public void bet(){
        for (Player player : players){
            Card card = player.getDeck().removeFirst();
            bets.put(card, player);
            bank.add(card);
        }

        List<Card> cards = new ArrayList<>();
        cards.addAll(bets.keySet());

        Collections.sort(cards);

        Card previousCard = null;
        for (Card card : cards){
            if (previousCard != null){

            } else {
                previousCard = card;
            }
        }
    }
}
