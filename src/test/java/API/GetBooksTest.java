package API;

import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers;

public class GetBooksTest {

    private final String request_url = "https://demoqa.com/BookStore/v1/Books";


    @Test(description = "GET")
    public void getTittleOfBooks(){
        List<BooksTittle> books = given()
                .when()
                .contentType(ContentType.JSON)
                .get(request_url)
                .then().log().all()
                .extract().body().jsonPath().getList("title" , BooksTittle.class);
        int i = 0;
        books.forEach(x->System.out.println(x.getTitle()));
        List<String> tittle = books.stream().map(BooksTittle::getTitle).collect(Collectors.toList());
        //System.out.println(tittle);
    }
}
