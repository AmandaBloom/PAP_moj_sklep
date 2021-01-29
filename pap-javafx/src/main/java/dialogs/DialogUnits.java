//Klasa odpowiedzialna za wyskakujące okienka
package dialogs;

import java.util.Optional;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class DialogUnits {	
	//Okienko pytające się czy chcesz wyjść z aplikacji uruchomiane przyciskiem zamknij
	public static Optional<ButtonType> confirmationDialog() {
		Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationDialog.setTitle("Wyjście");
		confirmationDialog.setHeaderText("Czy napewno chcesz wyjść z aplikacji?");
		Optional<ButtonType> result = confirmationDialog.showAndWait();
		return result;
	}
	
	//Okienko logowania
	@FXML
	public static Optional<Pair<String, String>> logInDialog() {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Zaloguj się");

		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		/*FXMLLoader loader = new FXMLLoader(DialogUnits.class.getResource("/pap/pap_javafx/LoginWindow.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dialog.getDialogPane().setContent(pane);*/

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 150, 10, 10));

		TextField loginTextField = new TextField();
		PasswordField passwordField = new PasswordField();

		gridPane.add(new Label("Login:"), 0, 0);
		gridPane.add(loginTextField, 1, 0);
		gridPane.add(new Label("Hasło:"), 0, 1);
		gridPane.add(passwordField, 1, 1);

		dialog.getDialogPane().setContent(gridPane);

		Platform.runLater(() -> loginTextField.requestFocus());

		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		    	if (loginTextField != null && passwordField != null)
		    		return new Pair<>(loginTextField.getText(), passwordField.getText());
		    }
		    return null;
		});
		Optional<Pair<String,String>> result = dialog.showAndWait();

		return result;
	}
	
	//Okienko błędu aplikacji, uruchamiające się gdy zmienna login w MainControler jest ustawiona na fałsz
	public static void errorDialog() {
		Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		errorAlert.setTitle("Zaloguj się!");
		errorAlert.setHeaderText("Jesteś niezalogowany");
		errorAlert.showAndWait();
	}

	//Okienko błędu informujące o braku towaru o podanym kodzie kreskowym
	public static void errorItemCodeDialog() {
		Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		errorAlert.setTitle("Brak towaru o podanym kodzie w bazie!");
		errorAlert.setHeaderText("Błąd towaru");
		errorAlert.showAndWait();
	}

	//Okienko błędu informujące o braku podanej ilości towaru
	public static void errorAmountDialog() {
		Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		errorAlert.setTitle("Błąd towaru");
		errorAlert.setHeaderText("Brak towaru w magazynie!");
		errorAlert.showAndWait();
	}

	//Okienko błędu informujące o braku uprawnień
	public static void errorUserDialog() {
		Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		errorAlert.setTitle("Brak dostępu");
		errorAlert.setHeaderText("Nie masz do tego uprawnień");
		errorAlert.showAndWait();
	}
	
}
