package com.bestbuy.cucumber.steps;
// **** Created By Harshit Patel ****

import com.bestbuy.bestbuyinfo.ProductSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class ProductStepdefs {

    static String name = "Duracell - AAA Batteries (4-Pack)" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static Double price = 5.49;
    static int shipping = 0;
    static String upc = "041333424019";
    static String description = "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack";
    static String manufacturer = "Duracell";
    static String model = "MN2400B4Z";
    static String url = "http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC";
    static String image = "http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg";

    static int productID = 0;
    @Steps
    ProductSteps productSteps;
    public ValidatableResponse response;

    @When("^I send a POST request to to create new product$")
    public void iSendAPOSTRequestToToCreateNewProduct() {
    }


    @And("^I insert name, type, price, shipping, upc, description, manufacture, model, url, image$")
    public void iInsertNameTypePriceShippingUpcDescriptionManufactureModelUrlImage() {
        response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
    }

    @Then("^I should be able to create product successfully$")
    public void iShouldBeAbleToCreateProductSuccessfully() {
        response.statusCode(201).log().all();

    }

    @And("^I should get product ID$")
    public void iShouldGetProductID() {
        productID = response.extract().path("id");
    }

    @When("^I send a request to get id for newly created product$")
    public void iSendARequestToGetIdForNewlyCreatedProduct() {
        response = productSteps.getProductById(productID);

    }

    @Then("^I should be able to get product detail successfully$")
    public void iShouldBeAbleToGetProductDetailSuccessfully() {
        response.statusCode(200).log().all();
    }

    @When("^I send a PUT request to update product detail$")
    public void iSendAPUTRequestToUpdateProductDetail() {

    }

    @And("^I update name, type, price, shipping, upc, description, manufacture, model, url, image$")
    public void iUpdateNameTypePriceShippingUpcDescriptionManufactureModelUrlImage() {
        name = name + "_updated";
        response = productSteps.updateProduct(productID, name, type, price, shipping, upc, description,
                manufacturer, model, url, image);
    }

    @Then("^I verify product has been updated successfully$")
    public void iVerifyProductHasBeenUpdatedSuccessfully() {
        response.statusCode(200).log().all();
    }

    @When("^I send a DELETE request to delete product$")
    public void iSendADELETERequestToDeleteProduct() {
        response = productSteps.deleteProductByID(productID);
    }

    @Then("^product detail should be deleted successfully$")
    public void productDetailShouldBeDeletedSuccessfully() {
        response.statusCode(200).log().all();
    }

    @And("^I verify product has been deleted$")
    public void iVerifyProductHasBeenDeleted() {
        response = productSteps.getProductById(productID);
        response.statusCode(404).log().all();
    }


}
