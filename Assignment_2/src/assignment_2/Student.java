package assignment_2;


public class Student {
    // Base Class
    private String givenName;
    private String familyName;
    private long studentId;
    private Date dob;
    
    //Default constructor
    public Student(){
        this.givenName ="";
        this.familyName="";
        this.studentId = 0;
        this.dob = new Date();
    }
    
    // Constructor with assign parameter values
    public Student(long studentId, String givenName, String familyName, 
            int year, int month, int day) throws Exception{
        this.studentId = studentId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dob = new Date(year,month,day);
    }
       
    //get methods
    public String getGivenName(){
        return givenName;
    }
    
    public String getFamilyName(){
        return familyName;
    }
    
    public long getStudentId(){
        return studentId;
    }
    
    public Date getDob(){
        return dob;
    }
    
    public int getDayNum(){
        return dob.getDayNum();
    }
    
    public int getMonthNum(){
        return dob.getMonthNum();
    }
    
    public int getYear(){
        return dob.getYear();
    }
    
    @Override
    public String toString(){
        // Modified toString method
        return "\nName : "+givenName+" "+familyName+
               "\nID   : "+studentId+
               "\nDOB  : "+getDob()+"\n";
    }
    
    public String reportGrade(){
        // Default method.
        return "There is no grade here.";
    }
    
    public boolean equals(Student other){
        if(this.studentId == other.getStudentId()){
            return true;
            // true means its same.
        } else {
            return false;
            // false means its different.
        }  
    }
    
}
