public abstract class TechnicalEmployee extends Employee{
    private int checkIn;

    public TechnicalEmployee(String name){
        super(name, 75000);
    }

    public String employeeStatus(){
        return this.toString() + " has " + checkIn + " successful check ins.";
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }
}