package ExExceptionFixacao3.model.entities;

import ExExceptionFixacao3.model.exceptions.InvalidMeasureException;

public abstract class Shape {
    private String color;

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public abstract double area() throws InvalidMeasureException;
}
