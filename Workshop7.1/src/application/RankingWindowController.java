package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//TODO: fix some messages
public class RankingWindowController {
	BabyRanking rank = new BabyRanking();
	SearchPopUpController searchAgain = new SearchPopUpController();

	private int maleFemale = -1;
	@FXML
	private Label titleLbl;
	@FXML
	private Label resultLabel;
	@FXML
	private Label yearLbl;
	@FXML
	private Label genderLbl;
	@FXML
	private Label nameLbl;
	@FXML
	private Button submitBtn;
	@FXML
	private Button exitBtn;
	@FXML
	private TextField yearTextfield;
	@FXML
	private Button Mbtn;
	@FXML
	private Button Fbtn;
	@FXML
	private TextField nameTextfield;

	@FXML
	public void initialize() {
		Mbtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				maleFemale = 0; // 0 for male
			}

		});

		Fbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				maleFemale = 1; // 1 for female
			}
		});

		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				boolean isEmpty = yearTextfield.getText().isEmpty() || nameTextfield.getText().isEmpty();
				// make sure no fields are empty
				if (isEmpty) {
					createAlert("Please make sure all text fields have content.");
				} else {
					// get the year and convert it to an int
					String recYear = yearTextfield.getText();
					int yearInt = Integer.parseInt(recYear);
					String recName = nameTextfield.getText();
					if (maleFemale == -1) {
						createAlert("Please choose either male or female.");
					}

					if (yearInt < 2001 || yearInt > 2010) {
						createAlert("Please enter between 2001 and 2010 in the Year box");
					} else {
						int tempRank;
						rank.clear();

						if (maleFemale == 0) {
							rank.getFileContents(recYear);
							tempRank = rank.getRank(maleFemale, recName);
							if (tempRank != -1) {
								resultLabel.setText("Boy name " + nameTextfield.getText() + " is ranked #" + tempRank
										+ " in " + yearTextfield.getText() + ".");
							} else {
								resultLabel.setText(
										"Boy name " + nameTextfield.getText() + " in " + recYear + ": No result");
							}

						} else {
							rank.getFileContents(recYear);
							tempRank = rank.getRank(maleFemale, recName);
							if (tempRank != -1) {
								resultLabel.setText("Girl name " + nameTextfield.getText() + " is ranked #" + tempRank
										+ " in " + yearTextfield.getText() + ".");
							} else {
								resultLabel.setText(
										"Girl name " + nameTextfield.getText() + " in " + recYear + ": No result");
							}
						}
					}

				}
			}
		});

		exitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/SearchPopUp.fxml"));
					Parent root = loader.load();
					// Create the Scene
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					// Set the Scene to the Stage
					stage.setScene(scene);
					// Set the Title to the Stage
					stage.setTitle("Search Again?");
					// Display the Stage
					stage.show();
				} catch (Exception e) {
					System.out.println("Exception" + e);
				}

			}
		});
	}

	public void createAlert(String errorString) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error");
		alert.setContentText(errorString);

		alert.showAndWait();
	}

}
