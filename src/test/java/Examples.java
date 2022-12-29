import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {

    //@Test
    public void testGet(){


        baseURI="http://localhost:3000/";
        given().
                param("name" , "Automation").
                get("/subjects").
                then().statusCode(200).
                log().all();


    }

    //@Test
    public void testPost(){

        JSONObject request = new JSONObject();

        request.put("firstName" , "Eyup");
        request.put("lastName" , "Sana");
        request.put("subjectId", 1);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type" , "application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();

    }

    //@Test
    public void testPatch(){

        JSONObject request = new JSONObject();

        request.put("lastName" , "Sanane");

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type" , "application/json").
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();

    }
    //@Test
    public void testPut(){

        JSONObject request = new JSONObject();

        request.put("firstName" , "Garo");
        request.put("lastName" , "K9");
        request.put("subjectId", 1);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type" , "application/json").
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();

    }
    @Test
    public void testDelete(){


        baseURI="http://localhost:3000/";
        when().
                delete("/users/4").
                then().
                statusCode(200);


    }




}
