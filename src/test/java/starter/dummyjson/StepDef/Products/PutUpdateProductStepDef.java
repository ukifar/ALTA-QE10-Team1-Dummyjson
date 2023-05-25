package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PutUpdateProductStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Put update a product with valid {int} and json body")
    public void putUpdateAProductWithValidAndJsonBody(int id) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateProductReqBody.json");
        productsAPI.putUpdateProductValid(id, json);
    }

    @When("Send put update product")
    public void sendPutUpdateProduct() {
        SerenityRest.when().put(ProductsAPI.PUT_UPDATE_PRODUCT);
    }

    @And("Response body id should be {int} and title should be {string}")
    public void responseBodyIdShouldBeAndTitleShouldBe(int id, String title) {
        SerenityRest.and()
                .body(DummyjsonResponses.ID, equalTo(id))
                .body(DummyjsonResponses.TITLE, equalTo(title));
    }

    @And("Validate put update product JSON Schema")
    public void validatePutUpdateProductJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"PutUpdateProduct.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update a product with {int} blank json body")
    public void putUpdateAProductWithBlankJsonBody(int id) {
        File json = new File(Constants.JSON_REQUEST+"BlankReqBody.json");
        productsAPI.putUpdateProductBlank(id, json);
    }

    @Given("Put update a product with {int} invalid json body")
    public void putUpdateAProductWithInvalidJsonBody(int id) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateProductInvReqBody.json");
        productsAPI.putUpdateProductInvalid(id, json);
    }
}
