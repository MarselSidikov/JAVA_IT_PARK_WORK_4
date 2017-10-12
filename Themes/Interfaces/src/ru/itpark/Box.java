package ru.itpark;

public class Box extends ShapeInSpace implements Movable, Scalable {
    private double length;
    private double height;
    private double width;

    public Box(double x, double y, double z, double length, double height, double width) {
        super(x, y, z);
        if (length > 0) {
            this.length = length;
        } else this.length = 1;
        if (height > 0) {
            this.height = height;
        } else this.height = 1;
        if (width > 0) {
            this.width = width;
        } else this.width = 1;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public void move(double x, double y, double z) {
        super.x = x;
        super.y = y;
        super.z = z;
    }

    @Override
    public void scale(double value) {
        this.length *= value;
        this.height *= value;
        this.width  *= value;
    }
}
