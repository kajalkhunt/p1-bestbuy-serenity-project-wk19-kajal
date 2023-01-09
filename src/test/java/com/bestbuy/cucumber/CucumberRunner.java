package com.bestbuy.cucumber;
// **** Created By Harshit Patel ****


import com.bestbuy.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")
public class CucumberRunner extends TestBase {

}
