package ExExceptionFixacao3.model.entities;

import ExExceptionFixacao3.model.exceptions.InvalidMeasureException;

public class Triangle extends Shape {
    private Double base;
    private Double height;

    public Triangle() {
        super();
    }


    public Triangle(String color, Double base, Double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double area() throws InvalidMeasureException {
        if (base <= 0 || height <= 0) {
            throw new InvalidMeasureException("The number can't be negative");
        }
        return (base * height) / 2;
    }
}
