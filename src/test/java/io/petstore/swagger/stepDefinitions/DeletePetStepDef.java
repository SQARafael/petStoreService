package io.petstore.swagger.stepDefinitions;
/*
 * @(#) DeletePetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.petstore.swagger.questions.pet.DeleteResponse;
import io.petstore.swagger.questions.pet.PutDataResponse;
import io.petstore.swagger.tasks.pet.DeletePetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class DeletePetStepDef {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://petstore.swagger.io/v2");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
    @When("I consume the endpoint {string} and I send the id {string}")
    public void iConsumeTheEndpointAndISendTheId(String endPoint, String id) {
        user.attemptsTo(
                DeletePetTask.on(id,endPoint)
        );

    }
    @Then("I can validate the message {string}")
    public void iCanValidateTheMessage(String message) {
        String x = DeleteResponse.was().answeredBy(user).getType();

        user.should(
                seeThat(
                        "The server response was",
                        res-> DeleteResponse.was().answeredBy(user).getMessage(),
                        equalTo(message)
                )
        );

    }
}
