package pap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item item;

    @Before
    public void setUp() throws Exception {
         item = new Item("1", "przedmiot", "101", "1", 100, "12", 15., "13");
    }
    @Test
    public void getItemName() {
        String itemName_True, itemName_predict;
        itemName_True = "1";
        itemName_predict = item.getItemname();
        Assert.assertEquals(itemName_predict, itemName_True);
    }

    @Test
    public void getDept() {
        String dept_True, dept_predict;
        dept_True = "101";
        dept_predict = item.getDep();
        Assert.assertEquals(dept_predict, dept_True);
    }

    @Test
    public void setDept() {
        String dept_True, dept_predict;
        dept_True = "202";
        item.setDep(dept_True);
        dept_predict = item.getDep();
        Assert.assertEquals(dept_predict, dept_True);

    }

    @Test
    public void getAmount() {
        int amount_True, amount_predict;
        amount_True = 100;
        amount_predict = item.getAmount();
        Assert.assertEquals(amount_predict, amount_True);
    }

    @Test
    public void getPriceNet() {
        String priceNet_True, priceNet_predict;
        priceNet_True = "12";
        priceNet_predict = item.getPrice_net();
        Assert.assertEquals(priceNet_predict, priceNet_True);
    }

    @Test
    public void getPriceBrt() {
        Double priceBrt_True, priceBrt_predict;
        priceBrt_True = 15.;
        priceBrt_predict = item.getPrice_brt();
        Assert.assertEquals(priceBrt_predict, priceBrt_True);
    }

    @Test
    public void getVat() {
        String vat_True, vat_predict;
        vat_True = "13";
        vat_predict = item.getVat_rate();
        Assert.assertEquals(vat_predict, vat_True);
    }

    @Test
    public void setVat() {
        String vat_True, vat_predict;
        vat_True = "20";
        item.setDep(vat_True);
        vat_predict = item.getDep();
        Assert.assertEquals(vat_predict, vat_True);
    }
}