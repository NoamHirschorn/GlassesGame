import java.util.Arrays;
import java.util.Scanner;
public class glassesgame 
{
     
   
    
     
    public static void main(String[] args)
    {    
	Scanner input = new Scanner(System.in);
	
	System.out.println("number of glasses?");
	int glnum = input.nextInt();
	System.out.println("number of simulations?");
    int simulnum = input.nextInt();
	//System.out.println("HI");
	//double simulnum = 250000, glnum = 6;	
   //  double glnum = readDouble("How many glasses does the game have? "),simulnum = readDouble("How many simulations would you like to run? ");  
     
         int moveCounter=0;
	int x =(int)simulnum; 
          int numface =(int)glnum;
            if(numface<1||x<1){
                System.out.println("Please enter a valid input");
            }
            else if((numface==1&&x>0)||(numface>1&&x==1)){
                retscreen(numface,numface,x,x,0);
            }
            else{
          int [] numbers = new int [x];
            boolean [] gl = new boolean [numface];
       for(int i =0; i <x; i++){
           for(int j = 0;j<numface;j++){
       gl[j]=false;
   }
           int eachRound = 0;
		  // System.out.println("lii");
      while(false==checkType(gl,true)){
		 // System.out.println("6");
       int die  = (int)(Math.random() * (numface));
       moveCounter++;
     eachRound++;
      
       gl[die]=!(gl[die]);
	   
      }
      numbers[i]= eachRound;
	 // System.out.println("7");
}
 //System.out.println("8");
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
