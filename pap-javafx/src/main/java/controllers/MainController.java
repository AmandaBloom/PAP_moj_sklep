//główny konfroler odpowiedzialny głąwnie za ładowanie okna startowego
package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import pap.Database;

public class MainController {

	@FXML
	private StackPane mainStackPane;
	private static boolean login = false; //zmianna określająca czy uzytkownik jest zalogowany, umieszczona tu roboczo
	private static int user = 1;	//poziom pracownika; 1 - może wszysko

	@FXML
	public void initialize(){
		loadStartScreen();
	}

	public void loadStartScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/StartWindow.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StartWindowController startWindow = loader.getController();
		startWindow.setMainController(this);
		setScreen(pane);
	}

	public void setScreen(Pane pane) {
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
	


	//funcje sprawdzające zalogowanie, roboczo podane dane logowania
	public boolean tryLogin(String login, String password) {
		Database database = new Database();
		if (database.login(login,password))
			this.setLogin(true);
		return this.isLogin();
	}

	public static boolean isLogin() {
		return login;
	}

	public static int userLevel() {
		return user;
	}

	public static void setLogin(boolean login) {
		MainController.login = login;
	}
}
