package ExExceptionFixacao2.model.entities;

import ExExceptionFixacao2.model.exceptions.PaymentException;

public abstract class Employee {
    private String name;
    private Double baseSalary;

    public Employee() {
    }

    public Employee(String name, Double baselineSalary) {
        this.name = name;
        this.baseSalary = baselineSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public abstract double payment() throws PaymentException;
}
