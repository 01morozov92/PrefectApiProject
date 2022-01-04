package steps;

import core.ApplicationProperties;
import core.BaseConfig;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import models.createUser.request.CreateUserRequest;
import models.createUser.response.CreateUserResponse;
import models.doRegister.request.DoRegisterRequest;
import models.doRegister.response.DoRegisterResponse;

import java.util.Arrays;
import java.util.Collections;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class UserSteps extends BaseConfig {

    public static String generateEmail() {
        return randomAlphanumeric(5) + "@gmail.com";
    }

    @Step("Получить пользователя по email: {email}")
    public void getUser(String email) {
        String response = RestAssured.given()
                .get(ApplicationProperties.getInstance().getUrl() + email)
                .then()
                .statusCode(200)
                .extract().asString();
        System.out.println();
    }

    @Step("Регистрация владельца с параметрами: {email}, {name}, {password}")
    public DoRegisterResponse doRegister(String email, String name, String password) {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .body(DoRegisterRequest.builder()
                        .email(email)
                        .name(name)
                        .password(password)
                        .build())
                .post("doregister")

                .then()
                .statusCode(200)
                .extract().as(DoRegisterResponse.class);
    }

    @Step("Создание рядового пользователя с параметрами: {email}, {name}, {password}")
    public CreateUserResponse createUser(String email, String name, String hobby) {
        return RestAssured
                .given()
                .spec(requestSpecification())
                .body(CreateUserRequest.builder()
                        .email(email)
                        .name(name)
                        .tasks(Collections.singletonList(12))
                        .companies(Arrays.asList(36, 37))
                        .hobby(hobby)
                        .build())
                .post("createuser")

                .then()
                .statusCode(200)
                .extract().as(CreateUserResponse.class);
    }


}
