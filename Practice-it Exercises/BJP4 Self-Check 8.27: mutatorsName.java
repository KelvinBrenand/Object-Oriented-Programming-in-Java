// A Name object represents a person's name such as "John Q. Public".
public class Name {
    private String firstName;
    private char middleInitial;
    private String lastName;
    
    public Name(String first, char middle, String last) {
        firstName = first;
        middleInitial = middle;
        lastName = last;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public char getMiddleInitial(){
        return middleInitial;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setMiddleInitial(char middleInitial){
        this.middleInitial = middleInitial;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
