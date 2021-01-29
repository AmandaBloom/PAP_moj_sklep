package controllers;

import java.io.IOException;
import java.util.Optional;

import dialogs.DialogUnits;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;


public class StartWindowController {
	private MainController mainController;
	private String login; 
	private String password;
	@FXML
	private Label info;
	
	@FXML
	public void logIn(){
		Optional<Pair<String, String>> result = DialogUnits.logInDialog();
		result.ifPresent(usernamePassword -> {
		    this.login = usernamePassword.getKey();
		    this.password = usernamePassword.getValue();
		});
		if(mainController.tryLogin(this.login, this.password) == true)
			info.setText("Zalogowano");
		else
			info.setText("Błąd logowania");
	}

	@FXML
	public void departments(){
		if(mainController.isLogin() == true && mainController.userLevel() == 1) {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/Departments.fxml"));
			Pane pane = null;
			try {
				pane = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			DepartmentsController depController = loader.getController();
			depController.setMainController(mainController);
			mainController.setScreen(pane);
		}
		else if(mainController.isLogin() == false)
			DialogUnits.errorDialog();
		else if(mainController.userLevel() != 1)
			DialogUnits.errorUserDialog();
	}

	@FXML
	public void employees(){
		if(mainController.isLogin() == true && mainController.userLevel() == 1) {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/ShowEmployees.fxml"));
			Pane pane = null;
			try {
				pane = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			EmployeesControler empController = loader.getController();
			empController.setMainController(mainController);
			mainController.setScreen(pane);
		}
		else if(mainController.isLogin() == false)
			DialogUnits.errorDialog();
		else if(mainController.userLevel() != 1)
			DialogUnits.errorUserDialog();
	}
	
	@FXML
	public void storage(){
		if(mainController.isLogin() == true) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/ShowStorage.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StorageController storageController = loader.getController();
		storageController.setMainController(mainController);
		mainController.setScreen(pane);
		}
		else
			DialogUnits.errorDialog();
			
	}

	@FXML
	public void makeReceipt(){
		if(mainController.isLogin() == true) {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/MakeReceipt.fxml"));
			VBox vbox = null;
			try {
				vbox = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			MakeReceiptController makeReceiptController = loader.getController();
			makeReceiptController.setMainController(mainController);
			mainController.setScreen(vbox);
		}
		else
			DialogUnits.errorDialog();

	}


	
	@FXML
	public void exit(){
		Optional<ButtonType> result = DialogUnits.confirmationDialog();
		if(result.get() == ButtonType.OK)
			Platform.exit();
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}
