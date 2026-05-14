package ExExceptionFixacao3.model.entities;

import ExExceptionFixacao3.model.exceptions.InvalidMeasureException;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    public Rectangle() {
        super();
    }


    public Rectangle(String color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double area() throws InvalidMeasureException {
        if (width <= 0 || height <= 0) {
            throw new InvalidMeasureException("The number can't be negative");
        }
        return width * height;
    }
}
