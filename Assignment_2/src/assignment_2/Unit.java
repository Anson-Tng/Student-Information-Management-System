package assignment_2;


public class Unit {
    
    private String enrolmentType;
    
    // Default constrcutor
    public Unit(){
        this.enrolmentType ="";
    }
    
    // Constructor with assign parameter values    
    public Unit(String enrolmentType) throws Exception{
        if(enrolmentType.equalsIgnoreCase("U")||enrolmentType.equalsIgnoreCase("G")){
                    this.enrolmentType = enrolmentType;
        } else{
            throw new Exception("Wrong enrolment type entered.");
        }
    }
    
    //get methods
    public String getUnit(){
        return this.enrolmentType;
    }
    
    public void finalGradeReport(){
        System.out.println("Not available.");
    }
}
