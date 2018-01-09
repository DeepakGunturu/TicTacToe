/*
 * Name: Deepak Kumar Gunturu
 * Course: COP 3330, Fall 2017, MWF: 12:30 PM - 1:20 PM
 * Professor: Neslisah Torosdagli
 * Assignment Description: Bonus Assignment
 * Implementation of Tic Tac Toe using Java FX and Scene Builder
 *
 */
 
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.lang.Runnable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author deepakkumargunturu
 */
public class LoginController implements Initializable {
    
    // Button for the start option
    @FXML
    private Button mStartButton;
    
    // Button for the cancel option
    @FXML
    private Button mCloseButton;
    
    // Text field for the name of the first player
    @FXML
    private TextField Name1;
    
    // Text field for the name of the second player
    @FXML
    private TextField Name2;
    
    // Object for the GamePlayController class. It is used to open the new scene for the game scene
    private GamePlayController gamePlay;
    
    // This function closes the scene on clicking the Cancel button
    @FXML
    private void didClickCloseButton(ActionEvent event){
        Stage stage = (Stage) mCloseButton.getScene().getWindow();
        stage.close();
    }
    
    // This function is bound to the start button and is used to set the names that we get from the text entry fields and set the names of the players
    // Clicking on the start button takes the user to the next game scene in which the game is played
    @FXML
    private void didClickStartButton(ActionEvent event){
        
        gamePlay.setNames(getName1(), getName2());
        
        TicTacToe.mApp.mStage.setScene(TicTacToe.mApp.gameScene);
        TicTacToe.mApp.mStage.show();
    }
   
    // This function is used to get the name of the first player that is entered in the text field beside the label Player 1
    // If nothing is entered, the name of the first player is set to "PLAYER 1"
    public String getName1()
    {
        return (Name1.getText().equals("") || Name1.getText() == null) ? "PLAYER 1" : Name1.getText();       
    }
    
    // This function is used to get the name of the first player that is entered in the text field beside the label Player 1
    // If nothing is entered, the name of the first player is set to "PLAYER 2"
    public String getName2()
    {
        return (Name2.getText().equals("") || Name2.getText() == null) ? "PLAYER 2" : Name2.getText();
    }
    
    // This function passes the object of the GamePlayController class as an argument from the main TicTacToe class and it is passed to the gamePlay object
    public void setGameController(GamePlayController g)
    {
        gamePlay = g;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 
}
