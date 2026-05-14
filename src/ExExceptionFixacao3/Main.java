package ExExceptionFixacao3;

import ExExceptionFixacao3.model.entities.Circle;
import ExExceptionFixacao3.model.entities.Rectangle;
import ExExceptionFixacao3.model.entities.Shape;
import ExExceptionFixacao3.model.entities.Triangle;
import ExExceptionFixacao3.model.exceptions.InvalidMeasureException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Shape> list = new ArrayList<>();

        System.out.println("How much shapes you want to use?");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the color: ");
            String color = sc.next();
            System.out.print("Please enter the shape you want to use (Circle/Rectangle/Triangle): ");
            char ch =  sc.next().charAt(0);
            if (ch == 'c' || ch == 'C') {
                System.out.print("Enter the radius: ");
                double radius = sc.nextDouble();
                Shape shape = new Circle(color, radius);
                list.add(shape);
            } else if (ch == 'r' || ch == 'R') {
                System.out.println("Enter the width: ");
                double width = sc.nextDouble();
                System.out.println("Enter the height: ");
                double height = sc.nextDouble();
                Shape shape = new Rectangle(color, width, height);
                list.add(shape);
            } else if (ch == 't' || ch == 'T') {
                System.out.println("Enter the base: ");
                double base = sc.nextDouble();
                System.out.println("Enter the height: ");
                double height = sc.nextDouble();
                Shape shape = new Triangle(color, base, height);
                list.add(shape);
            }
        }

        System.out.println("AREAS: ");
        double highestArea = 0;
        for (Shape shape : list) {
            try {
                double areaTot = shape.area();
                System.out.println(shape.getColor() + ": " + String.format("%.2f", areaTot));
                if (areaTot > highestArea) {
                    highestArea = areaTot;
                }
            } catch (InvalidMeasureException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Highest area: " + String.format("%.2f", highestArea));
        

        sc.close();
    }
}
