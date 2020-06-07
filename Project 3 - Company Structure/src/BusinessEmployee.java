public abstract class BusinessEmployee extends Employee {
    private double bonusBudget; //maybe this variable should not be private!

    public BusinessEmployee(String name){
        super(name, 50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + bonusBudget + ".";
    }
}