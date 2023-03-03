package Utils;

import Config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BooksApiUtil {
    private static Response getResponse() {
        return given()
                .baseUri(Configuration.API_BOOK_URL)
                .basePath(Configuration.API_BOOK_ENDPOINT)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public static List<String> getListOfBooks() {
        return getResponse().body().jsonPath().get("books.title");
    }
}