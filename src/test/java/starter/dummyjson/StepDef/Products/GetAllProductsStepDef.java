package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.Constants;

import java.io.File;

public class GetAllProductsStepDef {

    @Steps
    ProductsAPI productsAPI;

//    Valid
    @Given("Get all products with valid parameter page")
    public void getAllProductsWithValidParameterPage() {
        SerenityRest.given().get(ProductsAPI.GET_ALL_PRODUCTS);
    }

    @And("Validate get all products JSON Schema")
    public void validateGetAllProductsJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"GetAllProducts.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid
    @Given("Get all products with invalid parameter page {}")
    public void getAllProductsWithInvalidParameterPage(String page) {
        productsAPI.getAllProductsInv(page);
    }

    @When("Send get all products")
    public void sendGetAllProducts() {
        SerenityRest.when().get(ProductsAPI.GET_ALL_PRODUCTS_INV);
    }
}
