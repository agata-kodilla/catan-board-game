import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int score;
    private int cardAmount;
    private List<Tile> tiles;
    private Map<SourceType,Integer> sources;

    public User() {
        sources = new HashMap<>();
    }

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

    public Map<SourceType, Integer> getSources() {
        return sources;
    }


}
