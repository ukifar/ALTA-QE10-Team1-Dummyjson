package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.dummyjson.Utils.Constants;

import java.io.File;

public class ConstantsStepDef {
//    200 OK
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

//    404 Not Found
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

//    400 Bad Request
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badReq) {
        SerenityRest.then().statusCode(badReq);
    }

//    201 Created
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

//    Error Message
    @And("Validate error message JSON Schema")
    public void validateErrorMessageJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"ErrorMessage.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
