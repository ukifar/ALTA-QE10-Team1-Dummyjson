package starter.dummyjson.API;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jruby.ext.ripper.Warnings;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

public class UsersAPI {
 public static String GET_SINGLE_USER = Constants.BASE_URL+"/users/{id}";
 public static String POST_NEW_USER = Constants.BASE_URL+"/users/add";
 public static String UPDATE_USER = Constants.BASE_URL+"/users/{id}";
 public static String DELETE_USER = Constants.BASE_URL+"/users/{id}";

    @Step("Get a single user with valid parameter id")
    public void getaSingleUserWithValidParamId(int id) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID,id);
    }
    @Step("Post a new user")
    public void postNewUse (File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("PUT User")
    public void putUser (int id, File json){
        SerenityRest.given().pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete User")
    public void deleteUser (int id){
        SerenityRest.given().pathParam(DummyjsonResponses.ID,id);
    }

}
