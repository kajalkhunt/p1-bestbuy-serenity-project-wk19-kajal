package com.bestbuy.bestbuyinfo;
// **** Created By Harshit Patel ****

import com.bestbuy.constants.EndPoints;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

    @WithTag("bestbuyfeature:NEGATIVE")
    @Title("Provide a status code when incorrect HTTP method is used to across resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then()
                .statusCode(405)
                .log().all();
        //clean verify -Dtags=studentfeature:NEGATIVE serenity:aggregate
    }

    @WithTag("bestbuyfeature:POSITIVE")
    @Title("Provide a status code when incorrect HTTP method is used to across resource")
    @Test
    public void validMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then()
                .statusCode(200)
                .log().all();
        //clean verify -Dtags=studentfeature:POSITIVE serenity:aggregate
    }

}
