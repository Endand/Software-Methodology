package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * starts the program
 * 
 * @author Jonathan Li, Bufan Jiang, Jihun Joo
 */

public class Main extends Application {

	
	/**
	 * builds the app
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root, 500, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Program 3 - Tuition Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * main method
	 * 
	 * @param args launches the GUI
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
