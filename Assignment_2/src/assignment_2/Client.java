package assignment_2;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    ArrayList<UndergraduateStudent> uStudent = new ArrayList<UndergraduateStudent>();
    ArrayList<GraduateStudent> gStudent = new ArrayList<GraduateStudent>();
    // Create two ArrayList for undergraduate and graduate student.
    
    public void StudentInfo(){
        // Print out my student information.
        System.out.println("Name : Anson Ting Lik Yuan");
        System.out.println("Student ID : 34212178");
        System.out.println("Mode of enrolment : External");
        System.out.println("Tutor name : Miss Sirui Li");
        System.out.println("");
    }
    
    public void load(){
        // Method to read all the data from a file (student.csv).
        try{
            FileReader inputFile = new FileReader("student.csv");
            // Read the student.csv file.
            Scanner readFile = new Scanner(inputFile);
            // Scan the texts from student.csv file.
            
            while(readFile.hasNextLine()){
                // when file has texts
                String message = readFile.nextLine();
                String[] details = message.split(",");
                // message.split(",") to split the data into each variable.
                if(details.length == 11 && details[6].trim().equalsIgnoreCase("u")){
                    // If the list contains 11 variables and the 6th data is U, the system 
                    // will store the data into a new Undegraduate student ArrayList.
                    UndergraduateStudent u = new UndergraduateStudent(Long.parseLong(details[0].trim()),
                            details[1].trim(), details[2].trim(), 
                            Integer.parseInt(details[3].trim()), 
                            Integer.parseInt(details[4].trim()), 
                            Integer.parseInt(details[5].trim()), 
                            Double.parseDouble(details[7].trim()), 
                            Double.parseDouble(details[8].trim()), 
                            Double.parseDouble(details[9].trim()), 
                            Double.parseDouble(details[10].trim()));
                            uStudent.add(u);
                } else{
                    // Else will store the data into a new Graduate student ArrayList.
                    GraduateStudent g = new GraduateStudent(Long.parseLong(details[0].trim()),
                            details[1].trim(), details[2].trim(), 
                            Integer.parseInt(details[3].trim()), 
                            Integer.parseInt(details[4].trim()), 
                            Integer.parseInt(details[5].trim()),
                            details[7].trim(), Integer.parseInt(details[8].trim()),
                            details[9].trim());
                            gStudent.add(g);
                    }            
            }
                inputFile.close();
                readFile.close();
        } catch (Exception e){
            e.getMessage();
        }
    }
    
    public void displayMenu(){
        //Method for display menu.
        System.out.println("\nASSIGNMENT TWO PROGRAM\n");
        System.out.println("-----PROGRAM MENU-----");
        System.out.println("1. Quit (Exit the program)");
        System.out.println("2. Add a student's information from a file");
        System.out.println("3. Remove a student");
        System.out.println("4. Output all the information");
        System.out.println("5. Display the number of undergraduate student obtained "
                + "an overall mark equal to or above & below the average overall mark");
        System.out.println("6. Check a specific student's information");
        System.out.println("7. Sort the ArrayList and display the outcomes");
        System.out.println("8. Write the sorted ArrayList to a file");
        System.out.println("\nPlease enter a number : \n");
    }
    
    public void quit(){
        // Function #1 : Print thanks message and exit the program
        System.out.println("");
        System.out.println("-- Thanks for using the program--");
        System.exit(0);
    }
    
    public boolean uidCheck(UndergraduateStudent id){
        // Method to check if the student id is duplicated in undergraduate 
        // student arraylist.
        for(int i =0;i<uStudent.size();i++){
            if(uStudent.get(i).equals(id)){
                return false;
            } 
        }
        return true;
    }
    
    public boolean gidCheck(GraduateStudent id){
        // Method to check if the student id is duplicated in graduate 
        // student arraylist.
        for(int i =0;i<gStudent.size();i++){
            if(gStudent.get(i).equals(id)){
                return false;
            } 
        }
        return true;
    }
    
    public void add(){
        // Function #2 : Request file name from user, Scanner the file and add in
        // one undergraduate or graduate student data to the loaded ArrayList.
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Please Enter the file name : ");
            String file = input.nextLine();
            // ask user to input a file name (to test run,user can try: temp.csv)
            boolean oneTime = false;
            // oneTime is set to false as default, will change to true once the
            // one data is read.
            FileReader inputFile = new FileReader(file);
            // Read the inserted file.
            Scanner readFile = new Scanner(inputFile);
            // Scan the texts from inserted file.
            while(readFile.hasNextLine() && oneTime == false){
                String message = readFile.nextLine();
                String[] details = message.split(",");
                // message.split(",") to split the data into each variable.
                if(details.length == 11 && details[6].trim().equalsIgnoreCase("u")){
                    // If the list contains 11 variables and the 6th data is U, the system
                    // will store the data into a new Undegraduate student ArrayList.
                    UndergraduateStudent u = new UndergraduateStudent(Long.parseLong(details[0].trim()),
                            details[1].trim(), details[2].trim(), 
                            Integer.parseInt(details[3].trim()), 
                            Integer.parseInt(details[4].trim()), 
                            Integer.parseInt(details[5].trim()), 
                            Double.parseDouble(details[7].trim()), 
                            Double.parseDouble(details[8].trim()), 
                            Double.parseDouble(details[9].trim()), 
                            Double.parseDouble(details[10].trim()));
                            if(uidCheck(u)){
                                // check if the new student data is duplicated
                                // to current array list
                                uStudent.add(u);
                                oneTime = true;
                            } else{
                                System.out.println("\nDuplicated student ID.\n");
                                oneTime = false;
                            }

                } else{
                    // will store the data into a new Graduate student ArrayList.
                    GraduateStudent g = new GraduateStudent(Long.parseLong(details[0].trim()),
                            details[1].trim(), details[2].trim(), 
                            Integer.parseInt(details[3].trim()), 
                            Integer.parseInt(details[4].trim()), 
                            Integer.parseInt(details[5].trim()),
                            details[7].trim(), Integer.parseInt(details[8].trim()),
                            details[9].trim());
                            if(gidCheck(g)){
                                // check if the new student data is duplicated
                                // to current array list
                                gStudent.add(g);
                                oneTime = true;
                            } else{
                                System.out.println("\nDuplicated student ID.\n");
                                oneTime = false;
                            }
                    }               
            }
                readFile.close();
                System.out.println(uStudent);
                System.out.println(gStudent);
        } catch (Exception e){
            e.getMessage();
        }
    }
    
    public void remove(){
        // Function #3 Ask for a student ID from user and remove the student's information.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Student ID to remove : ");
        long id = input.nextLong();
        
        // Undergraduate student 
        for(int i=0;i<uStudent.size();i++){
            // for loop to go through every student.
            if(uStudent.get(i).getStudentId() == id){
                // when the student id is found in the array list, print the
                // information and ask for double confirm on deletion
                System.out.println("Are you sure to remove this student?");
                System.out.println("Student ID : "+uStudent.get(i).getStudentId());
                System.out.println("Name       : "+uStudent.get(i).getName());
                System.out.println("Y/N");
                String ans = input.next().toLowerCase();
                
                switch(ans){
                    case "y":
                        uStudent.remove(i);
                        System.out.println("\nRemove successed.");
                        break;
                    case "n":
                        System.out.println("\nRemove action cancelled.");
                        break;
                    default:
                        System.out.println("\nPlease enter only Y/N");
                } 
            } else{
                System.out.println("\nSorry the entered id is not exist in the list");
                break;
            }
        }
                   
        // Graduate student
        for(int i=0;i<gStudent.size();i++){
            if(gStudent.get(i).getStudentId() == id){
                System.out.println("\nAre you sure to remove this student?");
                System.out.println("Student ID : "+gStudent.get(i).getStudentId());
                System.out.println("Name       : "+gStudent.get(i).getName());
                System.out.println("Y/N");
                String ans = input.next().toLowerCase();
                
                switch(ans){
                    case "y":
                        gStudent.remove(i);
                        System.out.println("\nRemove successed.");
                        break;
                    case "n":
                        System.out.println("\nRemove action cancelled.");
                        break;
                    default:
                        System.out.println("\nPlease enter only Y/N");
                } 
            } else{
                System.out.println("\nSorry the entered id is not exist in the list");
                break;
            }
        }
        
    }
    
    public void output(){
        // Function #4 display all information that are stored in the arraylist.
        
        System.out.println("---Undergraduate students---");
        for(int i=0;i<uStudent.size();i++){
            System.out.println(uStudent.get(i));
        }
        
        System.out.println("---Graduate students---");
        for(int i=0;i<gStudent.size();i++){
            System.out.println(gStudent.get(i));
        }
    }
    
    public void count(){
        // Function #5 Find how many undergraduate student are equal & below & above
        // the overall mark.
        double avgOverallMark = 0;
        double totalOM = 0;
        int studentCount = 0;
        int equalOM = 0;
        int aboveOM = 0;
        int belowOM = 0;
        
        for(int i=0;i<uStudent.size();i++){
            totalOM += uStudent.get(i).getOverallMark();
            studentCount ++;
        }
        avgOverallMark = totalOM/studentCount;
        // average = all student's combined mark / total number of student
        for(int i=0;i<uStudent.size();i++){
            if(uStudent.get(i).getOverallMark() > avgOverallMark){
                aboveOM ++;
            } else if(uStudent.get(i).getOverallMark() == avgOverallMark){
                equalOM ++;
            } else{
                belowOM ++;
            }
        }
        
        System.out.println("\nThe average overall mark for undergraduate student "
                + "is : "+String.format("%.2f",avgOverallMark));
        //  Print the avgOverallMark with only 2 decimal number.
        System.out.println("The amount of student above the overall mark are      : "
                + aboveOM);
        System.out.println("The amount of student same with the overall mark are  : "
                + equalOM);
        System.out.println("The amount of student below the overall mark are      : "
                + belowOM);
    }
    
    public void checkInfo(){
        // Function #6 check specific student's information.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student ID :");
        long id = input.nextLong();
        
        // Undergraduate student
        for(int i=0;i<uStudent.size();i++){
            // for loop to go through every student.
            if(uStudent.get(i).getStudentId() == id){
                // when the student id is found in the array list, print the
                // information and the grade report
                System.out.println(uStudent.get(i).toString());  
                System.out.println(uStudent.get(i).reportGrade());
            }  else{
                System.out.println("\n Sorry, the entered id cant be found in"
                        + " undergraduate student list.");
            }
        }
        // Graduate student
        for(int i=0;i<gStudent.size();i++){
            // for loop to go through every student.
            if(gStudent.get(i).getStudentId() == id){
                // when the student id is found in the array list, print the
                // information and the grade report
                System.out.println(gStudent.get(i).toString());
                System.out.println(gStudent.get(i).reportGrade());
            }  else{
                System.out.println("\n Sorry, the entered id cant be found in"
                        + " undergraduate student list.");
            }
        }
    }
    
    public void sortList(){
     /* Function #7 Sort the current ArrayList to ascending order by student id.
      * The objective of this method is to sort the existing data in ArrayList 
      * to ascending order by student ID. The sorting algorithm applies a for 
      * loop inside a for loop, the outer loop is to store first data, and the
      * inner loop is to store second data. Then, suppose the first student id
      * number is bigger than the second student id number. In that case, 
      * first student data will be stored to a temporary memory location, 
      * and second student data will be set to the first student data’s memory
      * location. The data that temporary memory holds will be set to the second
      * student memory location.
      */
        for(int i=0;i<uStudent.size();i++){
            for(int j = i+1;j<uStudent.size();j++){
                if(uStudent.get(i).getStudentId() > uStudent.get(j).getStudentId()){
                    UndergraduateStudent temp = uStudent.get(i);
                    uStudent.set(i, uStudent.get(j));
                    uStudent.set(j, temp);
                }
            }
        }
        for(int i=0;i<gStudent.size();i++){
            for(int j = i+1;j<gStudent.size();j++){
                if(gStudent.get(i).getStudentId() > gStudent.get(j).getStudentId()){
                    GraduateStudent temp = gStudent.get(i);
                    gStudent.set(i, gStudent.get(j));
                    gStudent.set(j, temp);
                }
            }
        }
        
        System.out.println("\nThe arraylist is sorted.\n");
        
        System.out.println("---Undergraduate students---");
        for(int i=0;i<uStudent.size();i++){
            System.out.println(uStudent.get(i));
        }
        
        System.out.println("---Graduate students---");
        for(int i=0;i<gStudent.size();i++){
            System.out.println(gStudent.get(i));
        }
        
        System.out.println("\nThe arraylist is sorted.\n");
    }
    
    public void writeFile() throws IOException{
        // Function #8 Write the current Arraylist into a new file.
        FileOutputStream fileOS = null;
        try{
            fileOS = new FileOutputStream (new File("SortedStudent.csv"));
            for(int i=0;i<uStudent.size();i++){
               // loop thru all the data in Undegraduate student arraylist
               String data ="";
               data =uStudent.get(i).getStudentId()+","+uStudent.get(i).getGivenName()+
                       ","+uStudent.get(i).getFamilyName()+","+uStudent.get(i).getYear()+","+uStudent.get(i).getMonthNum()+
                       ","+uStudent.get(i).getDayNum()+","+uStudent.get(i).getEnrolmentType()+","+uStudent.get(i).updateData()+"\n";
               // store and form the data into the same format as first the system loaded it.
               byte[] info = data.getBytes();
               fileOS.write(info);
               fileOS.flush();
            }
            
            for(int i=0;i<gStudent.size();i++){
               // loop thru all the data in Graduate student arraylist
               String data ="";
               data =gStudent.get(i).getStudentId()+","+gStudent.get(i).getGivenName()+
                       ","+gStudent.get(i).getFamilyName()+","+gStudent.get(i).getYear()+","+gStudent.get(i).getMonthNum()+
                       ","+gStudent.get(i).getDayNum()+","+gStudent.get(i).getEnrolmentType()+","+gStudent.get(i).updateData()+"\n";
               // store and form the data into the same format as first the system loaded it.
               byte[] info = data.getBytes();
               fileOS.write(info);
               fileOS.flush();
           }
        } catch (Exception e){
            e.getMessage();
        } finally{
            try{
                if(fileOS != null){
                    System.out.println("\nData is written to the file.");
                    fileOS.close();
                } 
            } catch (Exception e){
                e.getMessage();
            }
        }
        
     
    }
   
    public static void main(String[]args) throws Exception{
        Scanner input = new Scanner(System.in);
        Client c = new Client();
        Boolean menuLoop = true;
        boolean sortedList = false;
        c.StudentInfo();        
        c.load();
        
        while(menuLoop){
            // Loop the menu until user choose to input 1 and exit the program.
            c.displayMenu();
            int ans = input.nextInt();
            switch(ans){
                case 1:
                    c.quit();
                    break;
                case 2:
                    c.add();
                    break;
                case 3:
                    c.remove();
                    break;
                case 4:
                    c.output();
                    break;
                case 5:
                    c.count();
                    break;
                case 6:
                    c.checkInfo();
                    break;
                case 7:
                    c.sortList();
                    sortedList = true;
                    break;
                case 8:
                    if(sortedList == true){
                        // Function #8 can only can be used after the arraylist
                        // is sorted(Function #7)
                        c.writeFile();
                    } else{
                        System.out.println("\nPlease sort the ArrayList first"
                                + " (Function #7).");                        
                    }
                    break;
                    
                default:
                    System.out.println("\nPlease enter a valid number");
            }
        }
    } 
}

