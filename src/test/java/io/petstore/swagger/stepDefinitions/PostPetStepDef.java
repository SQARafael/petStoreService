package io.petstore.swagger.stepDefinitions;
/*
 * @(#) PostPetStepDef.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.en.*;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PostPetStepDef {
    @When("I consume the endpoint {string} and I send the user information id {string}, nameCategory {string} namePet {string}")
    public void setInfoPet(String endpoint, String id, String nameCategory, String namePet) {

    }
    @Then("I can validate the response service {int}")
    public void iCanValidateTheResponseService(Integer resServer) {

    }
}
