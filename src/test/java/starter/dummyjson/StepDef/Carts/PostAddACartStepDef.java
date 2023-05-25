package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostAddACartStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Post add a cart with valid json")
    public void postAddACartWithValidJson() {
        File json = new File(Constants.JSON_REQUEST+"PostAddACartWithValidJson.json");
        cartsAPI.postAddACartWithValidJson(json);
    }
    @When("Send request post add a cart")
    public void sendPostAddACart() {
        SerenityRest.when().post(CartsAPI.POST_ADD_A_CART);
    }
    @And("Response body data user id was {int} and product title was {string}")
    public void responseBodyDataUserIdShouldBe(int id, String product) {
        SerenityRest.and().body(DummyjsonResponses.USER_ID,equalTo(id)).body(DummyjsonResponses.PRODUCTS_TITLE,equalTo(product));
    }
    @And("Validate json schema add a cart with valid json")
    public void validateJsonSchemaAddACartWithValidJson() {
        File json = new File(Constants.JSON_SCHEMA+"PostAddACartWithValidJson.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Post add a cart with blank body id")
    public void postAddACartWithBlankBodyId() {
        File json = new File(Constants.JSON_REQUEST+"PostAddACartWithBlankBodyId.json");
        cartsAPI.postAddACartWithValidJson(json);
    }

    //Negative Case 2
    @Given("Post add a cart with extra body category")
    public void postAddACartWithExtraBodyCategory() {
        File json = new File(Constants.JSON_REQUEST+"PostAddACartWithExtraBody.json");
        cartsAPI.postAddACartWithValidJson(json);
    }
}
