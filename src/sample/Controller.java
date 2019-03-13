package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {

    @FXML
    private GridPane Field;

    @FXML
    private AnchorPane panel;

    @FXML
    private Button reset = new Button("Reset");

    @FXML
    private Button highscore = new Button("Highscore");

    @FXML
    private Label info = new Label();



    boolean turn = true;
    boolean streakX = false;
    boolean streakO = false;
    boolean streak = true;
    int score = 0;
    ArrayList<Button> buttons = new ArrayList<Button>();


private void initialize() {


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            Button btn = new Button();
            btn.setTranslateX(i * 200);
            btn.setTranslateY(j * 200);
            btn.setMaxSize(200, 200);
            btn.setMinSize(200, 200);
            btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (turn) {
                        btn.setText("X");
                        turn = !turn;
                    } else {
                        btn.setText("O");
                        turn = !turn;
                    }
                    btn.setMouseTransparent(true);
                    checkGameOver();
                }
            });
            panel.getChildren().add(btn);
            //  Field.add();
        }
    }


    reset.setTranslateX(700);
    reset.setTranslateY(200);
    reset.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            for (Button btn : buttons) {
                btn.setText(" ");
            }
        }
    });
    panel.getChildren().add(reset);


    highscore.setTranslateX(700);
    highscore.setTranslateY(300);
    highscore.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Stage stage = new Stage();
            stage.setTitle("Highscore");
            //stage.setScene(new Scene());
            stage.show();
        }
    });
    panel.getChildren().add(highscore);


}


    public void checkGameOver(){
        boolean gameover = false;

        //Check if X wins
        for(int i=0; i<=2;i++){
            if(buttons.get(i).getText() == "X" && buttons.get(i+3).getText() == "X" && buttons.get(i+6).getText() == "X") {
                info.setText("X wins");
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
                info.setText("X wins");
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
            info.setText("X wins");
            gameover = true;
            if(streakO == true){
                streak = false;
                streakO = false;
            }
            streakX = true;
            score++;
        }
        else if(buttons.get(2).getText() == "X" && buttons.get(4).getText() == "X" && buttons.get(6).getText() == "X"){
            info.setText("X wins");
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
                info.setText("O wins");
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
                info.setText("O wins");
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
            info.setText("O wins");
            gameover = true;
            if(streakX == true){
                streak = false;
                streakX = false;
            }
            streakO = true;
            score++;
        }
        else if(buttons.get(2).getText() == "O" && buttons.get(4).getText() == "O" && buttons.get(6).getText() == "O"){
            info.setText("O wins");
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

}
