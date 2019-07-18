package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class QuipAppController {
	List<Integer> answers = new ArrayList<Integer>();
	public int correct = 0;

	QuizApp currentQuiz = new QuizApp();

	@FXML
	private Label addLbl;
	@FXML
	private Label subLbl;
	@FXML
	private Label multiLbl;
	@FXML
	private Label divLbl;
	@FXML
	private Label correctLbl;
	@FXML
	private Label incorrectLbl;
	@FXML
	private Label randomLbl;
	@FXML
	private Label addNum;
	@FXML
	private Label subNum;
	@FXML
	private Label multiNum;
	@FXML
	private Label divNum;
	@FXML
	private Label correctNum;
	@FXML
	private Label incorrectNum;
	@FXML
	private Label randomNum;
	@FXML
	private TextField addField;
	@FXML
	private TextField subField;
	@FXML
	private TextField multiField;
	@FXML
	private TextField divField;
	@FXML
	private Button tryAgainBtn;
	@FXML
	private Button exitBtn;
	@FXML
	private Button submitBtn;

	@FXML
	public void initialize() {
		currentQuiz.generateNumbers();

		randomNum.setText(Integer.toString(currentQuiz.getFirstNum()) + " and " + currentQuiz.getSecondNum());
		addNum.setText(Integer.toString(currentQuiz.getFirstNum()) + " and " + currentQuiz.getSecondNum());
		subNum.setText(Integer.toString(currentQuiz.getFirstNum()) + " and " + currentQuiz.getSecondNum());
		multiNum.setText(Integer.toString(currentQuiz.getFirstNum()) + " and " + currentQuiz.getSecondNum());
		divNum.setText(Integer.toString(currentQuiz.getFirstNum()) + " and " + currentQuiz.getSecondNum());

		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		submitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				correct = 0;
				try {
					answers.add(Integer.parseInt(addField.getText()));
					answers.add(Integer.parseInt(subField.getText()));
					answers.add(Integer.parseInt(multiField.getText()));
					answers.add(Integer.parseInt(divField.getText()));
				} catch (Exception e) {
					answers.clear();
					createAlert("Entered something that is not a number! Please make sure all answers are numbers.");
				}
				if (answers.size() > 0) {
					if (currentQuiz.checkAddition(answers.indexOf(0))) {
						correct++;
					}
					if (currentQuiz.checkSubtraction(answers.get(1))) {
						correct++;
					}
					if (currentQuiz.checkMultiplication(answers.get(2))) {
						correct++;
					}
					if (currentQuiz.checkDivision(answers.get(3))) {
						correct++;
					}
				}

				correctNum.setText(Integer.toString(correct));
				incorrectNum.setText(Integer.toString(4 - correct));
			}

		});

		tryAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/QuizApp.fxml"));
					Parent root = loader.load();
					// Create the Scene
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					// Set the Scene to the Stage
					stage.setScene(scene);
					// Set the Title to the Stage
					stage.setTitle("Workshop 8");
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
