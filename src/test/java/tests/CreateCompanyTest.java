package tests;

import models.createUser.response.CreateUserResponse;
import models.doRegister.response.DoRegisterResponse;
import models.randomUserExample.response.RandomUserResponse;
import org.junit.jupiter.api.Test;
import steps.ExampleStep;
import steps.UserSteps;

import static steps.UserSteps.generateEmail;

public class CreateCompanyTest {

    @Test
    public void getUserTest(){
        UserSteps userSteps = new UserSteps();
        userSteps.getUser("someUserOne1@mail.com");
        DoRegisterResponse doRegisterResponse = userSteps.doRegister(generateEmail(), "megaName1234", "1234");
        String ownerEmail = doRegisterResponse.getEmail();
        CreateUserResponse createUserResponse = userSteps.createUser(generateEmail(), "megaUser3211", "Dota 2");
        String userEmail = createUserResponse.getEmail();

        System.out.println(userEmail);
    }
    
}
