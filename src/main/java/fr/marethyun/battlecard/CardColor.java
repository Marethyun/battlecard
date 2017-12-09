package fr.marethyun.battlecard;

public enum CardColor {
    NONE(""),
    SPADE("Spades"),
    HEART("Hearts"),
    DIAMOND("Diamonds"),
    CLUB("Clubs");

    private String name;

    CardColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
