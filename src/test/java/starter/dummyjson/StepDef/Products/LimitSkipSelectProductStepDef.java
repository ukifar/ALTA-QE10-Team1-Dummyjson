package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LimitSkipSelectProductStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Limit {}, skip {}, and select {} products with valid parameter page")
    public void andProductsWithValidParameterPage(int limit, int skip, String select) {
        productsAPI.lssProductsValid(limit,skip,select);
    }

    @When("Send get limit skip select")
    public void sendGetLimitSkipSelect() {
        SerenityRest.when().get(ProductsAPI.LIMIT_SKIP_SELECT_PRODUCTS);
    }

    @And("Response body limit should be {} skip should be {}")
    public void responseBodyLimitShouldBeSkipShouldBeAndSelectShouldBe(int limit, int skip, String select) {
        SerenityRest.and()
                .body(DummyjsonResponses.LIMIT, equalTo(limit))
                .body(DummyjsonResponses.SKIP, equalTo(skip))
                .body(DummyjsonResponses.SELECT, equalTo(select));
    }

    @Given("Limit {}, skip {}, and select {} products with invalid parameter page")
    public void limitSkipAndSelectProductsWithInvalidParameterPage(String limit, String skip, String select) {
        productsAPI.lssProductsInvalid(limit,skip,select);
    }

    @Given("Limit {string}, skip {string}, and select {string} products with blank parameter page")
    public void limitSkipAndSelectProductsWithBlankParameterPage(String limit, String skip, String select) {
        productsAPI.lssProductsInvalid(limit, skip, select);
    }
}
