package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Field field = new Field.Builder()
                .setModificaters(List.of(Modificator.PRIVATE))
                .setName("name")
                .setValue("Arian")
                .setType(Type.STRING)
                .build();

        System.out.println(field.toString());
    }
}