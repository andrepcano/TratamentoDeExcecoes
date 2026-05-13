package ExExceptionFixacao2.model.entities;

import ExExceptionFixacao2.model.exceptions.PaymentException;

public class Effective extends Employee {
    private String department;

    public Effective() {
        super();
    }

    public Effective(String name, Double baselineSalary, String department) {
        super(name, baselineSalary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double payment() throws PaymentException {
        double result =  getBaseSalary() + getBaseSalary() * 0.20; //bonus fixo de 20%
        if (result < 0) {
            throw new PaymentException("Não pode ser 0!");
        }

        return result;
    }
}
