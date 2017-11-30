package ru.itpark;

public class Main {

    public static void main(String[] args) {
      ComponentsFactory factory = new ComponentsFactory();

      MessageRenderer renderer = factory.messageRenderer();

      renderer.render();
    }
}
