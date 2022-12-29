import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;

public class testGet {
    @Test
    void test1(){
      Response response =  RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString()); //respons'a ait String değeri yazdır
        System.out.println(response.getBody());  //respons'a ait Body içinde yer alanları yazdır
        System.out.println(response.getStatusCode());  //respons'a ait status code yazdır
        System.out.println(response.getStatusLine());  //responsa'a ait protocol ve status kod yazdır
        System.out.println(response.getHeader(("Content-type")));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);



    }

    @Test
    void test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7));



    }


}
