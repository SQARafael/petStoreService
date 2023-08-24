package io.petstore.swagger.questions.pet;
/*
 * @(#) BuildDataPet.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.Category;
import io.petstore.swagger.models.pet.PetModel;
import io.petstore.swagger.models.pet.Tag;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class BuildDataPet implements Question<PetModel> {
    private final String id;
    private final String nameCategory;
    private final String namePet;

    public BuildDataPet(String id, String nameCategory, String namePet) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.namePet = namePet;
    }

    @Override
    public PetModel answeredBy(Actor actor) {
        List<Tag> tags= new ArrayList<>();
        Category category= Category.builder()
                .id(0)
                .name(nameCategory)
                .build();

        Tag tag= Tag.builder()
                .id(1)
                .name("Puppy")
                .build();
        tags.add(tag);

        PetModel petModel= PetModel.builder()
                .id(Long.parseLong(id))
                .category(category)
                .tags(tags)
                .name(namePet)
                .status("available")
                .build();
        return petModel;
    }

    public static BuildDataPet was(String id, String nameCategory, String namePet){
        return  new BuildDataPet(id,nameCategory,namePet);
    }
}
