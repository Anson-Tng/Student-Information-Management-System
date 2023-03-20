package assignment_2;

public class GraduateUnit extends Unit{
    private Unit enrolmentType;
    private String title;
    private int completionYear;
    private String finalGrade;

    // Default constrcutor
    public GraduateUnit() throws Exception{
        this.enrolmentType = new Unit("G");
        this.title = "";
        this.completionYear = 0;
         this.finalGrade = "";
    }
    
    // Constructor with assign parameter values
    public GraduateUnit(String title, int completeYear, String finalGrade) throws Exception{
        this.enrolmentType = new Unit("G");
        if(title.equalsIgnoreCase("master")){
            this.title = "Master";
        } else if(title.equalsIgnoreCase("phd")){
             this.title = "PhD";
        } else{
        throw new Exception("Wrong title entered.");
        }
    
        this.completionYear = completeYear;
    
        if(finalGrade.equalsIgnoreCase("c")){
            this.finalGrade = "C Completed";
        } else if (finalGrade.equalsIgnoreCase("n")){
            this.finalGrade = "N Not completed";
        } else if (finalGrade.equalsIgnoreCase("s")){
            this.finalGrade = "S Suspended";
        }
    }
    
    //get methods
    public String getEnrolType(){
        return enrolmentType.getUnit();
    }

    public String getTitle(){
        return this.title;
    }

    public int getCompletionYear(){
        return this.completionYear;
    }

    public String getFinalGrade(){
        return this.finalGrade;
    }
}


