package io.petstore.swagger.questions.pet;
/*
 * @(#) DeleteResponse.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.responseDelete.PetModelDelete;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class DeleteResponse implements Question<PetModelDelete> {
    @Override
    public PetModelDelete answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PetModelDelete.class);
    }

    public static DeleteResponse was(){
        return new DeleteResponse();
    }
}
