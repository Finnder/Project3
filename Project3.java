import java.util.Scanner;

/*
Written By: Finnegan McGuire
Date: 4/13/2021
Class: CSC120-N890: Computing Fundementals 1
Prof: Colson Dunlap
*/

public class Project3
{
   //Method To Display The Title
   public static void displayTitle()
   {
      String title = "Computer Hardware Graphics Quality Recommendation Tool";
      System.out.println(title);
   } 
   
   // Method That Returns the resolution based on an int
   public static String getResolutionString(int resolutionNum)
   {
      String resolution = "";
      
      if (resolutionNum == 1){ resolution = "1280 X 720"; }
      else if (resolutionNum == 2){ resolution = "1920 x 1080"; }
      else if (resolutionNum == 3){ resolution = "2560 x 1440"; }
      else if (resolutionNum == 4){ resolution = "3840 x 2160"; }
      
      return resolution;
   }
   
   // Method that returns a multiplier based on an int
   public static double getMultiplierValue(int value)
   {
      double multiplier = 0;
      if(value == 1){ multiplier = 1; }
      else if(value == 2){ multiplier = 0.75; }
      else if(value == 3){ multiplier = 0.50; }
      else if(value == 4){ multiplier = 0.25; }
      
      return multiplier;
   }
   
   // Method that calculates the performance score
   public static double calculatePerformanceScore(int gpuClockSpeed, int cpuClockSpeed, int numOfCores, double multiplierValue)
   {
       //Performance Score Equation
       double PerformanceValue = ((5 * gpuClockSpeed) + (numOfCores * cpuClockSpeed)) * multiplierValue;
       return PerformanceValue;
       
   }
   
   public static String getRecommendedQuality(double performanceScore)
   {
      String output;
      
      //Determining Recommended Graphics Quality
      if(performanceScore >= 17000)
      {
         output = "Ultra";
      }
      else if(performanceScore > 15000 && performanceScore < 17000)
      {
         output = "High";
      }
      else if(performanceScore > 13000 && performanceScore < 15000)
      {
         output = "Medium";
      }
      else if(performanceScore > 11000 && performanceScore < 13000)
      {
         output = "Low";
      }
      else
      {
         output = "Unable To Play";
      }
      
      return output;
   }
   
   public static void displayInformation(int gpuSpeed, int cpuSpeed, int amountOfCores, String resolutionChoice, double performanceScore)
   {
      // Printing recieved input from the user
      System.out.println(" ");
      System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
      System.out.println("Number Of Cores: " + amountOfCores);
      System.out.println("Monitor Resolution: " + resolutionChoice);
      System.out.printf("Performance Score: %.3f\n", performanceScore);
   }
   
   public static void main(String[] args)
   {
      // Scanner to get user keyboard input
      Scanner keyboard = new Scanner(System.in);
      int totalComputers;
      
      // Predefined variables
      double highestPerformanceScore = 0;
      double lowestPerformanceScore = 0;
      boolean firstComputer = true;
      
      // How many computers to be processed
      System.out.print("How many computers are being processed? ");
      totalComputers = keyboard.nextInt();
      
      while(totalComputers > 0){
      // Initiating Variables For Future Use
      int gpuSpeed;
      int cpuSpeed;
      int amountOfCores;
      int menuChoice;
      int userResolutionChoice;
      String stringResolutionChoice = "";
      
      double multiplier = 0;
      double performanceScore;
      
      String output;
      
      String resolution1 = "1280 x 720";
      String resolution2 = "1920 x 1080";
      String resolution3 = "2560 x 1440";
      String resolution4 = "3840 x 2160";
      
      // Get GPU Mhz from user
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Graphics Card (GPU): ");
      gpuSpeed = keyboard.nextInt();
      
      while(gpuSpeed < 800 || gpuSpeed > 2000)
      {
         System.out.println("ERROR: Gpu speed must be greater then or equal too 800 OR less then or equal too 2000");
         System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(GPU): ");
         gpuSpeed = keyboard.nextInt();
      }
      
      // Get CPU MHz from user
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(CPU): ");
      cpuSpeed = keyboard.nextInt();
      
      // Error handling for cpu speed
      while(cpuSpeed < 1000 || cpuSpeed > 5500)
      {
         System.out.println("ERROR: Cpu speed must be greater then or equal too 1000 OR less then or equal too 5500");
         System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(CPU): ");
         cpuSpeed = keyboard.nextInt();
      }
      
      // Get Amount Of CPU Cores From User
      System.out.print("Enter The Number Of Cores Your Processor(CPU) Has: ");
      amountOfCores = keyboard.nextInt();
      
      // Checks if amount of cores is not 1 - 16
      while(amountOfCores < 1 || amountOfCores > 16)
      {
         System.out.println("ERROR: You must input a number from 1 - 16");
         System.out.print("Enter The Number Of Cores Your Processor(CPU) Has: ");
         amountOfCores = keyboard.nextInt();    
      }
      
      System.out.println("1. " + resolution1);
      System.out.println("2. " + resolution2);
      System.out.println("3. " + resolution3);
      System.out.println("4. " + resolution4);
      System.out.print("Please select from the options above: ");
      userResolutionChoice = keyboard.nextInt();
      
      // If the user didnt use a number 1 - 4 then run this
      while(userResolutionChoice < 1 || userResolutionChoice > 4)
      {
         System.out.println("Please use a number from the list");
         System.out.println("1. " + resolution1);
         System.out.println("2. " + resolution2);
         System.out.println("3. " + resolution3);
         System.out.println("4. " + resolution4);
         System.out.print("Please select from the options above: ");
         userResolutionChoice = keyboard.nextInt();
      }
      
      //Changing Multiplier Depending On The Users Resolutions Choice as well as what to display for resolution
      if(userResolutionChoice == 1)
      {
         multiplier = getMultiplierValue(userResolutionChoice);
         stringResolutionChoice = getResolutionString(userResolutionChoice);
      }
      else if(userResolutionChoice == 2)
      {
         multiplier = getMultiplierValue(userResolutionChoice);
         stringResolutionChoice = getResolutionString(userResolutionChoice);
      }
      else if(userResolutionChoice == 3)
      {
         multiplier = getMultiplierValue(userResolutionChoice);
         stringResolutionChoice = getResolutionString(userResolutionChoice);
      }
      else if (userResolutionChoice == 4)
      {
         multiplier = getMultiplierValue(userResolutionChoice);
         stringResolutionChoice = getResolutionString(userResolutionChoice);
      }
      
      //Call Calculate Performance Score Method
      performanceScore = calculatePerformanceScore(gpuSpeed, cpuSpeed, amountOfCores, multiplier); 
      
      String resolutionChoice = getResolutionString(userResolutionChoice);
      displayInformation(gpuSpeed, cpuSpeed, amountOfCores, resolutionChoice, performanceScore);
            
      // Detecting the highest performance score
      if(performanceScore > highestPerformanceScore)
      {
         highestPerformanceScore = performanceScore;
      }
      
      // Detecting the lowest performance score
      if(firstComputer){
         lowestPerformanceScore = performanceScore;
         firstComputer = false;
      } else {
         if(performanceScore < lowestPerformanceScore)
         {
            lowestPerformanceScore = performanceScore;
         }
      }
      
      // FINAL OUTPUT TO CONSOLE
      String recommendedQuality = getRecommendedQuality(performanceScore); 
      System.out.println("Recommended Graphics Quality: " + recommendedQuality + "\n");      
            
      // Subtracting the computers by one
      totalComputers--;
      }
      
      // Displaying performance data (highest and lowest score)
      System.out.printf("The highest performance score was: %.3f\n", highestPerformanceScore);
      System.out.printf("The lowest performance score was: %.3f\n", lowestPerformanceScore);
      
   }
}