/*
package de.schulte.smartbar.backoffice.api;


import de.schulte.smartbar.backoffice.api.categories.CategoriesService;
import de.schulte.smartbar.backoffice.api.categories.Category;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class CategoriesResourceTest {

    @InjectMock
    CategoriesService categoriesServiceMock;

    @BeforeEach
    void setup() {
        final Category category = new Category();
        category.setName("Mock");
        Mockito.when(categoriesServiceMock.listAll()).thenReturn(List.of(category));
    }
    @Test
    public void getsListOfCategories() {

        final Response resonse = given()
                .when().get("/categories")
                .then().statusCode(200)
                .extract().response();
        JsonPath jsonPath = resonse.jsonPath();
        Assertions.assertEquals("Mock", jsonPath.getString("[0].name"));
    }

}
*/
