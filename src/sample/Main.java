package sample;

import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicReference;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Transition"); // заголовок формы

        // наша панель
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(70);

        // создание квадрата
        Rectangle rectangle = new Rectangle(100,100, Color.RED);
        Rectangle rectangle2 = new Rectangle(100, 100, Color.GREEN);
        rectangle2.setRotate(50.0);
        Rectangle rectangle3 = new Rectangle(100, 100, Color.YELLOW);

        // действия на нжатия мышки
        rectangle.setOnMouseClicked(event -> { // анимация поворота, время / на каком объекте
            RotateTransition rt = new RotateTransition(Duration.seconds(2), rectangle);
            rt.setByAngle(125); // на сколько градусов повернуть
            rt.setCycleCount(3); // сколько раз повторить анимацию?
            rt.play(); // отыгать анимацию
        });

        // расположение на форме
        GridPane.setConstraints(rectangle, 0, 0);
        GridPane.setConstraints(rectangle2, 1, 0);
        GridPane.setConstraints(rectangle3, 2, 0);

        // добавить на панель
        root.getChildren().addAll(rectangle, rectangle2, rectangle3);

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }


    public static void main(String[] args) {
        launch(args);
    }
}