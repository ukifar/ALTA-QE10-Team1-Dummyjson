package starter.dummyjson.StepDef.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI;
import static org.hamcrest.Matchers.equalTo;

public class SearchProductsStepDef {

    @Steps
    ProductsAPI productsAPI;

    @Given("Search products with valid attribute {}")
    public void searchProductsWithValidAttribute(String search) {
        productsAPI.searchProducts(search);
    }

    @When("Send search products")
    public void sendSearchProducts() {
        SerenityRest.when().get(ProductsAPI.SEARCH_PRODUCTS);
    }

    @And("Response body should include {}")
    public void responseBodyShouldInclude(String search) {
        SerenityRest.and().body("title",equalTo(search));
    }

    @Given("Search products with {string} search")
    public void searchProductsWithSearch(String search) {
        productsAPI.searchProductsBlank(search);
    }
}
