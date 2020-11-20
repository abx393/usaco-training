/*
ID: abandar1
LANG: JAVA
TASK: ttwo
*/

import java.util.*;
import java.io.*;

public class ttwo{
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("ttwo.in"));
		Scanner sc = new Scanner(new File("ttwo.in"));
		boolean[][] obs = new boolean[10][10];
		int f1=0, f2=0, fdir=0, c1=0, c2=0, cdir=0;
		for (int i=0; i<10; i++){
			String s = sc.next();//br.readLine();
			for (int j=0; j<10; j++) {
				if (s.charAt(j)=='*') {
					obs[i][j] = true;
				} else if (s.charAt(j)=='F') {
					f1 = i; f2 = j;
				} else if (s.charAt(j)=='C'){
					c1 = i; c2 = j;
				}
			}
		}
		sc.close();
		//System.out.println("f1="+f1);
		//System.out.println("f2=" +f2);
		//System.out.println("c1="+c1);
		//System.out.println("c2="+c2);
		//br.close();
		sc.close();
		boolean[][][] visitedf = new boolean[10][10][4];
		boolean[][][] visitedc = new boolean[10][10][4];
		
		ArrayList<Integer>[][] timef = new ArrayList[10][10];
		ArrayList<Integer>[][] timec = new ArrayList[10][10];
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				timef[i][j] = new ArrayList<Integer>();
				timec[i][j] = new ArrayList<Integer>();
			}
		}
		
		int counter = 0;

		while (counter<999) {
			visitedf[f1][f2][fdir] = true;
			timef[f1][f2].add(counter);
			//System.out.println(counter);
			counter++;
			switch (fdir){
				case 0: // north
					if (f1>0 && !obs[f1-1][f2]) f1--;
					else fdir = 1;
					break;
				case 1: // east
					if (f2<9 && !obs[f1][f2+1]) f2++;
					else fdir = 2;
					break;
				case 2: // south
					if (f1<9 && !obs[f1+1][f2]) f1++;
					else fdir = 3;
					break;
				case 3: // west
					if (f2>0 && !obs[f1][f2-1]) f2--;
					else fdir = 0;
					break;
			}
			//System.out.println("f1="+f1);
			//System.out.println("f2="+f2);
		}
	
		counter = 0;
		while (counter<999) {
			//System.out.println(counter);
			visitedc[c1][c2][cdir] = true;
			timec[c1][c2].add(counter);
			counter++;
			switch (cdir){
				case 0: // north
					if (c1>0 && !obs[c1-1][c2]) c1--;
					else cdir = 1;
					break;
				case 1: // east
					if (c2<9 && !obs[c1][c2+1]) c2++;
					else cdir = 2;
					break;
				case 2: // south
					if (c1<9 && !obs[c1+1][c2]) c1++;
					else cdir = 3;
					break;
				case 3: // west
					if (c2>0 && !obs[c1][c2-1]) c2--;
					else cdir = 0;
					break;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		int min = Integer.MAX_VALUE;
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				for (int f: timef[i][j]) {
					for (int c: timec[i][j]) {
						if (f == c) {
							min = Math.min(min, f);
						}
					}
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			out.println(0);
		} else {
            out.println(min);
        }
		
		out.close();
	}
}
