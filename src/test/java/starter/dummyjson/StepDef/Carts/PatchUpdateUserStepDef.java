package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.CartsAPI;
import starter.dummyjson.Utils.Constants;

import java.io.File;

public class PatchUpdateUserStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Patch update a cart with valid parameter id {int} and valid body json")
    public void patchUpdateACartWithValidParameterIdAndValidBodyJson(int cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithValidParamAndValidBody.json");
        cartsAPI.putUpdateACart(cart,json);
    }
    @When("Send request patch update a cart")
    public void sendRequestPatchUpdateACart() {
        SerenityRest.when().patch(CartsAPI.PATCH_UPDATE_A_CART);
    }
    @And("Validate json schema patch update a cart with valid parameter id and valid body json")
    public void validateJsonSchemaPatchUpdateACartWithValidParameterIdAndValidBodyJson() {
        File json = new File(Constants.JSON_SCHEMA+"PutUpdateACartWithValidParamAndValidBody.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Patch update a cart with valid parameter id {int} and invalid body id")
    public void patchUpdateACartWithValidParameterIdAndInvalidBodyId(int cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithInvalidBodyAndValidParam.json");
        cartsAPI.patchUpdateACart(cart,json);
    }

    //Negative Case 2
    @Given("Patch update a cart with exceed parameter id {int} and valid body json")
    public void patchUpdateACartWithExceedParameterIdAndValidBodyJson(int cart) {
        File json = new File(Constants.JSON_REQUEST+"PutUpdateACartWithValidParamAndValidBody.json");
        cartsAPI.putUpdateACart(cart,json);
    }
}
