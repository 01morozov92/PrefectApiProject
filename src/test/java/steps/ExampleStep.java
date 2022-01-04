package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import lombok.SneakyThrows;
import models.randomUserExample.response.RandomUserResponse;

public class ExampleStep {

    @Step("Step")
    public RandomUserResponse getSomeThing() {
        //Отправка запроса с помощью библиотеки RestAssured
        return RestAssured.given()
                //Тип отправляемых данных JSON
                .contentType(ContentType.JSON)
                //метод запроса - GET, а эндпоинт - https://randomuser.me/api/
                .get("https://randomuser.me/api/")
                //Тогда
                .then()
                //Код ответа 200 тоесть ОК. Бывают 400ые(вина на стороне клиента) и 500ые(упал сервер)
                .statusCode(200)
                .extract().as(RandomUserResponse.class);
    }
}
