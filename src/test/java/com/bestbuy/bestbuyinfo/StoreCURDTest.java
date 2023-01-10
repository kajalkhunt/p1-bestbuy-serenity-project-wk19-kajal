package com.bestbuy.bestbuyinfo;


import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StoreCURDTest extends TestBase {

    static String name = "Minnetonka" + TestUtils.getRandomValue();
    static String type = "BigBox";
    static String address = "Random Court";
    static String address2 = "Random Street";
    static String city = "Universe";
    static String state = "Cloud";
    static String zip = "5455632";
    static double lat = 56.565622;
    static double lng = -50.5654;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";

    static int storeID;
    @Steps
    StoreSteps storeSteps;

    @Title("This will create new store")
    @Test
    public void test001() {
        ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours);
        response.log().all().statusCode(201);
        storeID = response.log().all().extract().path("id");
    }

    @Title("Verify if the store has been added to application")
    @Test
    public void test002() {
        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(storeMap, hasValue(type));

    }

    @Title("This will update store information")
    @Test
    public void test003() {
        name = name + "_Updated";

        storeSteps.updateStore(storeID, name, type, address, address2, city, state, zip, lat, lng, hours);

        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(storeMap, hasValue(city));
    }

    @Title("This will delete Store")
    @Test
    public void test004() {

        storeSteps.deleteStoreByID(storeID).statusCode(200);
        storeSteps.getStoreById(storeID).statusCode(404);
    }

}
