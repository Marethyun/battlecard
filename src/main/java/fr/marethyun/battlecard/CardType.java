package fr.marethyun.battlecard;

public enum CardType {

    TWO("Ace", 1),
    THREE("Three", 2),
    FOUR("Four", 3),
    FIVE("Five", 4),
    SIX("Six", 5),
    SEVEN("Seven", 6),
    EIGHT("Eight", 7),
    NINE("Nine", 8),
    TEN("Ten", 9),
    JACK("Jack", 10),
    QUEEN("Queen", 11),
    KING("King", 12),
    ACE("Ace", 13),
    JOKER("Joker", 14);

    private String name;
    private int weight;

    CardType(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
