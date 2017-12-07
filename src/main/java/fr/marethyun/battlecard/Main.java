package fr.marethyun.battlecard;

public class Main {
    public static void main(String... args){

        new Game(new Player(), new Player(), new Player(), new Player(), new Player(), new Player()).start();
    }
}
