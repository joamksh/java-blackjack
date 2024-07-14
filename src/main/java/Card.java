class Card {
    String suit;
    String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        if ("K".equals(value) || "Q".equals(value) || "J".equals(value)) {
            return 10;
        }
        if ("A".equals(value)) {
            return 11;
        }
        return Integer.parseInt(value);
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }
}
