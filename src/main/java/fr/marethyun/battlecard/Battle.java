package fr.marethyun.battlecard;

import java.util.*;

@SuppressWarnings("unchecked")
public class Battle {

    private static int instances = 0;

    private int id;

    private List<Card> bank = new ArrayList<>();

    private HashMap<Card, Player> bets = new HashMap<>();

    private List<Player> players;
    private HashMap<Player, Integer> decksTrace = new HashMap<>();

    private Player winner;
    private Battle sub;

    public Battle(List<Player> players) {
        this.players = players;
        Collections.sort(players);
        instances++;
        id = instances;
    }

    public Player fight(){

        List<Card> cards = new ArrayList<>();

        for (Player player : players) {
            try {
                decksTrace.put(player, player.getDeck().size());
                Card card = player.getDeck().removeFirst();
                bets.put(card, player);
                bank.add(card);
            } catch (NoSuchElementException ignored){
                // A player can't fight this round
            }
        }

        cards.addAll(bets.keySet());

        Collections.sort(cards);

        List<Card> duplicates = Game.getDuplicates(cards);

        if (cards.size() == 0){
            // Nobody have cards (random winner)
            int random = new Random().nextInt(players.size() - 1);
            winner = players.get(random);
        } else if (cards.size() < players.size()) {
            // At least one player have a card but not all
        }

        if (winner == null) {
            // If a winner hasn't been set
            if (duplicates.size() == 0 || duplicates.size() == 1) {
                // No duplicate (no sub-battle, the highest card wins)
                winner = bets.get(cards.get(0));
            } else {
                // Duplicate, sub-battle between the two highest cards duplicated
                List<Player> fighters = new ArrayList<>();
                Card highestCard = duplicates.get(0);

                for (Card card : duplicates) {
                    if (card.equals(highestCard)) {
                        fighters.add(bets.get(card));
                    }
                }

                Battle battle = new Battle(fighters);

                winner = battle.fight();

                this.sub = battle;
            }
        }

        for (Card card : bank){
            winner.getDeck().addLast(card);
        }

        Game.registerBattle(this);
        return winner;
    }

    public HashMap<Card, Player> getBets() {
        return bets;
    }

    public Player getWinner() {
        return winner;
    }

    public Battle getSub() {
        return sub;
    }

    public List<Card> getBank() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(bank);
        if (sub != null){
            cards.addAll(sub.getBank());
        }
        return cards;
    }

    public static int getInstances() {
        return instances;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String desc = "Battle with id " + this.id + "\n";
        desc += "With following fighters and troops: \n";

        for (Map.Entry<Card, Player> entry : this.bets.entrySet()){
            desc += "- " + entry.getValue() + " (" + decksTrace.get(entry.getValue()) + " cards) -> " + entry.getKey() + "\n";
        }

        if (sub != null){
            desc += "With sub-battle with id " + sub.getId() + "\n";
        }
        desc += "Winner: " + this.winner + "\n";
        desc += "Which won: \n";

        for (Card card : bank){
            desc += "- " + card + "\n";
        }

        return desc;
    }
}
