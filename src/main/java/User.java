import java.util.List;

public class User {
    private String name;
    private int score;
    private int cardAmount;
    private List<Tile> tiles;
    private List<Card> cards;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<Card> getCards() {
        return cards;
    }
}
