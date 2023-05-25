package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.bytebuddy.description.field.FieldList;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleProductStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Get a single product with valid id {int}")
    public void getASingleProductWithValidId(int id) {
        productsAPI.getSingleProduct(id);
    }

    @When("Send get a single product")
    public void sendGetASingleProduct() {
        SerenityRest.when().get(ProductsAPI.GET_SINGLE_PRODUCT);
    }

    @And("Response body should be id {int}")
    public void responseBodyShouldBeId(int id) {
        SerenityRest.and().body(DummyjsonResponses.ID,equalTo(id));
    }

    @And("Validate get a single product JSON Schema")
    public void validateGetASingleProductJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"GetSingleProduct.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get a single product with invalid id {}")
    public void getASingleProductWithInvalidId(String id) {
        productsAPI.getSingleProductInv(id);
    }

    @Given("Get a single product with {string} id")
    public void getASingleProductWithId(String id) {
        productsAPI.getSingleProductInv(id);
    }
}
