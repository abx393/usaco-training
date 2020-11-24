/*
ID: abandar1
LANG: JAVA
TASK: combo
 */

import java.io.*;
import java.util.*;

public class combo {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int n = Integer.parseInt(br.readLine());
		int[] combo1 = new int[3];
		int[] combo2 = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++){
			combo1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++){
			combo2[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		HashSet combos = new HashSet();
		for (int i=-2; i<=2; i++){
			for (int j=-2; j<=2; j++){
				for (int k=-2; k<=2; k++){
					int[] combo = {mod(combo1[0]+i,n), mod(combo1[1] + j,n), mod(combo1[2]+k,n)};
					combos.add(combo);
				}
			}
		}
		
		for (int i=-2; i<=2; i++){
			for (int j=-2; j<=2; j++){
				for (int k=-2; k<=2; k++){
					int[] combo = {mod(combo2[0]+i, n), mod(combo2[1] + j,n), mod(combo2[2]+k,n)};
					combos.add(combo);
				}
			}
		}
		//System.out.println(combos.toArray());
		out.println(combos.size());
		out.close();
	}
	public static int mod(int i, int n){
		if (i>0) return i%n;
		else return mod(n+i,n);
	}
	private class HashSet{
		private ArrayList<int[]> set;
		//private int ind;
		
		public HashSet(){
			set = new ArrayList<int[]>();
			//ind = 0;
		}
		public void add(int[] elem){
			for (int i=0; i<set.size(); i++){
				if (Arrays.equals(set.get(i), elem)) return;
			}
			set.add(elem);
			//ind++;
		}
		public Object[] toArray(){
			return  set.toArray();
		}
		public int size(){
			return set.size();
		}
	}
}


