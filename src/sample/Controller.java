package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

//http://cecs.wright.edu/~pmateti/Courses/7140/Lectures/Examples/TicTacToe-JavaFX-UnRedo/TicTacToe.java


public class Controller {

    @FXML
    private GridPane Field;

    @FXML
    private AnchorPane panel;

    @FXML
    private Button reset = new Button("Reset");

    @FXML
    private Button new1 = new Button("New");

    @FXML
    private Button highscore = new Button("Highscore");

    @FXML
    private Label info = new Label();

    @FXML
    private Cell[][] cell =  new Cell[3][3];

    boolean turn = true;
    boolean streakX = false;
    boolean streakO = false;
    boolean streak = true;
    int score = 0;
    ArrayList<Button> buttons = new ArrayList<Button>();



    public void initialize() {
        GridPane pane = new GridPane();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            Button btn = new Button();
            btn.setTranslateX(i * 0);
            btn.setTranslateY(j * 0);
            pane.add(cell[i][j] = new Cell(), j, i);

            btn.setMinSize(180,180);
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (turn){
                        btn.setText("X");
                        turn = !turn;
                    }else{
                        btn.setText("O");
                        turn = !turn;
                    }
                    btn.setMouseTransparent(true);
                }
            });
            panel.getChildren().add(btn);
             Field.add(btn, i, j);
        }
    }

    info.setText("Spieler1: ");
    info.setTranslateX(700);
    info.setTranslateY(150);

    new1.setTranslateX(700);
    new1.setTranslateY(150);
    new1.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
                Stage stage = new Stage();
                stage.setTitle("TicTacToe");
                stage.setScene(new Scene(root, 900, 600));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    panel.getChildren().add(new1);

    reset.setTranslateX(700);
    reset.setTranslateY(200);
    reset.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

        }
    });


    highscore.setTranslateX(700);
    highscore.setTranslateY(300);
    highscore.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Highscore.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Highscore");
            stage.setScene(new Scene(root));
            stage.show();
        }
    });
    panel.getChildren().add(highscore);
}

    public void checkGameOver(){
        boolean gameover = false;

        //Check if X wins
            if(buttons.get(0).getText() == "X" && buttons.get(3).getText() == "X" && buttons.get(6).getText() == "X") {
                info.setText("X wins");
                gameover = true;

                score++;
            }
            if(buttons.get(0).getText() == "X" && buttons.get(1).getText() == "X" && buttons.get(2).getText() == "X"){
                info.setText("X wins");
                gameover = true;

                score++;
            }
        if(buttons.get(0).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(8).getText() == "X") {
            info.setText("X wins");
            gameover = true;

            streakX = true;
            score++;
        }
        else if(buttons.get(2).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(6).getText() == "X"){
            info.setText("X wins");
            gameover = true;

            score++;
        }
        if(buttons.get(1).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(7).getText() == "X") {
            info.setText("X wins");
            gameover = true;

            streakX = true;
            score++;
        }
        if(buttons.get(2).getText() == "X" && buttons.get(5).getText() == "X" && buttons.get(8).getText() == "X") {
            info.setText("X wins");
            gameover = true;

            streakX = true;
            score++;
        }
        if(buttons.get(3).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(5).getText() == "X") {
            info.setText("X wins");
            gameover = true;

            streakX = true;
            score++;
        }
        if(buttons.get(6).getText() == "X" && buttons.get(7).getText() == "X" && buttons.get(8).getText() == "X") {
            info.setText("X wins");
            gameover = true;

            streakX = true;
            score++;
        }


        //Check if O wins

        if(buttons.get(0).getText() == "O" && buttons.get(3).getText() == "O" && buttons.get(6).getText() == "O") {
            info.setText("O wins");
            gameover = true;

            score++;
        }
            if(buttons.get(0).getText() == "O" && buttons.get(1).getText() == "O" && buttons.get(2).getText() == "O"){
            info.setText("O wins");
            gameover = true;

            score++;
        }
        if(buttons.get(0).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(8).getText() == "O") {
            info.setText("O wins");
            gameover = true;

            streakO = true;
            score++;
        }
        else if(buttons.get(2).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(6).getText() == "O"){
            info.setText("O wins");
            gameover = true;

            score++;
        }
        if(buttons.get(1).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(7).getText() == "O") {
            info.setText("O wins");
            gameover = true;

            streakO = true;
            score++;
        }
        if(buttons.get(2).getText() == "O" && buttons.get(5).getText() == "O" && buttons.get(8).getText() == "O") {
            info.setText("O wins");
            gameover = true;

            streakO = true;
            score++;
        }
        if(buttons.get(3).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(5).getText() == "O") {
            info.setText("O wins");
            gameover = true;

            streakO = true;
            score++;
        }
        if(buttons.get(6).getText() == "O" && buttons.get(7).getText() == "O" && buttons.get(8).getText() == "O") {
            info.setText("O wins");
            gameover = true;

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
            for(Button btn : buttons){
                btn.setDisable(true);
            }
        }
    }
}
