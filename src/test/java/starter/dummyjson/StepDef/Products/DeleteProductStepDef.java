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


public class DeleteProductStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Delete a product with valid id {int}")
    public void deleteAProductWithValidId(int id) {
        productsAPI.deleteProductValid(id);
    }

    @When("Send delete product")
    public void sendDeleteProduct() {
        SerenityRest.when().delete(ProductsAPI.DELETE_PRODUCT);
    }

    @And("Response body id should be {int} and deleted is true")
    public void responseBodyIdShouldBeAndDeleteIsTrue(int id) {
        boolean deleted = true;
        SerenityRest.and()
                .body(DummyjsonResponses.ID, equalTo(id))
                .body("isDeleted",equalTo(deleted));
    }

    @And("Validate delete product JSON Schema")
    public void validateDeleteProductJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"DeleteProduct.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete a  product with {string} id")
    public void deleteAProductWithId(String id) {
        productsAPI.deleteProductInv(id);
    }

    @Given("Delete a product with invalid id {}")
    public void deleteAProductWithInvalidId(String id) {
        productsAPI.deleteProductInv(id);
    }
}
