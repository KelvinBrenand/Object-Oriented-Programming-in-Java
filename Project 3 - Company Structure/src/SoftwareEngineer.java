public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    public SoftwareEngineer(String name){
        super(name);
        codeAccess = false;
    }

    public boolean getCodeAccess(){
        return codeAccess;
    }

    public void setCodeAccess(boolean access){
        codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return getCheckIn();
    }

    public boolean checkInCode(){
        if (((TechnicalLead) this.getManager()).approveCheckIn(this)){
            this.setCheckIn(this.getCheckIn() + 1);
            return true;
        }else {
            setCodeAccess(false);
            return false;
        }
    }
}