package fr.marethyun.battlecard;

public final class Card implements Comparable {
    private CardType type;
    private CardColor color;

    public Card(CardType type, CardColor color) {
        this.type = type;
        this.color = color;
    }

    public CardType getType() {
        return type;
    }

    public CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (color.equals(CardColor.NONE)){
            return type.getName();
        }
        return type.getName() + " de " + color.getName().toLowerCase();
    }


    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        return Integer.compare(card.getType().getWeight(), this.getType().getWeight());
    }
}
