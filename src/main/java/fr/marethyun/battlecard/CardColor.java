package fr.marethyun.battlecard;

public enum CardColor {
    NONE(""),
    SPADE("Pique"),
    HEART("Coeur"),
    DIAMOND("Carreau"),
    CLUB("Trèfle");

    private String name;

    CardColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
