import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BuildItem {

    public void buildRoad(User user) {

        if (user.getSources().get(SourceType.BRICK) >= 1 && user.getSources().get(SourceType.WOOD) >= 1) {
            user.getSources().put(SourceType.BRICK, user.getSources().get(SourceType.BRICK) - 1);
            user.getSources().put(SourceType.WOOD, user.getSources().get(SourceType.WOOD) - 1);
        }
    }

    public void buildCity(User user) {
        if (user.getSources().get(SourceType.WHEAT) >= 2 && user.getSources().get(SourceType.ORE) >= 3) {
            user.getSources().put(SourceType.WHEAT, user.getSources().get(SourceType.WHEAT) - 2);
            user.getSources().put(SourceType.ORE, user.getSources().get(SourceType.ORE) - 3);
        }
    }

    public void buildSettlement(User user) {
        if (user.getSources().get(SourceType.BRICK) >= 1 && user.getSources().get(SourceType.WOOD) >= 1 && user.getSources().get(SourceType.WHEAT) >= 1 && user.getSources().get(SourceType.SHEEP) >= 1) {
            user.getSources().put(SourceType.BRICK, user.getSources().get(SourceType.BRICK) - 1);
            user.getSources().put(SourceType.WOOD, user.getSources().get(SourceType.WOOD) - 1);
            user.getSources().put(SourceType.SHEEP, user.getSources().get(SourceType.SHEEP) - 1);
            user.getSources().put(SourceType.WHEAT, user.getSources().get(SourceType.WHEAT) - 1);
        }
    }

    public void buildSelfdevelopment(User user) {
        if (user.getSources().get(SourceType.WHEAT) >= 1 && user.getSources().get(SourceType.SHEEP) >= 1 && user.getSources().get(SourceType.ORE) >= 1) {
            user.getSources().put(SourceType.SHEEP, user.getSources().get(SourceType.SHEEP) - 1);
            user.getSources().put(SourceType.ORE, user.getSources().get(SourceType.ORE) - 1);
            user.getSources().put(SourceType.WHEAT, user.getSources().get(SourceType.WHEAT) - 1);
        }
    }
}