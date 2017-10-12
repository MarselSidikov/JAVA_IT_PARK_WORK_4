package ru.itpark;

public class Sphere extends ShapeInSpace implements ExtendedMovable, Scalable {
    private double radius;

    public Sphere(double x, double y, double z, double radius) {
        super(x, y, z);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void scale(double value) {
        this.radius *= value;
    }

    @Override
    public void moveByX(double x) {
        this.x = x;
    }

    @Override
    public void moveByY(double y) {
        this.y = y;
    }

    @Override
    public void moveByZ(double z) {
        this.z = z;
    }

    @Override
    public void move(double x, double y, double z) {
        super.x = x;
        super.y = y;
        super.z = z;
    }
}
