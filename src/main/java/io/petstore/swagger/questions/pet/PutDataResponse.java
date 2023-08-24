package io.petstore.swagger.questions.pet;
/*
 * @(#) PutDataResponse.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.PetModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PutDataResponse implements Question<PetModel> {
    @Override
    public PetModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PetModel.class);
    }

    public static PutDataResponse was(){
        return new PutDataResponse();
    }
}
