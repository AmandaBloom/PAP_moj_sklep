//start
package pap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	 
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/MainStackPane.fxml"));
		StackPane stackPane = loader.load();
		Scene scene = new Scene(stackPane, 700, 400);
	 
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mój Sklep");
		primaryStage.show();
	}
}
   
