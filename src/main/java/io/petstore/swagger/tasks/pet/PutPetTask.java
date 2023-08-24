package io.petstore.swagger.tasks.pet;
/*
 * @(#) PutPetTask.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.PetModel;
import io.petstore.swagger.questions.pet.BuildDataPet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class PutPetTask implements Task {
    private final String endPoint;
    private final String id;
    private final String nameCategory;
    private final String namePet;

    public PutPetTask(String endPoint, String id, String nameCategory, String namePet) {
        this.endPoint = endPoint;
        this.id = id;
        this.nameCategory = nameCategory;
        this.namePet = namePet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PetModel petInfo = actor.asksFor(BuildDataPet.was(id, nameCategory, namePet));

        actor.attemptsTo(
                Put.to(endPoint)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .body(petInfo)
                        )
        );

    }

    public static Performable on(String endPoint, String id, String nameCategory, String namePet){
        return instrumented(PutPetTask.class,endPoint,id,nameCategory,namePet);
    }
}
