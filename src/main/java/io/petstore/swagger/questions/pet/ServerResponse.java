package io.petstore.swagger.questions.pet;
/*
 * @(#) ServerResponse.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class ServerResponse implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {


        return SerenityRest.lastResponse().statusCode();
    }

    public static Question was(){
        return new ServerResponse();
    }
}
