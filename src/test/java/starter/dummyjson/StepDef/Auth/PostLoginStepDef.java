package starter.dummyjson.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.CartsAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Login with valid JSON")
    public void loginWithValidJSON() {
        File jsonRequest = new File(Constants.JSON_REQUEST+"PostLoginValidJson.json");
        cartsAPI.postLogin(jsonRequest);
    }
    @When("Send request post to login")
    public void sendRequestPostToLogin() {
        SerenityRest.when().post(CartsAPI.POST_LOGIN);
    }
    @And("And Response body email should be {string}")
    public void andResponseBodyTokenShouldBe(String email) {
        SerenityRest.and().body(DummyjsonResponses.EMAIL,equalTo(email));
    }
    @And("Validate json schema success login with valid username and password")
    public void validateJsonSchemaSuccessLoginWithValidUsernameAndPassword() {
        File json = new File(Constants.JSON_SCHEMA+"PostLoginSuccess.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Login with invalid JSON")
    public void loginWithInvalidJSON() {
        File jsonRequest = new File(Constants.JSON_REQUEST+"PostLoginWithBlankPassword.json");
        cartsAPI.postLogin(jsonRequest);
    }
    @And("Validate json schema failed login")
    public void validateJsonSchemaFailedLogin() {
        File json = new File(Constants.JSON_SCHEMA+"PostLoginWithBlankPassword.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
