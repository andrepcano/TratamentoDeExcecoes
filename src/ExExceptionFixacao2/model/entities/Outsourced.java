package ExExceptionFixacao2.model.entities;

public class Outsourced extends Employee{
    private Integer extraHours;
    private Double valuePerHour;

    public Outsourced() {
        super();
    }

    public Outsourced(String name, Double baseSalary, Integer extraHours, Double valuePerHour) {
        super(name, baseSalary);
        this.extraHours = extraHours;
        this.valuePerHour = valuePerHour;
    }

    public Integer getExtraHours() {
        return extraHours;
    }


    public Double getValuePerHour() {
        return valuePerHour;
    }

    @Override
    public double payment() {
        return getBaseSalary() + extraHours * valuePerHour * 1.5;
    }
}
