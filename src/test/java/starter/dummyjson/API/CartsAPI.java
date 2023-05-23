package starter.dummyjson.API;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

public class CartsAPI {
    public static String GET_A_SINGLE_CART = Constants.BASE_URL+"/carts/{id}";


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


}
