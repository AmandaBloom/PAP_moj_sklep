package pap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    Address adr;

    @Before
    public void setUp() throws Exception {
        adr = new Address("1", "00-000", "Ulica", "1", "miasto", "Panstwo");
    }
    @Test
    public void getId() {
        String id_True, id_predict;
        id_True = "1";
        id_predict = adr.getId();
        Assert.assertEquals(id_predict,id_True);
    }

    @Test
    public void setId() {
        String id_True, id_predict;
        id_True = "201";
        adr.setId(id_True);
        id_predict = adr.getId();
        Assert.assertEquals(id_predict,id_True);

    }

    @Test
    public void getPostal() {
        String postal_True, postal_predict;
        postal_True = "00-000";
        postal_predict = adr.getPostal();
        Assert.assertEquals(postal_predict,postal_True);
    }

    @Test
    public void setPostal() {
        String postal_True, postal_predict;
        postal_True = "11-111";
        adr.setPostal(postal_True);
        postal_predict = adr.getPostal();
        Assert.assertEquals(postal_predict,postal_True);

    }
    @Test
    public void getStreet() {
        String street_True, street_predict;
        street_True = "Ulica";
        street_predict = adr.getStreet();
        Assert.assertEquals(street_predict, street_True);
    }

    @Test
    public void setStreet() {
        String street_True, street_predict;
        street_True = "Warszawska";
        adr.setStreet(street_True);
        street_predict = adr.getStreet();
        Assert.assertEquals(street_predict, street_True);

    }

    @Test
    public void getStNum() {
        String stNum_True, stNum_predict;
        stNum_True = "1";
        stNum_predict = adr.getSt_num();
        Assert.assertEquals(stNum_predict, stNum_True);
    }

    @Test
    public void setStNum() {
        String stNum_True, stNum_predict;
        stNum_True = "10";
        adr.setSt_num(stNum_True);
        stNum_predict = adr.getSt_num();
        Assert.assertEquals(stNum_predict, stNum_True);

    }
    @Test
    public void getCity() {
        String city_True, city_predict;
        city_True = "miasto";
        city_predict = adr.getCity();
        Assert.assertEquals(city_predict, city_True);
    }

    @Test
    public void setCity() {
        String city_True, city_predict;
        city_True = "Warszawa";
        adr.setCity(city_True);
        city_predict = adr.getCity();
        Assert.assertEquals(city_predict, city_True);

    }

    @Test
    public void getCountry() {
        String country_True, country_predict;
        country_True = "Panstwo";
        country_predict = adr.getCountry();
        Assert.assertEquals(country_predict, country_True);
    }

    @Test
    public void setCountry() {
        String country_True, country_predict;
        country_True = "Polska";
        adr.setCountry(country_True);
        country_predict = adr.getCountry();
        Assert.assertEquals(country_predict, country_True);

    }
}