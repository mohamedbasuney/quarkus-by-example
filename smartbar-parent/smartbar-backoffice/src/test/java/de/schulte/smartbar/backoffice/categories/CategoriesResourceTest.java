package de.schulte.smartbar.backoffice.categories;

import de.schulte.smartbar.backoffice.api.categories.Category;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
//@Disabled
public class CategoriesResourceTest {

    @Test
    @TestSecurity(authorizationEnabled = false,user = "bob" , roles = {"admin"})
    void getsListOfCategoriesAdminUsers(){
        final Response response = given()
                .when().get("/categories")
                .then().statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();
        Assertions.assertEquals("Coffee", jsonPath.get("[0].name"));
    }

    @Test
    @TestSecurity(authorizationEnabled = true,user = "alice" , roles = {"user"})
    void getsListOfCategoriesNonAdminUsers(){
        given()
                .when().get("/categories")
                .then().statusCode(403);
    }
}
