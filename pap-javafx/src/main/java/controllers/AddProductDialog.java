package controllers;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;
import pap.Database;
import pap.Department;
import pap.Employee1;
import pap.Item;

public class AddProductDialog {

	@FXML
	private TextField barcode;
	@FXML
	private TextField name;
	@FXML
	private TextField amount;
	@FXML
	private TextField price_netto;
	@FXML
	private ComboBox DepartmentNumber;
	@FXML
	private ComboBox ProducentComboBox;
	@FXML
	private ComboBox TaxComboBox;

	private ObservableList<Department> mainObservableList;
	private ObservableList<Employee1> data = FXCollections.observableArrayList();
	private ObservableList<Item> items = Database.connection();
	private ObservableList<Pair> dept = FXCollections.observableArrayList();
	private ObservableList<Pair> prod = FXCollections.observableArrayList();
	private ObservableList<Pair> taxes= FXCollections.observableArrayList();

	public void initialize() {
		this.data = Database.empConnection();
		this.dept= Database.getDepartments();
		this.prod = Database.getProducent();
		this.taxes = Database.getTaxRates();

		this.DepartmentNumber.setItems(FXCollections.observableArrayList(this.dept));
		this.ProducentComboBox.setItems(FXCollections.observableArrayList(this.prod));
		this.TaxComboBox.setItems(FXCollections.observableArrayList(this.taxes));
	}

	public void addProduct(ActionEvent event) {
		if (barcode != null  && name != null && amount != null && price_netto != null) {
			int vat_rate = Integer.parseInt(this.TaxComboBox.getValue().toString().substring(0,2).replaceAll("=", ""));
			double brutto = Math.round(Integer.parseInt(price_netto.getText()) + Integer.parseInt(this.price_netto.getText())*0.01*vat_rate);
			switch (vat_rate) {
				case 23:
					vat_rate = 601;
					break;
				case 8:
					vat_rate = 602;
					break;
				case 5:
					vat_rate = 603;
					break;
				case 0:
					vat_rate = 604;
					break;
				default:
					vat_rate = 0;
					break;
			}
			Database.addItem(
					this.items, barcode.getText(), this.DepartmentNumber.getValue().toString().substring(0,4),
					name.getText(), Integer.parseInt(amount.getText()), price_netto.getText(), brutto,
					vat_rate, Integer.parseInt(this.ProducentComboBox.getValue().toString().substring(0,4))
			);


			closeStage(event);
		}
	}

	private void closeStage(ActionEvent event) {
		Node source = (Node)  event.getSource();
		Stage stage  = (Stage) source.getScene().getWindow();
		stage.close();
	}
}
