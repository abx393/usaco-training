/*
ID: abandar1
LANG: JAVA
TASK: milk2
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class milk2 {
	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(new File("milk2.in"));
		PrintStream out = new PrintStream("milk2.out");
		
		final int N = sc.nextInt();
		//TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
		
		Interval[] intervals = new Interval[N];
		for (int i=0; i<N; i++){
			intervals[i] = new Interval(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				return i1.getLow()- i2.getLow();
			}	
		});
		System.out.println(Arrays.toString(intervals));
		int low = intervals[0].getLow();
		int high = intervals[0].getHigh();
		int maxCont = high-low;
		int maxGap = 0;
		for (int i=1; i<intervals.length; i++){
			Interval x = intervals[i];
			if (x.getLow()>high){
				maxCont = Math.max(high-low, maxCont);

				int gap = x.getLow()-high;
				maxGap = Math.max(gap, maxGap);
				
				low = x.getLow();
				high = x.getHigh();
			}
			else {
				high = Math.max(high,  x.getHigh());
			}

		}
		out.print(maxCont + " ");
		out.println(maxGap);
		out.close();
	}
		
}


class Interval{
	private int low;
	private int high;
	public Interval(int l, int h){
		low = l;
		high = h;
	}
	public int getLow(){
		return low;
	}
	public int getHigh(){
		return high;
	}
	public String toString(){
		return "\n" + this.low + " " + (this.high) ;
	}
}

