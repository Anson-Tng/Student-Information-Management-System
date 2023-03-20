package assignment_2;

public class UndergraduateUnit extends Unit{
    private Unit enrolmentType;
    private String unit;
    private int unitLvl;
    private double assignmentOne;
    private double assignmentTwo;
    private double weeklyWork;
    private double finalExam;
    private double overallMark;
    private String finalGrade;
    
    //Constructor
    public UndergraduateUnit() throws Exception{
        this.enrolmentType = new Unit("U");
        this.unit = "ICT 167";
        this.unitLvl = 1;
        this.assignmentOne = 0;
        this.assignmentTwo = 0;
        this.weeklyWork = 0;
        this.finalExam = 0;
        this.overallMark = 0;
        this.finalGrade = "";
    }
    
    // Constructor with assign parameter values
    public UndergraduateUnit(double as1, double as2, double ww, double fe) throws Exception{
        this.enrolmentType = new Unit("U");
        this.assignmentOne = as1;
        this.assignmentTwo = as2;
        this.weeklyWork = ww;
        this.finalExam = fe;
        
        //Calculate overall mark
        double weightedAverage = 0;
        weightedAverage += this.assignmentOne * 0.25;
        weightedAverage += this.assignmentTwo * 0.25;
        weightedAverage += this.weeklyWork * 0.20;
        weightedAverage += this.finalExam * 0.30;
        this.overallMark = weightedAverage;
        
        //Define the final grade
        if(weightedAverage >= 80.0){
            this.finalGrade = "HD";
        } else if(weightedAverage >= 70.0){
            this.finalGrade = "D";
        } else if(weightedAverage >= 60.0){
            this.finalGrade = "C";
        } else if(weightedAverage >= 50.0){
            this.finalGrade = "P";
        } else {
            this.finalGrade = "N";
        }      
    }
    
    //get methods
    public String getEnrolType(){
        return enrolmentType.getUnit();
    }
    
    public double getAssignmentOne(){
        return this.assignmentOne;
    }
    
    public double getAssignmentTwo(){
        return this.assignmentTwo;
    }
    
    public double getWeeklyWork(){
        return this.weeklyWork;
    }
    
    public double getFinalExam(){
        return this.finalExam;
    }
    
    public double getOverallMark(){
        return this.overallMark;
    }
    
    public String getFinalGrade(){
        return this.finalGrade;
    }
}
