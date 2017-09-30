package ru.itpark;

public class ArrayList {
    // константа - в коде уже изменить не получится
    private final int INITIAL_SIZE = 100;
    // поле - хранилище данных
    private int elements[];
    // количество элементов массива
    private int count;

    public ArrayList() {
        elements = new int[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Добавить элемент в конец
     * @param element
     */
    public void add(int element) {
        if (count < elements.length) {
            elements[count] = element;
            count++;
        } else {
            // TODO: увеличение размера массива
            System.err.println("Нет места");
        }
    }

    /**
     * Добавить элемент в начало списка, со сдвигом вправо
     * @param element
     */
    public void addToBegin(int element) {

    }

    /**
     * Вставить элемент в заданную позицию со сдвигом
     * @param element сам элемент
     * @param index индекс, куда надо вставить
     */
    public void insert(int element, int index) {

    }

    /**
     * Получить элемент по индексу
     * @param index
     * @return сам элемент по заданному индексу
     */
    public int get(int index) {
        return -1;
    }

    /**
     * Заменить элемент в заданной позиции новым элементом
     * @param index
     * @param element
     */
    public void replace(int index, int element) {

    }

    public void sort() {

    }

    public void reverse() {

    }

    public void remove(int index) {

    }

    /**
     * Вернуть индекс элемента, если элемента нет = -1
     * @param element
     * @return
     */
    public int find(int element) {
        return -1;
    }
}
