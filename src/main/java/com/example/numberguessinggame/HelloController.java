package com.example.numberguessinggame;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HelloController {


    private int randomNumber;
    private int numberOfAttempts;

    @FXML
    public GridPane startMenu;

    @FXML
    private Label title;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnExit;

    @FXML
    public GridPane scoreMenu;

    @FXML
    public GridPane gameMenu;

    @FXML
    public Label scoreLabel;
    @FXML
    public Label instructionLabel;

    @FXML
    private Label chanceCounterLabel;
    @FXML
    public Label hintLabel;

    @FXML
    private Label resultLabel;
    @FXML
    private TextField inputField;

    @FXML
    public Button btnCheck;

    @FXML
    public Button btnTryAgain;

    @FXML
    public Button exitButton;


    public void initialize(){
        // Generate random number between 1 -100
        randomNumber = (int) (Math.random() * 100) + 1;
        numberOfAttempts = 10;

        //Display number of chances hint label
        chanceCounterLabel.setText("You have " + numberOfAttempts + " attempts." );
        hintLabel.setText("");
        System.out.println(randomNumber);
    }

    @FXML
    public void onStartButtonClick() { // Handle start button
        startMenu.setVisible(false); // Hide start menu
        gameMenu.setVisible(true);  // Display game menu
    }

    @FXML
    public void onExitButtonClick(){ // Handle exit button
        Platform.exit();    // Exit application
    }

    @FXML
    public void onCheckButtonClick() {
        // Input from the user
        String inputNumber = inputField.getText();

        // Convert input to Integer
        int guess = Integer.parseInt(inputNumber);

        // Check whether the guess in correct or not
        checkGuess(guess);
    }

    @FXML
    public void onTryAgainButtonClick(){ // Handle try again button
        scoreMenu.setVisible(false); // Hide Score menu
        gameMenu.setVisible(true);  // Display Game menu
        inputField.setText("");
        initialize(); // Create new random number and reset chances
    }

    private void checkGuess(int guess) {
        try {
            // Check for user guess whether guess in between range from 1 to 100
            if(guess <= 100 && guess >= 0){ // Execute when user guess in between range from 1 to 100
                if (guess == randomNumber) {
                    scoreMenu.setVisible(true);
                    gameMenu.setVisible(false);
                    scoreLabel.setText("Score : " + numberOfAttempts * 10);
                    resultLabel.setText("Congratulations! You guessed correctly."); // Display result when user guessed correctly
                } else  {
                    numberOfAttempts--;
                    chanceCounterLabel.setText("You have " + numberOfAttempts + " attempts." );
                    if(numberOfAttempts  <= 0){
                        gameMenu.setVisible(false);
                        scoreMenu.setVisible(true);
                        resultLabel.setText("You have run out of chances"); // Display result when user guessed wrongly
                    }
                }

                // Display hint when user guess is higher or lower
                if (guess < randomNumber){
                    hintLabel.setText("Try a higher number.");
                } else{
                    hintLabel.setText("Try a lower number.");
                }
            }
            else{  // Execute when user guess is out of range
                hintLabel.setText("Enter the number between the range.");
            }
        } catch (NumberFormatException e) {
            hintLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

}