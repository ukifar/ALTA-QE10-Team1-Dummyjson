package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.CartsAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleCartStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Get single cart with valid id {int}")
    public void getSingleCartWithValidId(int id) {
        cartsAPI.getaSingleCartWithValidParamId(id);
    }
    @When("Send request get single cart")
    public void sendRequestGetSingleCart() {
        SerenityRest.when().get(CartsAPI.GET_A_SINGLE_CART);
    }
    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then().body(DummyjsonResponses.ID,equalTo(id));
    }
    @And("Validate json schema get single cart with valid parameter id")
    public void validateJsonSchemaGetSingleCartWithValidParameterId() {
        File json = new File(Constants.JSON_SCHEMA+"GetSingleCartWithValidParam.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
