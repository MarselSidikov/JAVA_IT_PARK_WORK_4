package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Human human = Human.builder()
                .age(23)
                .height(1.85)
                .name("Marsel")
                .build();

        Human andrey = Human.builder()
                .age(19)
                .name("Andrey")
                .height(1.80)
                .isReligion(true)
                .color("White")
                .hairColor("Blond")
                .build();
    }
}
