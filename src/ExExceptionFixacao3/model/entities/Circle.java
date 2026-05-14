package ExExceptionFixacao3.model.entities;

import ExExceptionFixacao3.model.exceptions.InvalidMeasureException;

public class Circle extends Shape {
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() throws InvalidMeasureException {
        if (radius <= 0) {
            throw new InvalidMeasureException("The number can't be negative");
        }
        return Math.PI * radius * radius;
    }

}
