import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    ArrayList<Accountant> reports = new ArrayList<>();
    private int headCount;

    public BusinessLead(String name){
        super(name);
        this.setBaseSalary(getBaseSalary()*2);
        headCount = 10;
    }

    public boolean hasHeadCount(){
        return reports.size() < headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            reports.add(e);
            this.setBonusBudget(this.getBonusBudget() + 1.1*e.getBaseSalary());
            e.supportTeam(supportTeam);
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus){
        if (bonus < this.getBonusBudget()){
            e.setBonus(bonus);
            this.setBonusBudget(this.getBonusBudget() - bonus);
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus){
        for(Accountant report : reports){
            if (report.getTeamSupported() == e.getManager()){
                if (bonus < report.getBonusBudget()){
                    e.setBonus(bonus);
                    report.setBonusBudget(report.getBonusBudget() - bonus);
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus(){

        if (reports.size()==0){
            return this.employeeStatus() + " and no direct reports yet";
        } else {
            String teamStatus = this.employeeStatus() + " and is managing: \n";
            for (Accountant report : reports) {
                teamStatus += (report.employeeStatus() + "\n");
            }
            return teamStatus;

        }
    }
}
