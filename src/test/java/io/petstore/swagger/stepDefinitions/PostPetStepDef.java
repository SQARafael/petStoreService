package io.petstore.swagger.stepDefinitions;
/*
 * @(#) PostPetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.en.*;
import io.petstore.swagger.tasks.pet.PostPetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PostPetStepDef {
    Actor user= Actor.named("user");
    @When("I consume the endpoint {string} and I send the user information id {string}, nameCategory {string} namePet {string}")
    public void setInfoPet(String endpoint, String id, String nameCategory, String namePet) {

        user.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));

        user.attemptsTo(
                PostPetTask.on(endpoint, id, nameCategory, namePet)
        );

    }
    @Then("I can validate the response service {int}")
    public void iCanValidateTheResponseService(Integer resServer) {

    }
}
