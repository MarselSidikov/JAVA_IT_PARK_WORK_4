package ru.itpark;

public class Main {

    public static void main(String[] args) throws Exception {
        ChickenThread chickenThread = new ChickenThread();
        EggThread eggThread = new EggThread();

        chickenThread.start();
        eggThread.start();

        chickenThread.join();
        eggThread.join();

        DinosaurThread dinosaurThread = new DinosaurThread();
        Thread dinoThread = new Thread(dinosaurThread);
        dinoThread.start();

        new Thread(() -> {
          System.out.println("Марсель");
          System.out.println("Мега Марсель");
        }).start();

        for (int i = 0; i < 100; i++) {
          System.out.println("Человек");
        }
    }
}
