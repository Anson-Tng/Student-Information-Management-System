package assignment_2;

public class Date {
    
    private int year;
    private int month;
    private int day;
    
    // Default constrcutor
    public Date(){
        this.year = 0;
        this.month = 0;
        this.day = 0;
    }
    
    // Constructor with assign parameter values
    public Date(int year, int month, int day) throws Exception{
        if(year >= 1900 && year <=2021){
            this.year = year;
        } else{
            throw new Exception("Invalid Dob year.");
        }
        if(month >=1 && month <=12){
             this.month = month; 
        } else {
            throw new Exception("Invalid Dob month.");
        }
        if(day >= 1 && day <=31){
           this.day = day; 
        } else{
            throw new Exception("Invalid Dob day.");
        }

    }
    
    //get methods 
    public String getDay() {
        // get the day in ordinal number format.
        String dy="";
        switch(this.day){
            case 1:
                dy=this.day+"st";
                break;
            case 2:
                dy=this.day+"nd";
                break;
            case 3:
                dy=this.day+"rd";
                break;
            case 21:
                dy=this.day+"st";
                break;
            case 22:
                dy=this.day+"nd";
                break;
            case 23:
                dy=this.day+"rd";
                break;
            case 31:
                dy=this.day+"st";
                break;
            default:
                dy=this.day+"th";
        }
        return dy;
    }
    
    public int getDayNum(){
        // get the day in number only.
        return this.day;
    }

    public String getMonth() {
        // get the month in month name, instead of number.
        String mth ="";
        switch(this.month){
            case 1:
                mth="January";
                break;
            case 2:
                mth="Febuary";
                break;
            case 3:
                mth="March";
                break;
            case 4:
                mth="April";
                break;
            case 5:
                mth="May";
                break;
            case 6:
                mth="June";    
                break;
            case 7:
                mth="July";    
                break;
            case 8:
                mth="August";    
                break;
            case 9:
                mth="September";    
                break;
            case 10:
                mth="October";    
                break;
            case 11:
                mth="November";    
                break;
            case 12:
                mth="December";
                break;
        }
        return mth;
    }
    
    public int getMonthNum(){
        //get the month in number.
        return this.month;
    }
    
    public int getYear() {
        return year;
    }
    
    
    @Override
    public String toString(){
        return getDay()+" "+getMonth()+" "+year;
    }
}
