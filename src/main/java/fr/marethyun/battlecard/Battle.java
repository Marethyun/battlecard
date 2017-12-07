package fr.marethyun.battlecard;

import java.util.*;

public class Battle {
    private List<Card> bank = new ArrayList<>();

    private HashMap<Card, Player> bets = new HashMap<>(); // volatile

    private List<Player> players;

    public Battle(List<Player> players) {
        this.players = players;
    }

    @SuppressWarnings("unchecked")
    public Player fight(){

        Player winner;
        List<Card> cards = new ArrayList<>();

        for (Player player : players) {
            try {
                Card card = player.getDeck().removeFirst();
                bets.put(card, player);
                bank.add(card);
            } catch (NoSuchElementException e){
                e.printStackTrace();
                System.out.println(player.getDeck().size());
            }
        }

        cards.addAll(bets.keySet());

        Collections.sort(cards);

        List<Card> duplicates = Game.getDuplicates(cards);

        if (duplicates.size() == 0){
            winner = bets.get(cards.get(0));
        } else {
            List<Player> fighters = new ArrayList<>();
            for (Card card : duplicates){
                fighters.add(bets.get(card));
            }

            Battle bet = new Battle(fighters);

            winner = bet.fight();
        }

        winner.getDeck().addAll(bank);
        return winner;
    }
}
