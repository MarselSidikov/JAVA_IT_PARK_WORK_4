package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Movable box = new Box(1,2,3,4,5,6);
        Movable sphere = new Sphere(1,2,3,4);
        Movable movables[] = {box, sphere};

        ShapeInSpace shapeInSpace = new Point(1,2,3);
        ShapeInSpace boxAsShapeInSpace = new Box(4,5,6,7,8,9);
    }
}
