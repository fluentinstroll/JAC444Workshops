/**********************************************
Workshop #7
Course:JAC444 - Semester 4
Last Name:Rambo
First Name:Raymond
ID:122082175
Section: SCD
This assignment represents my own work in accordance with Seneca Academic Policy.
Raymond Rambo Signature
Date:2019/07/10
**********************************************/
package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TesterClass extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/RankingWindow.fxml"));
		Parent root = loader.load();
		// Create the Scene
		Scene scene = new Scene(root);
		// Set the Scene to the Stage
		primaryStage.setScene(scene);
		// Set the Title to the Stage
		primaryStage.setTitle("Baby Ranking Workshop 7");
		// Display the Stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		
		ConnectFour connectFour = new ConnectFour();
		connectFour.playGame();

		Application.launch(args);
	}
}
