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
@UseTestDataFrom("src/test/java/resources/testdata/product.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBase {
    private String name;
    private String type;
    private Double price = 5.49;
    private int shipping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url = "http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC";
    private String image = "http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg";

    static int productID;
    @Steps
    ProductSteps productSteps;

    @Title("Data Driven test for adding multiple products to the application")
    @Test
    public void createMultipleProducts() {
        productSteps.createProduct(name,type,price,shipping,upc,description,manufacturer,model,url,image).statusCode(201).log().all();
    }

}


