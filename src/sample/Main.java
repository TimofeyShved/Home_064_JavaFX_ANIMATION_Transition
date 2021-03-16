package sample;

import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
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

        // создание квадратов
        Rectangle rectangle = new Rectangle(100,100, Color.RED);

        Rectangle rectangle2 = new Rectangle(100, 100, Color.GREEN);
        rectangle2.setRotate(50.0); // повернуть боком (ромб)
        rectangle2.setX(100);
        rectangle2.setY(100);

        Rectangle rectangle3 = new Rectangle(100, 100, Color.YELLOW);
        rectangle3.setX(100);
        rectangle3.setY(100);
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setStrokeWidth(3);

        //-------------------------------------------- RotateTransition -----------
        // действия на нжатия мышки
        rectangle.setOnMouseClicked(event -> { // анимация поворота, время / на каком объекте
            RotateTransition rt = new RotateTransition(Duration.seconds(2), rectangle);
            rt.setByAngle(180); // на сколько градусов повернуть
            rt.setCycleCount(3); // сколько раз повторить анимацию?
            rt.play(); // отыгать анимацию
        });

        //-------------------------------------------- ScaleTransition -----------
        // действия при наведении мышки
        rectangle2.setOnMouseEntered(event -> { // анимация увеличения объекта, время / на каком объекте
            ScaleTransition st = new ScaleTransition(Duration.seconds(1), rectangle2);
            st.setToX(2); // до каких размеров изменять х2
            st.setToY(2);
            st.play(); // отыгать анимацию
        });

        // действия при отведении мышки
        rectangle2.setOnMouseExited(event -> { // анимация увеличения объекта, время / на каком объекте
            ScaleTransition st = new ScaleTransition(Duration.seconds(1), rectangle2);
            st.setFromX(2.5); // от каких размеров изменять х2.5
            st.setFromY(2.5);
            st.setToX(1); // до каких размеров изменять х1
            st.setToY(1);
            st.play(); // отыгать анимацию
        });

        //-------------------------------------------- StrokeTransition and FillTransition -----------
        // действия при наведении мышки
        rectangle3.setOnMouseEntered(event -> {

            // анимация изменения границы объекта, время / на каком объекте
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rectangle3);
            st.setFromValue(Color.BLUE);
            st.setToValue(Color.RED);
            st.play(); // отыгать анимацию

            // анимация изменения цвета объекта, время / на каком объекте
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle3);
            ft.setFromValue(Color.YELLOW);
            ft.setToValue(Color.BLUE);
            ft.play(); // отыгать анимацию
        });

        // действия при отведении мышки
        rectangle3.setOnMouseExited(event -> {

            // анимация изменения границы объекта, время / на каком объекте
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rectangle3);
            st.setFromValue(Color.RED);
            st.setToValue(Color.BLUE);
            st.play(); // отыгать анимацию

            // анимация изменения цвета объекта, время / на каком объекте
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle3);
            ft.setFromValue(Color.BLUE);
            ft.setToValue(Color.YELLOW);
            ft.play(); // отыгать анимацию
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