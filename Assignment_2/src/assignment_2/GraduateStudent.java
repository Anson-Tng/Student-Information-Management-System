package assignment_2;

public class GraduateStudent extends Student{
    
    private GraduateUnit Gunit;
    
    // Default constrcutor
    public GraduateStudent() throws Exception{
        super();
        this.Gunit = new GraduateUnit();
    }
    
    // Constructor with assign parameter values
    public GraduateStudent(long id, String gName, String fName, int y, int m,
            int d, String title, int cYear, String fg) throws Exception{
        super(id, gName, fName, y, m, d);
        this.Gunit = new GraduateUnit(title, cYear, fg);
    }
    
    //get methods
    public String getName(){
        // get the name in full name.
        return this.getGivenName()+" "+this.getFamilyName();
    }
    
    public String getEnrolmentType(){
        return Gunit.getEnrolType();
    }
    
    public String updateData(){
        // method for Function #7, shorten the line.
        return Gunit.getTitle()+","+Gunit.getCompletionYear()+
                ","+Gunit.getFinalGrade();
    }
    
    @Override
    public String reportGrade(){
        return "\n --Grade Report--"+
               "\nEnrolment type     : "+ Gunit.getEnrolType()+
               "\nName               : "+getName()+
               "\nStudent ID         : "+getStudentId()+
               "\nLevel of Degree    : "+Gunit.getTitle()+
               "\nFinal grade        : "+Gunit.getFinalGrade();
    }
    
    @Override
    public String toString(){
        return "\nName             : "+getName()+
               "\nID               : "+getStudentId()+
               "\nDOB              : "+getDob()+
               "\nEnrolment type   : "+Gunit.getEnrolType()+
               "\nTitle            : "+Gunit.getTitle()+
               "\nComepletion year : "+Gunit.getCompletionYear()+
               "\nFinal grade      : "+Gunit.getFinalGrade()+"\n";
    }
}
