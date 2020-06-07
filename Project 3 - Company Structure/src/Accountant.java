public class Accountant extends BusinessEmployee {
    private TechnicalLead lead;

    public Accountant(String name){
        super(name);
    }

    public TechnicalLead getTeamSupported(){
        return lead;
    }

    public void supportTeam(TechnicalLead lead){
        this.lead = lead;
        this.setBonusBudget(lead.getReports()*75000*1.1);
    }

    public boolean approveBonus(double bonus){
        return getTeamSupported() != null && bonus < this.getBonusBudget();
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + this.getBonusBudget() + " is supporting " + lead.getName();
    }
}
