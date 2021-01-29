package pap;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty barecode;
    private  SimpleStringProperty name;
    private SimpleStringProperty dep;
    private SimpleStringProperty itemname;
    private SimpleIntegerProperty amount;
    private SimpleStringProperty price_net;
    private SimpleDoubleProperty price_brt;
    private SimpleStringProperty vat_rate;
    //private SimpleIntegerProperty producer;

    public Item(String id, String name, String price, String itemname, int amount, String price_net, double price_brt, String vat_rate) {
        this.barecode = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.dep = new SimpleStringProperty(price);
        this.itemname = new SimpleStringProperty(itemname);
        this.amount = new SimpleIntegerProperty(amount);
        this.price_net = new SimpleStringProperty(price_net);
        this.price_brt = new SimpleDoubleProperty(price_brt);
        this.vat_rate = new SimpleStringProperty(vat_rate);
        //this.producer = new SimpleIntegerProperty(producer);
    }

    public Item(){

    }

    public String getId() {
        return barecode.get();
    }
    public void setId(String iid) {
        barecode.set(iid);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String iName) {
        name.set(iName);
    }


    public String getItemname() {
        return itemname.get();
    }

    public String getDep() {
        return dep.get();
    }

    public SimpleStringProperty depProperty() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep.set(dep);
    }

    public int getAmount() {
        return amount.get();
    }

    public String getPrice_net() { return price_net.get(); }
    public void setPrice_net(String price_net) { this.price_net.set(price_net); }

    public Double getPrice_brt() { return price_brt.get(); }
    public void setPrice_brt(double price_brt) {
        this.price_brt.set(price_brt);
    }

    public String getVat_rate() {
        return vat_rate.get();
    }
    public void setVat_rate(String vat_rate) {
        this.vat_rate.set(vat_rate);
    }
}
