package io.petstore.swagger.stepDefinitions;
/*
 * @(#) PostPetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.petstore.swagger.questions.pet.ServerResponse;
import io.petstore.swagger.tasks.pet.PostPetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PostPetStepDef {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://petstore.swagger.io/v2");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the endpoint {string} and I send the user information id {string}, nameCategory {string} namePet {string}")
    public void setInfoPet(String endpoint, String id, String nameCategory, String namePet) {
        user.attemptsTo(
                PostPetTask.on(endpoint)
        );

    }
    @Then("I can validate the response service {int}")
    public void iCanValidateTheResponseService(Integer resServer) {
        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(resServer)
                )
        );

    }
}
