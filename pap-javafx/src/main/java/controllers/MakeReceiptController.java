package controllers;

import dialogs.DialogUnits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import pap.Database;
import pap.Item;
import pap.SoldItem;

public class MakeReceiptController {
    private MainController mainController;
    @FXML
    private TableView table;
    @FXML
    private TableColumn<SoldItem, Integer> amountColumn;
    @FXML
    private TableColumn<SoldItem, String> itemCodeColumn;
    @FXML
    private TableColumn<SoldItem, String> itemNameColumn;
    @FXML
    private TableColumn<SoldItem, Double> priceColumn;
    @FXML
    private TableColumn<SoldItem, Double> sumPriceColumn;
    @FXML
    private TextField itemCode;
    @FXML
    private TextField amount;
    @FXML
    private Label sumLabel;

    private ObservableList<Item> data = FXCollections.observableArrayList();
    private final ObservableList<SoldItem> receipt = FXCollections.observableArrayList();

    @FXML
    public void backMenu(){
        mainController.loadStartScreen();
    }

    public void delete(){
        receipt.remove(this.table.getSelectionModel().getSelectedIndex());
        SetLabel();
    }

    public void submit(){
        //commit do bazy
        //wyczyszczenie rachunku
        Database.addReceipt(this.receipt);
        receipt.clear();
        SetLabel();
    }

    public void add(){
        if (this.itemCode != null && this.amount != null) {
            String newProductItemCode = this.itemCode.getText().trim();
            int newProductAmount = Integer.valueOf(this.amount.getText());
            itemCode.clear();
            amount.clear();

            //kawałek kodu szukający 'zeskanowanego' przedmiotu, żeby go dopisać do rachunku
            int checkLength = 0;
            for(Item i : data) {
                if (i.getName().equals(newProductItemCode)) {
                    ++checkLength;
                    if (newProductAmount > i.getAmount()) DialogUnits.errorAmountDialog();
                    else{
                        receipt.add(new SoldItem(i, newProductAmount));
                        SetLabel();
                    }
                }
            }
            if (checkLength==0) DialogUnits.errorItemCodeDialog();
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {
        this.data = Database.connection();
        setValuesInTable();

        SetLabel();

        //uaktywnienie komórek w kolumnach, umożliwienie edytowania ich
        this.amountColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    public void setValuesInTable() {
        this.itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("barecode"));
        this.itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.amountColumn.setCellValueFactory(new PropertyValueFactory<>("soldAmount"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        this.sumPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sumPrice"));
        this.table.setItems(this.receipt);
    }

    //funkcje pobierające nowe - edytowane wartości z tabeli departamentów
    public void editAmountColumn(TableColumn.CellEditEvent<SoldItem, Integer> receiptCellEdit){
        int i = this.table.getSelectionModel().getSelectedIndex();
        this.receipt.get(i).setSoldAmount(receiptCellEdit.getNewValue());
        this.receipt.get(i).calculateSum();
        setValuesInTable();
        SetLabel();
    }

    private void SetLabel(){

        double total = 0 ;
        for (SoldItem item : receipt) {
            total = total + item.getSumPrice();
        }
        this.sumLabel.setText(String.valueOf(total));
    }

}
