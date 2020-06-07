public abstract class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee(String name){
        super(name, 50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + bonusBudget;
    }
}
