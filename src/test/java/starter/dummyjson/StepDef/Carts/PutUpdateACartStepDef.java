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

public class PutUpdateACartStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Put update a cart with valid parameter id {int} and valid body json")
    public void putUpdateACartWithValidParameterIdAndValidBodyJson(int cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithValidParamAndValidBody.json");
        cartsAPI.putUpdateACart(cart,json);
    }
    @When("Send request put update a cart")
    public void sendRequestPutUpdateACart() {
        SerenityRest.when().put(CartsAPI.PUT_UPDATE_A_CART);
    }
    @And("Response body data user id was {int} and product quantity was {int}")
    public void responseBodyDataUserIdWasAndProductQuantityWas(int id, int quantity) {
        SerenityRest.and().body(DummyjsonResponses.ID,equalTo(id)).body(DummyjsonResponses.PRODUCTS_QUANTITY,equalTo(quantity));
    }
    @And("Validate json schema update a cart with valid parameter id and valid body json")
    public void validateJsonSchemaUpdateACartWithValidParameterIdAndValidBodyJson() {
        File json = new File(Constants.JSON_SCHEMA+"PutUpdateACartWithValidParamAndValidBody.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Put update a cart with invalid body json and valid parameter id {int}")
    public void putUpdateACartWithInvalidBodyJsonAndValidParameterId(int cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithInvalidBodyAndValidParam.json");
        cartsAPI.putUpdateACart(cart,json);
    }

    //Negative Case 2
    @Given("Put update a cart with valid body json and blank parameter id {string}")
    public void putUpdateACartWithValidBodyJsonAndBlankParameterId(String cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithValidParamAndValidBody.json");
        cartsAPI.putUpdateACartWithStringParam(cart,json);
    }

    //Negative Case 3
    @Given("Put update a cart with blank body json and blank parameter id {string}")
    public void putUpdateACartWithBlankBodyJsonAndBlankParameterId(String cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithBlankBody.json");
        cartsAPI.putUpdateACartWithStringParam(cart,json);
    }
}
