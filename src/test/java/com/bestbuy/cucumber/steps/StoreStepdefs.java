package com.bestbuy.cucumber.steps;

// **** Created By Harshit Patel ****

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StoreStepdefs {

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

    ValidatableResponse response;

    @Steps
    StoreSteps storeSteps;

    @Given("^Bestbuy Application is running in the background$")
    public void bestbuyApplicationIsRunningInTheBackground() {
    }

    @When("^I send a POST request to to create new store$")
    public void iSendAPOSTRequestToToCreateNewStore() {
    }

    @And("^User insert name, type, address, address2, city, state,zip, lat, lng, hours$")
    public void userInsertNameTypeAddressAddressCityStateZipLatLngHours() {
        response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours).log().all();
    }

    @Then("^I should be able to create store successfully$")
    public void iShouldBeAbleToCreateStoreSuccessfully() {
        response.statusCode(201).log().all();
    }

    @And("^I should get store ID$")
    public void iShouldGetStoreID() {
        storeID = response.log().all().extract().path("id");
    }

    @When("^I send a request to get id for newly created store$")
    public void iSendARequestToGetIdForNewlyCreatedStore() {
        response = storeSteps.getStoreById(storeID);
        response.statusCode(200).log().all();
        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(storeMap, hasValue(type));

    }

    @Then("^I should be able to get store detail successfully$")
    public void iShouldBeAbleToGetStoreDetailSuccessfully() {
        // response.statusCode(200).log().all();
    }

  /*  @And("^I verify to check store has been created successfully$")
    public void iVerifyToCheckStoreHasBeenCreatedSuccessfully() {
        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(storeMap, hasValue(type));
    }*/

    @When("^I send a PUT request to update store name$")
    public void iSendAPUTRequestToUpdateStoreName() {
        name = name + "_Updated";
        response = storeSteps.updateStore(storeID, name, type, address, address2, city, state, zip, lat, lng, hours);
    }

    @Then("^I verify name has been updated successfully$")
    public void iVerifyNameHasBeenUpdatedSuccessfully() {
        response.statusCode(200).log().all();
    }

    @When("^I send a DELETE request$")
    public void iSendADELETERequest() {
        response = storeSteps.deleteStoreByID(storeID);
    }

    @Then("^Store detail should be deleted successfully$")
    public void storeDetailShouldBeDeletedSuccessfully() {
        response.statusCode(200).log().all();
    }

    @And("^I verify store has been deleted$")
    public void iVerifyStoreHasBeenDeleted() {
        response = storeSteps.getStoreById(storeID);
        response.statusCode(404).log().all();
    }


}
