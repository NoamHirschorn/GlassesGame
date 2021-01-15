import java.util.Arrays;
import java.util.Scanner;
public class glassesgame 
{
     
   
    
     
    public static void main(String[] args)
    {    
	Scanner input = new Scanner(System.in);
	  /*
	  *Ask the user about the number of glasses in the scenario 
	  *and how many simulations they would like to run
	  */
	System.out.println("number of glasses?");
	int glnum = input.nextInt();
	System.out.println("number of simulations?");
    int simulnum = input.nextInt();
	
     
         int moveCounter=0;
	int x =(int)simulnum; 
          int numface =(int)glnum;
	    //check inputs
            if(numface<1||x<1){
                System.out.println("Please enter a valid input");
            }
            else if((numface==1&&x>0)||(numface>1&&x==1)){
                retscreen(numface,numface,x,x,0);
            }
            else{
	
	//inputs are valid
	/*
	*set up the game
	*/
          int [] numbers = new int [x];
            boolean [] gl = new boolean [numface];
       for(int i =0; i <x; i++){
           for(int j = 0;j<numface;j++){
       gl[j]=false;
   }
           int eachRound = 0;	 
	       //check game isn't over
      while(false==checkType(gl,true)){	 
	 // play another round
       int die  = (int)(Math.random() * (numface));
       moveCounter++;
     eachRound++;
      
       gl[die]=!(gl[die]);
	   
      }
      numbers[i]= eachRound;
	
}
// obtain and print the median, mean, and standard deviation for the given number of glasses 
Arrays.sort(numbers);
double median = (numbers[x/2]+numbers[(x/2)-1])/(double)2;
double mean = moveCounter/(double)x;
double standard= standardDev(numbers, mean);
retscreen(median,mean,numbers[0],numbers[x-1],standard);
    }
	}
    


public static double standardDev(int [] arr, double mean){
    double sumStand = 0;
    for(int i =0; i <arr.length; i++){
        
        double sqr = (arr[i]-mean)*(arr[i]-mean);
        sumStand+=sqr;
       
    }
    double ans = Math.sqrt(sumStand/(arr.length-1));
	ans = Math.round(ans*100);	
	ans /= 100;
    
    return ans;
}
public static boolean checkType(boolean[] arr, boolean wantState){
    for(int i = 0;i<arr.length;i++){
        if(wantState!=arr[i]){
            return false;
        }
    }
    return true;
}

  

public static void retscreen(double median,double mean, int shortest, int longest,double standard){
    System.out.println("The median is: "+median);
    System.out.println("The mean is: "+mean);
    System.out.println("The shortest game was "+shortest+" moves and the longest was "+longest+" moves.");
    System.out.println("The standard deviation is: "+standard);
}

}
