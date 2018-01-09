/*
 * Name: Deepak Kumar Gunturu
 * Course: COP 3330, Fall 2017, MWF: 12:30 PM - 1:20 PM
 * Professor: Neslisah Torosdagli
 * Assignment Description: Bonus Assignment
 * Implementation of Tic Tac Toe using Java FX and Scene Builder
 *
 */
package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author deepakkumargunturu
 */

public class GamePlayController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    // Boolean variable used to determine the first player playing the game
    // The first player playing the game alternates for each turn
    private boolean firstPlayer = false;
    
    // Button for start button. Used to start the game
    @FXML
    private Button StartBtn;
    
    // Button for close button. Used to end the game scene
    @FXML
    private Button CloseBtn;
    
    // Label for the name of the first player
    @FXML
    private Label Name1;
    
    // Label for the name of the second player
    @FXML
    private Label Name2;
    
    // The nine buttons for each panel of the grid pane in which the game is to be played
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button btn5;
    
    @FXML
    private Button btn6;
    
    @FXML
    private Button btn7;
    
    @FXML
    private Button btn8;
    
    @FXML
    private Button btn9;
    
    // This event is triggered when buttons are pressed on the grid while playing the game
    // When the boolean variable firstPlayer is set to false and a button on the grid is pressed, the text set in the button would be "X"
    // The firstPlayer variable is set to true and on the next button click, the grid button displays "O"
    // This method is used to alternate between "X" and "O" and the starting player of each game alter
    @FXML
    private void gameButtonClick(ActionEvent event)
    {
        Button btn = (Button)event.getTarget();
        
        // The string after button click is done is extracted into the buttonText string
        String buttonText = btn.getText();
        
        // When the firstPlayer boolean variable is false, the button click on the grid would set the text to "X" for player one
        if(buttonText == "" && firstPlayer == false)
        {
            // Highlighting the player whose move is being made and the other player's color is reset
            Name2.setTextFill(Color.BLACK);
            Name1.setTextFill(Color.RED);
            
            // Setting button to X
            btn.setText("X");
            
            // The "X" is blue in color with a font of 60
            btn.setTextFill(Color.BLUE);
            btn.setFont(new Font(60));
            
            // Setting the boolean variable to true for the next click
            firstPlayer = true;
        }
        
        // When the firstPlayer boolean variable is true, the button click on the grid would set the text to "O" for player two
        else if(buttonText == "" && firstPlayer == true)
        {
            // Highlighting the player whose move is being made and the other player's color is reset
            Name1.setTextFill(Color.BLACK);
            Name2.setTextFill(Color.RED);
            
            // Setting button to O
            btn.setText("O");
            
            // The "O" is blue in color with a font of 60
            btn.setTextFill(Color.BLUE);
            btn.setFont(new Font(60));
            
             // Setting the boolean variable to false for the next click
            firstPlayer = false;
        }
        
        // If a winner is determined for the game or the game ends in a draw, this case is invoked
        if(PlayerWinsTheGame() || DrawGame())
        {
            String result = WinnerOfTheGame();
            
            ShowResult(result);
            
            // Resetting the color of the name labels to black for the next game
            Name2.setTextFill(Color.BLACK);
            Name1.setTextFill(Color.BLACK);
            
            // Disabling all the buttons on the grid till the next game is played
            disableButtons();
            
        }
 
    }
    
    // This function goes through every possible combination in which the game is won and returns that name of the player winning the game
    private String WinnerOfTheGame()
    {
        // Checking if the first row is the winning row
        if(btn1.getText() != "" && btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText())
        {
            // If winner is player one, return the name
            if(btn1.getText() == "X")
                return Name1.getText();
            
            // If winner is player two, return the name
            else if(btn1.getText() == "O")
                return Name2.getText();
        }
      
        // Checking if the second row is the winning row
        if(btn4.getText() != "" && btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText())
        {
            // If winner is player one, return the name
            if(btn4.getText() == "X")
                return Name1.getText();
            
            // If winner is player two, return the name
            else if(btn4.getText() == "O")
                return Name2.getText();
        }
        
        // Checking if the third row is the winning row
        if(btn7.getText() != "" && btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText())
        {
            // If winner is player one, return the name
            if(btn7.getText() == "X")
                return Name1.getText();
            
            // If winner is player two, return the name
            else if(btn7.getText() == "O")
                return Name2.getText();
        }
        
        // Checking if the first column is the winning column
        if(btn1.getText() != "" && btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText())
        {
            // If winner is player one, return the name
            if(btn1.getText() == "X")
                return "Winner is "+Name1.getText();
            
            // If winner is player two, return the name
            else if(btn1.getText() == "O")
                return "Winner is "+Name2.getText();
        }
        
        // Checking if the second column is the winning column
        if(btn2.getText() != "" && btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText())
        {
            // If winner is player one, return the name
            if(btn2.getText() == "X")
                return "Winner is "+Name1.getText();
            
            // If winner is player two, return the name
            else if(btn2.getText() == "O")
                return "Winner is "+Name2.getText();
        }
        
        // Checking if the third column is the winning column
        if(btn3.getText() != "" && btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText())
        {
            // If winner is player one, return the name
            if(btn3.getText() == "X")
                return "Winner is "+Name1.getText();
            
            // If winner is player two, return the name
            else if(btn3.getText() == "O")
                return "Winner is "+Name2.getText();
        }
        
        // Checking if the diagonal from left to right is the winning diagonal
        if(btn1.getText() != "" && btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText())
        {
            // If winner is player one, return the name
            if(btn1.getText() == "X")
                return "Winner is "+Name1.getText();
            
            // If winner is player two, return the name
            else if(btn1.getText() == "O")
                return "Winner is "+Name2.getText();
        }
        
        // Checking if the diagonal from right to left is the winning diagonal
        if(btn3.getText() != "" && btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText())
        {
           // If winner is player one, return the name
           if(btn3.getText() == "X")
                return "Winner is "+Name1.getText();
            
           // If winner is player two, return the name
            else if(btn3.getText() == "O")
                return "Winner is "+Name2.getText();
        }
        
        // Case for when the game is a tie
        return "THE GAME IS A DRAW";
    }
    
    // This function returns true if the game ends in a draw. If the game is not finished yet, it returns false
    private boolean DrawGame()
    {
        // Checks if all the buttons in the grid have been filled in with either an "X" or "O". Returns true if all buttons are filled in 
        if(btn1.getText() != "" && btn2.getText() != "" && btn3.getText() != "" && btn4.getText() != "" && btn5.getText() != "" && btn6.getText() != "" && btn7.getText() != "" && btn8.getText() != "" && btn9.getText() != "" )
            return true;
     
        // If not all of the buttons in the grid have been filled in, returns false
        return false;
    }
    
    // This function returns true if a player wins the game. Otherwise, it return false
    private boolean PlayerWinsTheGame()
    {
        // Checking if the first row is the winning row
        if(btn1.getText() != "" && btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText())
            return true;
        
        // Checking if the second row is the winning row
        if(btn4.getText() != "" && btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText())
            return true;
        
        // Checking if the third row is the winning row
        if(btn7.getText() != "" && btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText())
            return true;
        
        // Checking if the first column is the winning column
        if(btn1.getText() != "" && btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText())
            return true;
        
        // Checking if the second column is the winning column
        if(btn2.getText() != "" && btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText())
            return true;
        
        // Checking if the third column is the winning column
        if(btn3.getText() != "" && btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText())
            return true;
        
        // Checking if the diagonal from left to right is the winning diagonal
        if(btn1.getText() != "" && btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText())
            return true;
        
        // Checking if the diagonal from right to left is the winning diagonal
        if(btn3.getText() != "" && btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText())
            return true;
        
        // Case for when no player wins the game
        return false;
    }
    
    // This function creates a dialog box that displays the result of the game
    private void ShowResult(String winnerName)
    {
       Dialog <String>dialog = new Dialog<String>();
       
       // The OK button in the dialog box. On clicking this button, the game resets
       ButtonType OkBtn = new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);
       
       // Title of the game
       dialog.setTitle("Winner");
       
       // This label stores the result of the game
       Label result = new Label();
       result.setText(winnerName);
       
       // Adding the label and the button to the dialog box
       dialog.getDialogPane().setContent(result);
       dialog.getDialogPane().getButtonTypes().addAll(OkBtn);
       
       // The dialog box waits for an action for the OK button to be pressed
       dialog.showAndWait();
       
        clearButtons();
        
        StartBtn.setDisable(false);
    }
    
    // This function enables all the grid buttons for the game
    private void enableButtons(){
        
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);
        
    }
    
    // This function disables all the grid buttons for the game
    private void disableButtons(){
        
        btn1.setDisable(true);
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn4.setDisable(true);
        btn5.setDisable(true);
        btn6.setDisable(true);
        btn7.setDisable(true);
        btn8.setDisable(true);
        btn9.setDisable(true);
        
    }
    
    // This function clears the button texts for the grid pane
    private void clearButtons(){
        
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        
    }
    
    // This function is called when the start button is pressed. The game is started until one of the player wins or it ends in a draw
    @FXML
    private void didClickStartButton(ActionEvent event){
        
        // After the start button is clicked and the game is started, the button is set to be disabled until the game is finished
        StartBtn.setDisable(true);
        
        // All the buttons which were disabled are set to enabled as they are required to play the game
        enableButtons();
        
        // The text in each button is initialized to be a blank 
        clearButtons();
    }
    
    // Closing the game scene after clicking the close button
    @FXML
    private void didClickCloseButton(ActionEvent event){
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        stage.close();
    }
    
    // This function is used to set the names of the players from the login scene. It is called in the LoginController file
    public void setNames(String name1, String name2)
    {
       Name1.setText(name1);
       Name2.setText(name2);
    }
    
    // Initializing the button text and disabling them. Setting the colors of the label text to b;ack
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // Setting the text of all the button to black text fields till the game is played
        clearButtons();
        
        // All the 9 buttons in the grid are disabled till the start button is clicked
        disableButtons();
        
        // Setting the label colors to black
        Name2.setTextFill(Color.BLACK);
        Name1.setTextFill(Color.BLACK);
               
    }    
    
}
