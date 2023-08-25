package io.petstore.swagger.tasks.pet;
/*
 * @(#) DeletePetTask.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class DeletePetTask implements Task {
    private final String id;
    private final String endPoint;

    public DeletePetTask(String id, String endPoint) {
        this.id = id;
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endPoint+"/"+id)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                        )
        );

    }

    public static DeletePetTask on(String id, String endPoint){
        return instrumented(DeletePetTask.class,id,endPoint);

    }
}
