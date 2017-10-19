package ru.itpark;

public class HumansRepository {
    private Human humans[];
    private int count;

    public HumansRepository() {
        this.humans = new Human[10];
        this.count = 0;
    }

    public void save(Human human) {
        this.humans[count] = human;
        count++;
        human.setId(count - 1);
    }
}
