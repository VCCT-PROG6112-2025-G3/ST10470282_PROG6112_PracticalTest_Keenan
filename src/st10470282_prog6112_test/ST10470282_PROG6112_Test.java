
package st10470282_prog6112_test;
import java.util.Scanner;

public class ST10470282_PROG6112_Test {

    
    public static void main(String[] args) {
   //Implement Scanner 
   Scanner Scan = new Scanner(System.in);
   //Use 1D array to store stadiums and batsmans
   String[] Stadiums = {"Kingsmead", "St Georges", "Wanderers"};
   String[] Batsmans = {"Jacques Kallis", "Hashim Amla", "AB De Villiers"};
   //use 2D array to store runs for batsmans at stadiums
   int[][] Runs = new int [Stadiums.length][Batsmans.length];
   
   System.out.println("SA CRICKETER APPLICATION");
   System.out.println("------------------------------------------------------------------------------");
   
   //created a for loop to ask the user to enter the number of runs scored at a stadium
   for(int i=0; i < Stadiums.length; i++){
       System.out.print("Enter the number runs scored by Jacques Kallis at " + Stadiums[i] + ": ");
       Runs[i][0] = Scan.nextInt();
       
       System.out.print("Enter the number runs scored by Hashim Amla at " + Stadiums[i] + ": ");
       Runs[i][1] = Scan.nextInt();
       
       System.out.print("Enter the number runs scored by AB De Villiers at " + Stadiums[i] + ": ");
       Runs[i][2] = Scan.nextInt();
       
    }
   System.out.println("----------------------------------------------------------------------------------");
   System.out.println("RUNS SCORED REPORT");
   System.out.println("----------------------------------------------------------------------------------");
   
   //for loop created to display the runs scored at the stadiums
   for(int i =0; i < Stadiums.length; i++){
   
   System.out.println("\nJacques Kallis runs scored at " + Stadiums[i] + ": " + Runs[i][0]);
   System.out.println("Hashim Amla runs scored at " + Stadiums[i] + ": " + Runs[i][1]);
   System.out.println("AB De Villiers runs scored at " + Stadiums[i] + ": " + Runs[i][2]);
   
   }
    System.out.println("\n----------------------------------------------------------------------------------");
    System.out.println("TOTAL RUNS AT STADIUMS");
    System.out.println("----------------------------------------------------------------------------------");
    
    // create a variable Maxruns and set to 0 to later calculate which stadium has the most runs
    int MaxRuns = 0;
    String Stadiumwon = "";
    for(int i = 0; i < Stadiums.length; i++){
        int Total = Runs[i][0] + Runs[i][1] + Runs[i][2];
        System.out.println(Stadiums[i]+ "    " + Total);
        // if statement that checks which stadium has the most runs
        if(Total > MaxRuns){
            MaxRuns = Total;
            Stadiumwon = Stadiums[i];
        }
    }
    System.out.println(" ");
    System.out.println("STADIUM WITH THE MOST RUNS: " + Stadiumwon);
    System.out.println("----------------------------------------------------------------------------------");
    Scan.nextLine();
    
    System.out.print("The cricketer name: ");
    String BatName = Scan.nextLine();
    
    System.out.print("Enter the stadium: ");
    String StadiumName = Scan.nextLine();
    
    System.out.print("Enter the total runs scored by " + BatName + " at " + StadiumName + " : ");
    int RunsScored = Scan.nextInt();
    // calling the CricketRunsScored class into the main method with variable report
    CricketRunsScored report = new CricketRunsScored(BatName, StadiumName, RunsScored);
    System.out.println("BATSMAN RUNS SCORED REPORT");
    System.out.println("******************");
    //call method Report from the subclass CricketRunsScored to display the report
    report.Report();
    
    Scan.close();
    
    }
    
}
// Java Interface
//GeeksForGeeks
//Answer: lines 89-105
//URL: https://www.geeksforgeeks.org/java/interfaces-in-java/ 
interface ICricket{
    String getBatsman();
    String getStadium();
    int getRunsScored();
}
//abstract class
//W3Schools
//Answer: Lines 98- 108
//URL: https://www.w3schools.com/java/java_abstract.asp 
abstract class Cricket implements ICricket{
    private String Batsman;
    private String Stadium;
    private int RunsScored;
    
    public Cricket(String Batsman, String Stadium, int RunsScored){
        this.Batsman = Batsman;
        this.Stadium = Stadium;
        this.RunsScored = RunsScored;
        
    }
    
    @Override
    public String getBatsman(){
        return Batsman;
    }
     @Override
    public String getStadium(){
        return Stadium;
    }
     @Override
    public int getRunsScored(){
        return RunsScored;
    }
    
}
//subclass created that extends class cricket
class CricketRunsScored extends Cricket{
    public CricketRunsScored(String Batsman, String Stadium, int RunsScored){
        super(Batsman, Stadium, RunsScored);
    }
    public void Report(){
    System.out.println("CRICKET PLAYER: " + getBatsman());
    System.out.println("STADIUM: " + getStadium());
    System.out.println("TOTAL RUNS SCORED: " + getRunsScored());
    } 
    
}