package starter.dummyjson.StepDef.Products;

//import com.sun.deploy.util.DeployUIManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import starter.dummyjson.Utils.DummyjsonResponses;
import static org.hamcrest.Matchers.equalTo;

public class GetProductCategoryStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Get products of a category with valid parameter page {}")
    public void getProductsOfACategoryWithValidParameterPage(String page) {
        productsAPI.getProductsCategory(page);
    }

    @When("Send Get products of a category")
    public void sendGetProductsOfACategory() {
        SerenityRest.when().get(ProductsAPI.GET_PRODUCTS_CATEGORY);
    }

    @And("Response body category should be {}")
    public void responseBodyCategoryShouldBe(String page) {
        SerenityRest.and().body("products.category", equalTo(page));
    }

    @Given("Get products of a category with {string} parameter page")
    public void getProductsOfACategoryWithParameterPage(String page) {
        productsAPI.getProductsCategory(page);
    }

    @Given("Get products of a category with invalid parameter page {}")
    public void getProductsOfACategoryWithInvalidParameterPage(String page) {
        productsAPI.getProductsCategory(page);
    }
}
