public abstract class Employee {
    private String name;
    private double baseSalary;
    private int employeeID;
    private Employee Manager;
    private double bonus;
    private static int numberOfEmployees;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        numberOfEmployees++;
        employeeID = numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getManager(){
        return Manager;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Employee other){
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString(){
        return (this.employeeID + " " + this.name);
    }

    abstract String employeeStatus();
}
