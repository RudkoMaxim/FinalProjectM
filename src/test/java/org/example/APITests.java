package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

    @Test
    public void getTestOpenUrl(){
        given().log().all().contentType(ContentType.JSON).headers("Content-Type","application/json").headers("Accept","*/*")
                .when().get("https://megatop.by/")
                .then().statusCode(200);
    }
    @Test
    public void getTestSearchByModelId() {
        given().log().all().contentType(ContentType.JSON)
                .when().get("https://megatop.by/api/v1/search?query=0797000405&device=desktop")
                .then().statusCode(200)
                .body("products[0].name", equalTo("Кроссовки X-Plode 0797000405"));
    }
    @Test
    public void postTestLoginNegative(){
        File loginFile= new File("src/test/java/resources/json/incorrectLogin.json");
        given().log().all().contentType(ContentType.JSON).body(loginFile)
                .when().post("https://admin.megatop.by/api/v1/user/login")
                .then().statusCode(422)
                .body("status", equalTo("error"))
                .body("message", equalTo("Вы ввели неверный номер телефона и/или пароль"));

    }
    @Test
    public void postTestPasswordNegative(){
        File loginFile= new File("src/test/java/resources/json/incorrectPassword.json");
        given().log().all().contentType(ContentType.JSON).body(loginFile)
                .when().post("https://admin.megatop.by/api/v1/user/login")
                .then().statusCode(422)
                .body("status", equalTo("error"))
                .body("message", equalTo("Вы ввели неверный номер телефона и/или пароль"));

    }
    @Test
    public void postTestPositive(){
        File loginFile= new File("src/test/java/resources/json/correctLoginAndPassword.json");
        given().log().all().contentType(ContentType.JSON).body(loginFile)
                .when().post("https://admin.megatop.by/api/v1/user/login")
                .then().statusCode(200)
                .body("status", equalTo("success"));
    }
}
