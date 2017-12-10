package fr.marethyun.battlecard;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) throws InterruptedException {

        int players = 2;
        int picks = 1;

        if (args.length >= 2) {
            try {
                players = Integer.parseInt(args[0]);
                picks = Integer.parseInt(args[1]);
            } catch (NumberFormatException e){
                System.out.println("The 'players' and 'picks' parameters must be numbers");
                return;
            }
        }

        List<Player> playerList = new ArrayList<>();

        System.out.println(Arrays.toString(args));

        for (int i = 0; i < players; i++) {
            playerList.add(new Player());
        }
        try {
            Game game = new Game(picks, playerList);
            game.start();

            if (args.length == 3) {
                String fileName = args[2];

                List<Battle> battles = game.getHistory();

                File file = new File(fileName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));

                String gameDesc = "Battle with " + players + " players, " + picks + " pick(s) (" + picks * 54 + " cards) and " + battles.size() + " fights\n\n";

                for (char c : gameDesc.toCharArray()){
                    stream.write(c);
                }

                for (Battle battle : battles){
                    String description = battle.toString();

                    for (char c : description.toCharArray()){
                        stream.write(c);
                    }

                    String separator = "\n----------\n\n";

                    for (char c : separator.toCharArray()){
                        stream.write(c);
                    }
                }

                String winner = "\n" + game.getWinner() + " won !";

                for (char c : winner.toCharArray()){
                    stream.write(c);
                }

                stream.close();
            }
        } catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
