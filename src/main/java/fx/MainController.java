package fx;

import com.prettybyte.hexagons.Hexagon;
import com.prettybyte.hexagons.HexagonMap;
import com.sun.javafx.geom.Area;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import jdk.internal.module.Resources;

import java.net.URL;

public class MainController {

    public Group group;

    @FXML
    public void initialize() {
        HexagonMap map = new HexagonMap(50);
        Hexagon hexagon1 = new Hexagon(2, 1);
        Hexagon hexagon2 = new Hexagon(3, 1);
        Hexagon hexagon3 = new Hexagon(4, 1);

        Hexagon hexagon4 = new Hexagon(1, 2);
        Hexagon hexagon5 = new Hexagon(2, 2);
        Hexagon hexagon6 = new Hexagon(3, 2);
        Hexagon hexagon7 = new Hexagon(4, 2);

        Hexagon hexagon8 = new Hexagon(0, 3);
        Hexagon hexagon9 = new Hexagon(1, 3);
        Hexagon hexagon10 = new Hexagon(2, 3);
        Hexagon hexagon11 = new Hexagon(3, 3);
        Hexagon hexagon12 = new Hexagon(4, 3);

        Hexagon hexagon13 = new Hexagon(0, 4);
        Hexagon hexagon14 = new Hexagon(1, 4);
        Hexagon hexagon15 = new Hexagon(2, 4);
        Hexagon hexagon16 = new Hexagon(3, 4);

        Hexagon hexagon17 = new Hexagon(0, 5);
        Hexagon hexagon18 = new Hexagon(1, 5);
        Hexagon hexagon19 = new Hexagon(2, 5);

        Image imageWood = new Image("wood.png");
        Image imageBrick = new Image("brick.png");
        Image imageSheep = new Image("sheep.png");
        Image imageWheat = new Image("wheat.png");
        Image imageOre = new Image("ore.png");
        Image imageDesert = new Image("desert.png");

        Circle circle = new Circle( 100,100,50);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));

        Rectangle rectangle = new Rectangle( 0,0,100,100);
        rectangle.relocate(200, 200);
        rectangle.setStroke(Color.GREEN);
        rectangle.setFill(Color.GREEN.deriveColor(1, 1, 1, 0.3));

        Text text = new Text( "Example Text");
        text.relocate(300, 300);
        ImagePattern imagePatternWood = new ImagePattern(imageWood);
        hexagon1.setFill(imagePatternWood);
        ImagePattern imagePatternBrick = new ImagePattern(imageBrick);
        hexagon2.setFill(imagePatternBrick);
        ImagePattern imagePatternSheep = new ImagePattern(imageSheep);
        hexagon3.setFill(imagePatternSheep);
        ImagePattern imagePatternWheat = new ImagePattern(imageWheat);
        hexagon4.setFill(imagePatternWheat);
        ImagePattern imagePatternOre = new ImagePattern(imageOre);
        hexagon5.setFill(imagePatternOre);
        ImagePattern imagePatternDesert = new ImagePattern(imageDesert);
        hexagon6.setFill(imagePatternWood);
        hexagon7.setFill(imagePatternWheat);
        hexagon8.setFill(imagePatternBrick);
        hexagon9.setFill(imagePatternSheep);
        hexagon10.setFill(imagePatternDesert);
        hexagon11.setFill(imagePatternOre);
        hexagon12.setFill(imagePatternWheat);
        hexagon13.setFill(imagePatternWood);
        hexagon14.setFill(imagePatternSheep);
        hexagon15.setFill(imagePatternBrick);
        hexagon16.setFill(imagePatternSheep);
        hexagon17.setFill(imagePatternOre);
        hexagon18.setFill(imagePatternWood);
        hexagon19.setFill(imagePatternWheat);

        //Circle circle = new Circle(150.0f, 150.0f, 80.f);
        hexagon1.intersects(circle.getLayoutBounds());






        hexagon1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(hexagon1.getLayoutX());
                System.out.println(event);
            }
        });
        map.addHexagon(hexagon1);
        map.addHexagon(hexagon2);
        map.addHexagon(hexagon3);
        map.addHexagon(hexagon4);
        map.addHexagon(hexagon5);
        map.addHexagon(hexagon6);
        map.addHexagon(hexagon7);
        map.addHexagon(hexagon8);
        map.addHexagon(hexagon9);
        map.addHexagon(hexagon10);
        map.addHexagon(hexagon11);
        map.addHexagon(hexagon12);
        map.addHexagon(hexagon13);
        map.addHexagon(hexagon14);
        map.addHexagon(hexagon15);
        map.addHexagon(hexagon16);
        map.addHexagon(hexagon17);
        map.addHexagon(hexagon18);
        map.addHexagon(hexagon19);
        map.render(group);

        //  Hexagon start = map.getHexagon(-21, 74);               // Try some pathfinding
//        Hexagon destination = map.getHexagon(-27, 67);
//        for (Hexagon hexagon1 : start.getPathTo(destination)) {
//            hexagon1.setBackgroundColor(Color.RED);
//        }


    }

    public void onClick(ActionEvent actionEvent) {

    }
}
