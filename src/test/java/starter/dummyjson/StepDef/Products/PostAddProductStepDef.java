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
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PostAddProductStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Post add a new product with valid json body")
    public void postAddANewProductWithValidJsonBody() {
        File json = new File(Constants.JSON_REQUEST+"PostAddProductReqBody.json");
        productsAPI.postAddProductwithValidBody(json);
    }

    @When("Send post add new product")
    public void sendPostAddNewProduct() {
        SerenityRest.when().post(ProductsAPI.POST_ADD_PRODUCT);
    }

    @And("Response body title should be {string}")
    public void responseBodyTitleShouldBe(String title) {
        SerenityRest.and().body(DummyjsonResponses.TITLE, equalTo(title));
    }

    @And("Validate post add new product JSON Schema")
    public void validatePostAddNewProductJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"PostAddProduct.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post add a new product with blank json body")
    public void postAddANewProductWithBlankJsonBody() {
        File json = new File(Constants.JSON_REQUEST+"BlankReqBody.json");
        productsAPI.postAddProductwithBlankBody(json);
    }

    @Given("Post add a new product with invalid json body")
    public void postAddANewProductWithInvalidJsonBody() {
        File json = new File(Constants.JSON_REQUEST+"PostAddProductInvReqBody.json");
        productsAPI.postAddProductwithInvalidBody(json);
    }
}
