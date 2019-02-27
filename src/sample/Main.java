package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {

    ArrayList<Button> buttons = new ArrayList<Button>();
    boolean turn = true;
    boolean streakX = false;
    boolean streakO = false;
    boolean streak = true;
    int score = 0;
    Label lable = new Label();


    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(900, 600);

        Button reset = new Button ("Reset");
        reset.setTranslateX(700);
        reset.setTranslateY(150);

        reset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Button b : buttons){
                    b.setText("");
                    b.setDisable(false);
                    b.setMouseTransparent(false);
                    b.setFocusTraversable(true);
                }
            }
        });

        Button highscore = new Button("Highscore");
        highscore.setTranslateX(700);
        highscore.setTranslateY(300);


        root.getChildren().add(highscore);
        root.getChildren().add(reset);


        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                btn.setTranslateX(i* 200);
                btn.setTranslateY(j * 200);
                btn.setMaxSize(200,200);
                btn.setMinSize(200,200);
                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {


                    @Override
                    public void handle(MouseEvent event) {
                        if(turn){
                            btn.setText("X");
                            turn = ! turn;
                        }else {
                            btn.setText("O");
                            turn=!turn;
                        }
                        btn.setMouseTransparent(true);

                    }
                });
                root.getChildren().add(btn);
            }
        }
        return root;
    }


    public void checkGameOver(){
        boolean gameover = false;

        //Check if X wins
        for(int i=0; i<=2;i++){
            if(buttons.get(i).getText() == "X" && buttons.get(i+3).getText() == "X" && buttons.get(i+6).getText() == "X") {
                lable.setText("X wins");
                gameover = true;
                if(streakO == true){
                    streak = false;
                    streakO = false;
                }
                streakX = true;
                score++;
            }
        }
        for(int i=0;i<=6;i+=3){
            if(buttons.get(i).getText() == "X" && buttons.get(i+1).getText() == "X" && buttons.get(i+2).getText() == "X"){
                lable.setText("X wins");
                gameover = true;
                if(streakO == true){
                    streak = false;
                    streakO = false;
                }
                streakX = true;
                score++;
            }
        }
        if(buttons.get(0).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(8).getText() == "X") {
            lable.setText("X wins");
            gameover = true;
            if(streakO == true){
                streak = false;
                streakO = false;
            }
            streakX = true;
            score++;
        }
        else if(buttons.get(2).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(6).getText() == "X"){
            lable.setText("X wins");
            gameover = true;
            if(streakO == true){
                streak = false;
                streakO = false;
            }
            streakX = true;
            score++;
        }

        //Check if O wins
        for(int i=0; i<=2;i++){
            if(buttons.get(i).getText() == "O" && buttons.get(i+3).getText() == "O" && buttons.get(i+6).getText() == "O") {
                lable.setText("O wins");
                gameover = true;
                if(streakX == true){
                    streak = false;
                    streakX = false;
                }
                streakO = true;
                score++;
            }
        }
        for(int i=0;i<=6;i+=3){
            if(buttons.get(i).getText() == "O" && buttons.get(i+1).getText() == "O" && buttons.get(i+2).getText() == "O"){
                lable.setText("O wins");
                gameover = true;
                if(streakX == true){
                    streak = false;
                    streakX = false;
                }
                streakO = true;
                score++;
            }
        }
        if(buttons.get(0).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(8).getText() == "O") {
            lable.setText("O wins");
            gameover = true;
            if(streakX == true){
                streak = false;
                streakX = false;
            }
            streakO = true;
            score++;
        }
        else if(buttons.get(2).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(6).getText() == "O"){
            lable.setText("O wins");
            gameover = true;
            if(streakX == true){
                streak = false;
                streakX = false;
            }
            streakO = true;
            score++;
        }

        //Check if tie
        int counter = 0;
        for(Button b : buttons){
            if(b.getText() != "") counter++;
            if(counter == 9) gameover = true;
        }

        //Check if game is over
        if(gameover){
            for(Button b : buttons){
                b.setDisable(true);
            }
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}
