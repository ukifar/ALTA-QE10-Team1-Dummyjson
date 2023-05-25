package starter.dummyjson.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI;
import starter.dummyjson.Utils.Constants;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UserStepDef {
    @Steps
    UsersAPI usersAPI;
    @Given("Get single  with valid id {int}")
    public void getSingleWithValidId(int id) {
     usersAPI.getaSingleUserWithValidParamId(id);
    }

    @When("Send request get single users")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(UsersAPI.GET_SINGLE_USER);
    }
    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and().body(DummyjsonResponses.ID,equalTo(id));
    }

    @And("Validate json schema get single users with valid parameter id")
    public void validateJsonSchemaGetSingleUsersWithValidParameterId() {
        File json = new File(Constants.JSON_SCHEMA+"GetSingleUserWithValidParam.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.JSON_REQUEST+"POSTUser.json");
        usersAPI.postNewUse(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() { SerenityRest.when().post(UsersAPI.POST_NEW_USER);
    }

    @Then("Status Code should be {int} OK")
    public void statusCodeShouldBeOK(int created) { SerenityRest.then().statusCode(created);
    }

    @And("Response body fistName was {string} lastName was {string} age was {string}")
    public void responseBodyFistNameWasLastNameWasAgeWas(String firstName, String lastName, String age) {
    SerenityRest.and()
            .body(DummyjsonResponses.FIRSTNAME,equalTo(firstName))
            .body(DummyjsonResponses.LASTNAME,equalTo(lastName))
            .body(DummyjsonResponses.AGE,equalTo(age));
    }

    @And("Validate post create user JSON Schema")
    public void validatePostCreateUserJSONSchema() {
        File json = new File (Constants.JSON_SCHEMA+"PostUserValidParam.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create new user with invalid parameter")
    public void postCreateNewUserWithInvalidParameter() {
        File json = new File(Constants.JSON_REQUEST+"Blank.json");
        usersAPI.postNewUse(json);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int err) {
        SerenityRest.then().statusCode(err);
    }
    @And("Validate post create new user JSON Schema")
    public void validatePostCreateNewUserJSONSchema() {
        File json = new File (Constants.JSON_SCHEMA+"PostUserBlank.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("PUT user with valid json and id {int}")
    public void putUserWithValidJsonAndId(int id) {
        File json = new File(Constants.JSON_REQUEST+"PUTuser.json");
        usersAPI.putUser(id, json);}

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(UsersAPI.UPDATE_USER);
    }
    @And("Response body lastName was {string}")
    public void responseBodyLastNameWas(String lastName) {
        SerenityRest.and()
                .body(DummyjsonResponses.LASTNAME,equalTo(lastName));
    }
    @Given("Put user with invalid id {int}")
    public void putUserWithInvalidId(int id) {
        SerenityRest.given().pathParam(DummyjsonResponses.ID,id);
    }
    @And("Validate put invalid JSON Schema")
    public void validatePutInvalidJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"PutUserEror.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Get a single with invalid id {int}")
    public void getASingleWithInvalidId(int id) {
        usersAPI.getaSingleUserWithValidParamId(id);
    }
    @When("Send request get single users invalid")
    public void sendRequestGetSingleUsersInvalid() {
        SerenityRest.when().get(UsersAPI.GET_SINGLE_USER);
    }
    @Then("Status Code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int eror) {
        SerenityRest.then().statusCode(eror);
    }
    @And("Validate json schema get single users with invalid parameter id")
    public void validateJsonSchemaGetSingleUsersWithInvalidParameterId() {
        File json = new File(Constants.JSON_SCHEMA+"GetSingleInvalidParam.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        SerenityRest.given().pathParam(DummyjsonResponses.ID,id);
    }
    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().get(UsersAPI.DELETE_USER);
    }
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id) {
        SerenityRest.given().pathParam(DummyjsonResponses.ID,id);
    }
}



