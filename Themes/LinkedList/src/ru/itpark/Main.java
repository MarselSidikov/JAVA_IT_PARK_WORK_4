package ru.itpark;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Fourth");
        linkedList.add("Fifth");
        linkedList.addToBegin("Zeroth");

        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(0));
        int i = 0;
    }
}
