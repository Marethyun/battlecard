package fr.marethyun.battlecard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marethyun
 *
 * The main class of the card game, we assume that we play with a 54-card game with jokers
 * The game can be played with a maximum of 4 players
 */
public class Game {

    public static final int CARDS_NUMBER = 54;
    public static final int SHUFFLE_INDEX = 500;
    public static final int SAVE_INDEX = 1;

    private List<Player> players;
    private Player winner;

    private static List<Battle> history = new ArrayList<>();

    private int picks;
    private int playersNumber;

    public Game(int picks, List<Player> players) {
        this.picks = picks;
        this.players = players;
        this.playersNumber = players.size();

        if (players.size() <= 1 || picks <= 0){
            throw new BattleGameException("You cannot play with less than 2 players and 1 pick !");
        }

        if (players.size() > picks * 54){
            throw new BattleGameException("You cannot play with less than 2 cards per player !");
        }
    }

    public Game(List<Player> players) {
        this(1, players);
    }

    public void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        ArrayDeque<Card> pick = PickFactory.newPick(picks);

        dispatch(pick, players);

        while (players.size() > 1) {

            players = players.stream().filter(player -> player.getDeck().size() > 0).collect(Collectors.toList());

            if (players.size() == 1) break;

            Battle battle = new Battle(players);
            battle.fight();

            System.out.println(battle);
            
            if (Battle.getInstances() % SHUFFLE_INDEX == 0){
                players.forEach(Player::shuffleDeck);
            }

            if (Battle.getInstances() % SAVE_INDEX == 0){
                history.add(battle);
            }

            System.out.println();
        }

        this.winner = players.get(0);
        System.out.println("The player " + winner.getNumber() + " won !");

        double battleTime = (System.currentTimeMillis() - startTime) / 1000.0;

        System.out.println("Took " + Double.toString(battleTime) + "s");
    }

    private void dispatch(ArrayDeque<Card> pick, List<Player> players){
        if (players.size() > 0) {
            int cardsPerDeck = pick.size() / players.size();
            int left = pick.size() % players.size();

            for (Player player : players) {
                for (int i = 0; i < cardsPerDeck; i++) {
                    player.getDeck().add(pick.remove());
                }
            }

            if (left > 0) {
                players.get(0).getDeck().add(pick.remove());
                players.get(0).getDeck().add(pick.remove());
            }
        }
    }

    public static List<Card> getDuplicates(List<Card> cards){
        List<Card> duplicates = new ArrayList<>();

        HashMap<Integer, Card> weights = new HashMap<>();

        for (Card card : cards){
            if (weights.containsKey(card.getType().getWeight())){
                duplicates.add(card);
                duplicates.add(weights.get(card.getType().getWeight()));
            } else {
                weights.put(card.getType().getWeight(), card);
            }
        }
        return duplicates;
    }

    public List<Battle> getHistory() {
        return history;
    }

    public static void registerBattle(Battle battle){
        history.add(battle);
    }

    public Player getWinner() {
        return winner;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }
}
