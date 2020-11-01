/*
ID: abandar1
LANG: JAVA
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class ariprog {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> sequences = new ArrayList<int[]>();
		
		ArrayList<Integer> bisquares = new ArrayList<Integer>();
		
		for (int i=0; i<=m; i++){
			for (int j=i; j<=m; j++){
				bisquares.add(i*i + j*j);
			}
		}
		Collections.sort(bisquares);
		
		for (int i=0; i<bisquares.size(); i++){
			for (int j=0; j<bisquares.size(); j++){
				
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		if (sequences.size()==0) out.println("NONE");
		else out.println(sequences.toString());
		
	}
	/*public String toString(ArrayList<int[]> list){
		
	}*/
	
}
