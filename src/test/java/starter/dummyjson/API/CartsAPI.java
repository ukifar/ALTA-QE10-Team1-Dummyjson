package starter.dummyjson.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

public class CartsAPI {
    public static String GET_A_SINGLE_CART = Constants.BASE_URL+"/carts/{id}";
    public static String GET_CARTS_OF_USER = Constants.BASE_URL+"/carts/user/{id}";
    public static String POST_ADD_A_CART = Constants.BASE_URL+"/carts/add";

    @Step("Get a single cart with valid parameter id")
    public void getaSingleCartWithValidParamId(int id) {
        SerenityRest.given()
                    .pathParam(DummyjsonResponses.ID,id);
    }
    @Step("Get a single cart with invalid parameter id")
    public void getaSingleCartWithInvalidParamId(String id) {
        SerenityRest.given()
                    .pathParam(DummyjsonResponses.ID,id);
    }
    @Step("Get carts of user with valid parameter id")
    public void getCartsOfUserWithValidParamId(int id) {
        SerenityRest.given()
                    .pathParam(DummyjsonResponses.ID,id);
    }
    @Step("Get carts of user with invalid parameter id")
    public void getCartsOfUserWithInvalidParamId(String id) {
        SerenityRest.given()
                    .pathParam(DummyjsonResponses.ID,id);
    }
    @Step("Post add a cart with valid json")
    public void postAddACartWithValidJson(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

}
