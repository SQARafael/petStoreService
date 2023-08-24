package io.petstore.swagger.stepDefinitions;
/*
 * @(#) PutPetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.petstore.swagger.tasks.pet.PutPetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PutPetStepDef {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://petstore.swagger.io/v2");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
    @When("I consume the endpoint {string} and I send the user information id {string}, Category {string} namePet {string}")
    public void iConsumeTheEndpointAndISendTheUserInformationIdCategoryNamePet(String endpoint, String id, String nameCategory, String namePet) {
        user.attemptsTo(
                PutPetTask.on(endpoint, id, nameCategory, namePet)
        );
    }
    @Then("I can validate the response server {int}")
    public void iCanValidateTheResponseServer(Integer int1) {

    }
}
