package starter.dummyjson.StepDef.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.CartsAPI;

public class DeleteACartStepDef {
    @Steps
    CartsAPI cartsAPI;

    //Positive Case 1
    @Given("Delete a cart with valid parameter id {int}")
    public void deleteACartWithValidParameterId(int id) {
        cartsAPI.deleteACartWithIntParam(id);
    }
    @When("Send request delete a cart")
    public void sendRequestDeleteACart() {
        SerenityRest.when().delete(CartsAPI.DELETE_A_CART);
    }

    //Negative Case 1
    @Given("Delete a cart with invalid parameter id {string}")
    public void deleteACartWithInvalidParameterId(String id) {
        cartsAPI.deleteACartWithStringParam(id);
    }

    //Negative Case 2
    @Given("Delete a cart with exceed parameter id {int}")
    public void deleteACartWithExceedParameterId(int id) {
        cartsAPI.deleteACartWithIntParam(id);
    }

    //Negative Case 3
    @Given("Delete a cart with blank parameter id {string}")
    public void deleteACartWithBlankParameterId(String id) {
        cartsAPI.deleteACartWithStringParam(id);
    }
}
