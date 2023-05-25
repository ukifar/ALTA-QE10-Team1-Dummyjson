package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.Constants;

import java.io.File;

public class GetAllCategoryStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Get all products category with valid parameter page")
    public void getAllProductsCategoryWithValidParameterPage() {
        SerenityRest.given().get(ProductsAPI.GET_ALL_CATEGORY);
    }

    @And("Validate get all products category JSON Schema")
    public void validateGetAllProductsCategoryJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"GetAllProductsCategory.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get all products category with invalid parameter page")
    public void getAllProductsCategoryWithInvalidParameterPage() {
        SerenityRest.given().get(ProductsAPI.GET_ALL_CATEGORY_INV);
    }
}
