package ExExceptionFixacao2;

import ExExceptionFixacao2.model.entities.Effective;
import ExExceptionFixacao2.model.entities.Employee;
import ExExceptionFixacao2.model.entities.Outsourced;
import ExExceptionFixacao2.model.exceptions.PaymentException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.printf("How much Employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Base salary: ");
            double baseSalary = sc.nextDouble();
            System.out.print("the employee is outsourced or effective (o/e): ");
            char ch = sc.next().charAt(0);
            if (ch == 'o' || ch == 'O') {
                System.out.println("Enter the extra hours: ");
                int extraHours = sc.nextInt();
                System.out.println("Enter the value per hour: ");
                double valuePerHour = sc.nextDouble();
                Employee employee = new Outsourced(name, baseSalary, extraHours, valuePerHour);
                employees.add(employee);
            } else if (ch == 'e' || ch == 'E') {
                System.out.println("Enter your department: ");
                String department = sc.next();
                Employee employee = new Effective(name ,  baseSalary, department);
                employees.add(employee);
            }
        }

        System.out.println("PAYMENTS: ");
        double sum = 0.0;
        for (Employee emp : employees) {
            try {
                System.out.println(emp.getName() + ": $ " + String.format("%.2f", emp.payment()));
                sum += emp.payment();
            } catch (PaymentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("TOTAL: $ " + String.format("%.2f", sum));


        sc.close();
    }
}
