package fr.marethyun.battlecard;

public enum CardType {

    TWO("Deux", 1),
    THREE("Trois", 2),
    FOUR("Quatre", 3),
    FIVE("Cinq", 4),
    SIX("Six", 5),
    SEVEN("Sept", 6),
    EIGHT("Huit", 7),
    NINE("Neuf", 8),
    TEN("Dix", 9),
    JACK("Valet", 10),
    QUEEN("Reine", 11),
    KING("Roi", 12),
    ACE("As", 13),
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
