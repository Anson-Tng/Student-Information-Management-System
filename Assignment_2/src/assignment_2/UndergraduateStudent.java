package assignment_2;

public class UndergraduateStudent extends Student{
    private UndergraduateUnit Uunit;
    
    // Default constrcutor
    public UndergraduateStudent() throws Exception{
        super();
        Uunit = new UndergraduateUnit();
    }
    
    // Constructor with assign parameter values
    public UndergraduateStudent(long id, String gName, String fName, int y, int m,
            int d, double as1, double as2, double ww, double fe) throws Exception{
            super( id, gName, fName, y, m, d);
            this.Uunit = new UndergraduateUnit(as1,as2,ww,fe);
    }
    
    //get methods
    public String getName(){
        // get the full name.
        return this.getGivenName()+" "+this.getFamilyName();
    }
    
    public double getOverallMark(){
        return Uunit.getOverallMark();
    }
    
   public String getEnrolmentType(){
        return Uunit.getEnrolType();
    } 
    
    public String updateData(){
        // method for Function #7, shorten the line.
        return Uunit.getAssignmentOne()+","+Uunit.getAssignmentTwo()+
                ","+Uunit.getWeeklyWork()+","+Uunit.getFinalExam();
    }
    
    @Override
    public String reportGrade(){
        return  "\n" + " --Grade Report--\n" + 
                "\nEnrolment type: "+Uunit.getEnrolType()+
                "\nName          : "+getName()+
                "\nStudent ID    : "+getStudentId()+
                "\nOverall mark  : "+Uunit.getOverallMark()+
                "\nFinal grade   : "+Uunit.getFinalGrade();
    }
    
    @Override
    public String toString(){
        return "\nName           : "+getName()+
               "\nID             : "+getStudentId()+
               "\nDOB            : "+getDob()+
               "\nEnrolment type : "+Uunit.getEnrolType()+
               "\nAssignment 1   : "+Uunit.getAssignmentOne()+
               "\nAssignment 2   : "+Uunit.getAssignmentTwo()+
               "\nWeekly work    : "+Uunit.getWeeklyWork()+
               "\nFinal exam     : "+Uunit.getFinalExam()+"\n";
    }
}
    
    
