package fr.marethyun.battlecard;

import java.util.*;

public class Battle {
    private List<Card> bank = new ArrayList<>();

    private HashMap<Card, Player> bets = new HashMap<>();

    private List<Player> players;

    private Player winner;

    public Battle(List<Player> players) {
        this.players = players;
    }

    @SuppressWarnings("unchecked")
    public Player fight(){

        List<Card> cards = new ArrayList<>();

        for (Player player : players) {
            try {
                Card card = player.getDeck().removeFirst();
                bets.put(card, player);
                bank.add(card);
            } catch (NoSuchElementException e){
                System.out.println("The player " + player.getNumber() + " lose !");
            }
        }

        cards.addAll(bets.keySet());

        Collections.sort(cards);

        List<Card> duplicates = Game.getDuplicates(cards);

        System.out.println(duplicates);

        if (duplicates.size() == 0 || duplicates.size() == 1){
            winner = bets.get(cards.get(0));
        } else {
            List<Player> fighters = new ArrayList<>();
            Card highestCard = duplicates.get(0);

            for (Card card : duplicates){
                if (card.equals(highestCard)) {
                    fighters.add(bets.get(card));
                }
            }

            Battle bet = new Battle(fighters);

            winner = bet.fight();
        }

        for (Card card : bank){
            winner.getDeck().addLast(card);
        }

        //winner.getDeck().addAll(bank);
        return winner;
    }

    public HashMap<Card, Player> getBets() {
        return bets;
    }

    public Player getWinner() {
        return winner;
    }

    @Override
    public String toString() {

        // TODO IMPLEMENT ToString with stats (sub-battle ?, winner, bets, bank)

        return super.toString();
    }
}
