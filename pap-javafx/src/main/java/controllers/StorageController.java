//wypisywanie danych z bazy w postaci tabeli
package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import pap.Database;
import pap.Item;

import java.io.IOException;

public class StorageController {
	private MainController mainController;
	@FXML
	private TableView table;
	@FXML
	private TableColumn<Item, String> idColumn;
	@FXML
	private TableColumn<Item, String> itemCodeColumn;
	@FXML
	private TableColumn<Item, String> deptIDColumn;
	@FXML
	private TableColumn<Item, String> itemNameColumn;
	@FXML
	private TableColumn<Item, String> amountColumn;
	@FXML
	private TableColumn<Item, String> priceNettoColumn;
	@FXML
	private TableColumn<Item, String> priceBruttoColumn;
	@FXML
	private TableColumn<Item, String> vatColumn;
	@FXML
	private ComboBox departmentComboBox;

	private ObservableList<Item> data = FXCollections.observableArrayList();
	private ObservableList<Pair> depts = FXCollections.observableArrayList();

	@FXML
	public void backMenu(){
		mainController.loadStartScreen();
	}

	@FXML
	public void addProduct(ActionEvent actionEvent) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/AddProduct.fxml"));
		VBox vbox = null;
		try {
			vbox = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(vbox, 580, 350);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
	}

	@FXML
	public void backupProduct(ActionEvent actionEvent) {
		this.data = Database.connection();
		setValuesInTable();
	}


	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void initialize() {
		this.data = Database.connection();
		this.depts= Database.getDepartments();
        this.departmentComboBox.setItems(FXCollections.observableArrayList(this.depts));
		setValuesInTable();

		//uaktywnienie komórek w kolumnach, umożliwienie edytowania ich
		this.idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.itemCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.deptIDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	private void setValuesInTable() {
		this.table.setItems(this.data);
		this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		this.deptIDColumn.setCellValueFactory(new PropertyValueFactory<>("dep"));
		this.itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemname"));
		this.amountColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("amount"));
		this.priceNettoColumn.setCellValueFactory(new PropertyValueFactory<>("price_net"));
		this.priceBruttoColumn.setCellValueFactory(new PropertyValueFactory<>("price_brt"));
		this.vatColumn.setCellValueFactory(new PropertyValueFactory<>("vat_rate"));
	}

	//funkcje pobierające nowe - edytowane wartości z tabeli departamentów
	public void editIDColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editItemCodeColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editDeptIDColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editNameColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editAmountColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editPriceNettoColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editPriceBruttoColumn(TableColumn.CellEditEvent<Item, String> deptCellEdit){
		deptCellEdit.getNewValue();
	}

	public void editVatColumn(TableColumn.CellEditEvent<Item, String> storageCellEdit){
		//this.data.get(this.table.getSelectionModel().getSelectedIndex()).setVat(storageCellEdit.getNewValue());
	}

	public void selectedDepartment(){
		Pair department = (Pair) this.departmentComboBox.getSelectionModel().getSelectedItem();
		this.data = Database.connectionSelected(department.getKey().toString());
		setValuesInTable();
	}
}