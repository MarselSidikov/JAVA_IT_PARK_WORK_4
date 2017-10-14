package ru.itpark;

public class Human {
    private String name;
    private int age;
    private String color;
    private double height;
    private double weight;
    private boolean isReligion;
    private String hairColor;

    private Human(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.color = builder.color;
        this.height = builder.height;
        this.weight = builder.weight;
        this.isReligion = builder.isReligion;
        this.hairColor = builder.hairColor;
    }

    public static Builder builder() {
        return new Builder();
    }
    // вложенный класс
    public static class Builder {
        private String name;
        private int age;
        private String color;
        private double height;
        private double weight;
        private boolean isReligion;
        private String hairColor;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder height(double height) {
            this.height = height;
            return this;
        }
        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }
        public Builder isReligion(boolean isReligion) {
            this.isReligion = isReligion;
            return this;
        }

        public Builder hairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }


}
