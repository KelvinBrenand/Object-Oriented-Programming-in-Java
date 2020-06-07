public abstract class Employee {
    private String name;
    private double baseSalary;
    private int employeeID;
    private int bonus;
    private Employee Manager;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID = employeeID + 1;
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

    public boolean equals(Employee other){
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString(){
        return (this.employeeID + " " + this.name);
    }

    abstract String employeeStatus();
}