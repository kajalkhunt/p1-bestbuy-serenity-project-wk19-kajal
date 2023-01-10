package com.bestbuy.bestbuyinfo;
// **** Created By Harshit Patel ****

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/store.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStoreDataDrivenTest extends TestBase {
    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    private double lat;
    private double lng;
    private String hours;

    static int storeID;

    @Steps
    StoreSteps storeSteps;

    @Title("Data Driven test for adding multiple products to the application")
    @Test
    public void createMultipleProducts() {
        storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours).log().all();
    }

}


