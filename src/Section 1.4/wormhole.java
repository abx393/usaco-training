/*
ID: abandar1
LANG: JAVA
TASK: wormhole
 */

import java.awt.Point;
import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class wormhole {
	public static int[] X;
	public static int[] Y;
	public static int count;
	public static int[] partner;
	public static int n;
	public static int[] nextOnRight;
	public static int count2 = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		n = Integer.parseInt(br.readLine());
		X = new int[n+1];
		Y = new int[n+1];
		partner = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		nextOnRight = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int minX = Integer.MAX_VALUE;
			int minJ = 0;
			for (int j = 1; j <= n; j++) {
				if (X[j] > X[i] && Y[j] == Y[i]) {
					if (X[j] < minX){
						minX = X[j];
						minJ = j;
					}
				}
			}
			nextOnRight[i] = minJ;
		}
		//System.out.println("x: " + Arrays.toString(X));
		//System.out.println("next on right: " + Arrays.toString(nextOnRight));
		solve();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		out.println(count);
		//System.out.println("num of pairings: " + count2);
		out.close();
	}

	public static void solve() {
		pair(1);
	}
	
	public static void pair(int i) {
		if (i>n) {
			if (cycleExists()) count++;
		} else if (partner[i]!=0) {
          pair(i+1);
        } else {
			for (int j=i+1; j<=n; j++){
				if (partner[j]==0){
					partner[i] = j;
					partner[j] = i;
					pair(i+1);
					partner[i] = 0;
					partner[j] = 0;
				}
			}
		}
	}

	public static boolean cycleExists() {
		for (int i=1; i<=n; i++) {
			int pos = i;
			for (int j=0; j<n; j++){
				pos = nextOnRight[partner[pos]];
				if (pos == i) return true;
			}
		}
		return false;
	}
}
