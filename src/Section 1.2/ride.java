/* 
ID: abandar1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;

class ride {
	public static void main(String[] args) throws IOException{
		//System.out.print(getNum("String"));
		//FileInputStream f = new FileInputStream("ride.in");
		PrintStream out = new PrintStream("ride.out");
		//File test = new File("test.txt");
		
		
		Scanner sc = new Scanner(new File("ride.in"));
		String com = sc.nextLine();
		String gro = sc.nextLine(); //gets the comet name and group name
		sc.close();
		
		
		if (getNum(com)%47 == getNum(gro)%47) {
			out.println("GO\n"); //outputs 'GO'
			//System.out.print("GO");
		}
		else out.println("STAY"); //outputs 'STAY'
		//fout.close();
			//System.out.print("STAY");
		out.close();
			
	}
	static long getNum(String s){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int nums[] = new int[s.length()]; 
		s= s.toLowerCase(); //sets all the characters lower case so that its 
		//to compare later in the for loop
		for (int i=0; i<s.length(); i++){
			for (int j=0; j<alphabet.length(); j++){
				if (alphabet.charAt(j)==s.charAt(i)){
					nums[i] = j+1; //set to the corresponding number
				}
			}	
		}
		long result = 1;
		for (int n: nums){
			result*=n; //finds the product of the numbers
		}
		return result;
	}
}
