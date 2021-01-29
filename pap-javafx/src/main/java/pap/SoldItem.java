package pap;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SoldItem extends Item {
    private SimpleStringProperty barecode;
    private SimpleStringProperty name;
    private SimpleIntegerProperty soldAmount;
    private SimpleDoubleProperty price;
    private SimpleDoubleProperty sumPrice;

    public SoldItem(String barecode, String name, int soldAmount, double price) {
        super();
        this.barecode = new SimpleStringProperty(barecode);
        this.name = new SimpleStringProperty(name);
        this.soldAmount = new SimpleIntegerProperty(soldAmount);
        this.price = new SimpleDoubleProperty(price);
        this.sumPrice = new SimpleDoubleProperty(price*soldAmount);
    }

    public SoldItem(Item item, int soldAmount) {
        this.barecode = new SimpleStringProperty(item.getId());
        this.name = new SimpleStringProperty(item.getItemname());
        this.soldAmount = new SimpleIntegerProperty(soldAmount);
        this.price = new SimpleDoubleProperty(item.getPrice_brt());
        this.sumPrice = new SimpleDoubleProperty(item.getPrice_brt()*soldAmount);
    }

    public String getBarecode() {
        return barecode.get();
    }

    public SimpleStringProperty barecodeProperty() {
        return barecode;
    }

    public void setBarecode(String barecode) {
        this.barecode.set(barecode);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getSoldAmount() {
        return soldAmount.get();
    }

    public SimpleIntegerProperty soldAmountProperty() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount.set(soldAmount);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getSumPrice() {
        return sumPrice.get();
    }

    public SimpleDoubleProperty sumPriceProperty() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice.set(sumPrice);
    }

    public void calculateSum(){
        this.sumPrice = new SimpleDoubleProperty( getSoldAmount() * getPrice());
    }

}
