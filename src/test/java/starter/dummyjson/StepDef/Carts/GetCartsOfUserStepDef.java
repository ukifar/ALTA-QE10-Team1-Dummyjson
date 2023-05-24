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

public class GetCartsOfUserStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Get carts of user with valid id {int}")
    public void getCartsOfUserWithValidId(int id) {
        cartsAPI.getaSingleCartWithValidParamId(id);
    }
    @When("Send request get carts of user")
    public void sendRequestGetCartsOfUser() {
        SerenityRest.when().get(CartsAPI.GET_CARTS_OF_USER);
    }
    @And("Response body data carts id is [{int}]")
    public void responseBodyDataCartsIdIsCartsId(int id) {
        SerenityRest.then().body(DummyjsonResponses.CARTS_ID_ARRAY, equalTo(id));
    }
    @And("Validate json schema get carts of user with valid parameter id")
    public void validateJsonSchemaGetCartsOfUserWithValidParameterId() {
        File json = new File(Constants.JSON_SCHEMA+"GetCartsOfUserWithValidParam.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Get carts of user with invalid id {string}")
    public void getCartsOfUserWithInvalidId(String id) {
        cartsAPI.getCartsOfUserWithInvalidParamId(id);
    }
    @Then("Should return status code {int} Bad Request")
    public void shouldReturnStatusCodeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Negative Case 2
    @Given("Get carts of user with exceed id {int}")
    public void getCartsOfUserWithExceedId(int id) {
        cartsAPI.getaSingleCartWithValidParamId(id);
    }

    //Negative Case 3
    @Given("Get carts of user with blank parameter id {string}")
    public void getCartsOfUserWithBlankParameterId(String id) {
        cartsAPI.getCartsOfUserWithInvalidParamId(id);
    }
}
