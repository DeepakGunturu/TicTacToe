/*
 * Name: Deepak Kumar Gunturu
 * Course: COP 3330, Fall 2017, MWF: 12:30 PM - 1:20 PM
 * Professor: Neslisah Torosdagli
 * Assignment Description: Bonus Assignment
 * Implementation of Tic Tac Toe using Java FX and Scene Builder
 *
 */
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author deepakkumargunturu
 */


public class TicTacToe extends Application {
    
    // Members that are going to be used to open the game scene
    Scene gameScene;
    static TicTacToe mApp;
    Stage mStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // This is used to load the GamePlay scene and instantiate it
        mApp = this;
        FXMLLoader gamePlay = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        Parent gameRoot = gamePlay.load();
        gameScene = new Scene(gameRoot);
        
        // This is used to load the Login scene and instantiate it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        LoginController login = loader.getController();
        
        // This details of the GamePlay scene instantiated in the LoginContoller class are passed to this GamePlayController object using the getController method
        // The game scene is set to the object by using a LoginController class object
        GamePlayController gamePlaycontrol = gamePlay.getController();
        mStage = stage;
        login.setGameController(gamePlaycontrol);
        
        // When the application is launched, the Login scene in the first one to be launched
        stage.setTitle("My TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
