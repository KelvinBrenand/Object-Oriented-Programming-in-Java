import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    ArrayList<SoftwareEngineer> reports = new ArrayList<>();
    private int headCount;

    public TechnicalLead(String name){
        super(name);
        this.setBaseSalary(getBaseSalary()*1.3);
        headCount = 4;
    }

    public boolean hasHeadCount(){
        return reports.size() < headCount;
    }
    public boolean addReport(SoftwareEngineer e){
        if (hasHeadCount()){
            reports.add(e);
            return true;
        }
        return false;
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        return reports.contains(e) && e.getCodeAccess();
    }

    public boolean requestBonus(Employee e, double bonus){
        //depende de bussinessLead
    }

    public String getTeamStatus(){
        if (reports.size() == 0){
            return this.toString() + " has " + this.getCheckIn() + " successful check ins and no direct reports yet";
        }else {
            String s = this.toString() + " has " + this.getCheckIn() + "successful check ins and is managing: /n";
            for (SoftwareEngineer report : reports) {
                s += report.toString() + " has " + report.getSuccessfulCheckIns() + "successful check ins.\n";
            }
            return s;
        }
    }
}