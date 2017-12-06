package fr.marethyun.battlecard;

import java.util.*;

/**
 * @author Marethyun
 *
 * The main class of the card game, we assume that we play with a 54-card game with jokers
 * The game can be played with a maximum of 4 players
 */
public class Game {

    public static final int CARDS_NUMBER = 54;

    private List<Player> players;

    public Game(Player... players) {
        this.players = Arrays.asList(players);
    }

    public void start(){
        ArrayDeque<Card> pick = newPick();

        dispatch(pick, (Player[]) players.toArray());

        new Bet(players).bet();
    }

    private void dispatch(ArrayDeque<Card> pick, Player... players){
        if (players.length > 0) {
            int cardsPerDeck = CARDS_NUMBER / players.length;
            int left = CARDS_NUMBER % players.length;

            for (Player player : players) {
                for (int i = 0; i < cardsPerDeck; i++) {
                    player.getDeck().add(pick.remove());
                }
            }

            if (left > 0) {
                players[0].getDeck().add(pick.remove());
                players[0].getDeck().add(pick.remove());
            }
        }
    }

    private ArrayDeque<Card> newPick(){
        List<Card> list = new ArrayList<>();

        for (CardType type : CardType.values()){
            if (type.equals(CardType.JOKER)){
                for (int i = 0; i < 2; i++) {
                    list.add(new Card(type, CardColor.NONE));
                }
            } else {
                for (CardColor color : CardColor.values()) {
                    if (color.equals(CardColor.NONE)) continue;
                    list.add(new Card(type, color));
                }
            }
        }

        Collections.shuffle(list);

        return new ArrayDeque<>(list);
    }

    private Player fight(){
        return null;
    }
}
