package io.petstore.swagger.questions.pet;
/*
 * @(#) BuildDataPet.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.Category;
import io.petstore.swagger.models.pet.PetModel;
import io.petstore.swagger.models.pet.Tag;
import io.petstore.swagger.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class BuildDataPet implements Question<PetModel> {



    @Override
    public PetModel answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);
        List<Tag> tags= new ArrayList<>();
        Category category= Category.builder()
                .id(0)
                .name(data.get("Categoria"))
                .build();

        Tag tag= Tag.builder()
                .id(1)
                .name("Puppy")
                .build();
        tags.add(tag);

        PetModel petModel= PetModel.builder()
                .id(Long.parseLong(data.get("ID")))
                .category(category)
                .tags(tags)
                .name(data.get("Mascota"))
                .status("available")
                .build();
        return petModel;
    }

    public static BuildDataPet was(){
        return  new BuildDataPet();
    }
}
