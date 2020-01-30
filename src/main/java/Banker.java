import java.util.Random;

public class Banker {
    private int allCards;
    private int availableCard;
    private int userScore;
    private int playerAmount;
    private int rollDice;

    public Banker() {
        allCards = 95;
    }

    public Integer rollDice() {
        Random random = new Random();
        return  random.nextInt(6) + 1;
    }
}
