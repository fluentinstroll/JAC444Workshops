package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SearchPopUpController {
	@FXML
	private Label searchAgainLbl;
	@FXML
	private Button searchAgainBtn;
	@FXML
	private Button exitBtn;

	@FXML
	public void initialize() {

		searchAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/RankingWindow.fxml"));
					Parent root = loader.load();
					// Create the Scene
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					// Set the Scene to the Stage
					stage.setScene(scene);
					// Set the Title to the Stage
					stage.setTitle("Baby Ranking Workshop 7");
					// Display the Stage
					stage.show();
				}catch(Exception e) {
					System.out.println("Exception: " + e);
				}
			}
		});

		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}
}
