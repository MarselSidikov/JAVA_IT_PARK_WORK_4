package ru.itpark;

public class Main {

    public static void main(String[] args) {
        HumansRepository humansRepository = new HumansRepository();
        Human human = new Human("Marsel");
        System.out.println(human.getId());
        humansRepository.save(human);
        System.out.println(human.getId());

    }
}
