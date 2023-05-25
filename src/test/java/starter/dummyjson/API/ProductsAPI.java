package starter.dummyjson.API;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.dummyjson.Utils.DummyjsonResponses;

import java.io.File;

import static starter.dummyjson.Utils.Constants.BASE_URL;

public class ProductsAPI {
    public static String GET_ALL_PRODUCTS = BASE_URL+"/products";
    public static String GET_ALL_PRODUCTS_INV = BASE_URL+"/{page}";
    public static String GET_SINGLE_PRODUCT = BASE_URL+"/products/{id}";
    public static String SEARCH_PRODUCTS = BASE_URL+"/products/search?q={search}";
    public static String POST_ADD_PRODUCT = BASE_URL+"/products/add";
    public static String PUT_UPDATE_PRODUCT = BASE_URL+"/products/{id}";
    public static String DELETE_PRODUCT = BASE_URL+"/products/{id}";
    public static String LIMIT_SKIP_SELECT_PRODUCTS = BASE_URL+"/products?limit={limit}&skip={skip}&select={select}";
    public static String GET_ALL_CATEGORY = BASE_URL+"/products/categories";
    public static String GET_ALL_CATEGORY_INV = BASE_URL+"/products/categori";
    public static String GET_PRODUCTS_CATEGORY = BASE_URL+"/products/category/{page}";

//    Step
    @Step("Get all products with invalid parameter page")
    public void getAllProductsInv(String page) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.PAGE, page);
    }

    @Step("Get a single product")
    public void getSingleProduct(int id) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID, id);
    }

    @Step("Get a single product with invalid id")
    public void getSingleProductInv(String id) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID, id);
    }

    @Step("Search products")
    public void searchProducts(String search) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.SEARCH, search);
    }

    @Step("Search products with blank")
    public void searchProductsBlank(String search) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.SEARCH, search);
    }

    @Step("Add a new product with valid json body")
    public void postAddProductwithValidBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add a new product with blank json body")
    public void postAddProductwithBlankBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add a new product with invalid json body")
    public void postAddProductwithInvalidBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update a product with valid id and json body")
    public void putUpdateProductValid(int id, File json) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update a product with blank json body")
    public void putUpdateProductBlank(int id, File json) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update a product with invalid json body")
    public void putUpdateProductInvalid(int id, File json) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID,id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete a product with valid id")
    public void deleteProductValid(int id) {
        SerenityRest.given().pathParam(DummyjsonResponses.ID,id);
    }

    @Step("Delete a product with invalid id")
    public void deleteProductInv(String id) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.ID, id);
    }

    @Step("Limit, skip, and select products with valid parameter page")
    public void lssProductsValid(int limit, int skip, String select) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.LIMIT,limit)
                .pathParam(DummyjsonResponses.SKIP,skip)
                .pathParam(DummyjsonResponses.SELECT,select);
    }

    @Step("Limit, skip, and select products with invalid parameter page")
    public void lssProductsInvalid(String limit, String skip, String select) {
        SerenityRest.given()
                .pathParam(DummyjsonResponses.LIMIT,limit)
                .pathParam(DummyjsonResponses.SKIP,skip)
                .pathParam(DummyjsonResponses.SELECT,select);
    }

    @Step("Get products of a category with valid parameter page")
    public void getProductsCategory(String page){
        SerenityRest.given().pathParam(DummyjsonResponses.PAGE,page);
    }
}