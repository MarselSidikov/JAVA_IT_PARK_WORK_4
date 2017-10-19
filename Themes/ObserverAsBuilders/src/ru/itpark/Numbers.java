package ru.itpark;

public class Numbers {
    private int numbers[] = new int[10];
    private int count = 0;

    private Numbers(Builder builder) {
        this.numbers = builder.numbers;
        this.count = builder.count;
    }

    public static class Builder {
        private int numbers[] = new int[10];
        private int count = 0;

        public Builder add(int number) {
            this.numbers[count] = number;
            count++;
            return this;
        }

        public Numbers build() {
            return new Numbers(this);
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i] + " ");
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
