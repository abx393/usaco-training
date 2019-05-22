/*
ID: abandar1
LANG: JAVA
TASK: fracdec
*/

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class fracdec {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("fracdec.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		br.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		String res = longDivision(n, d);
		while (!res.equals("")){
			out.println(res.substring(0, Math.min(76, res.length())));
			res = res.substring(Math.min(76, res.length()));
		}
		out.close();
		
	}
	public static String longDivision(int dividend, int divisor){
		StringBuilder predecimal = new StringBuilder(), postdecimal = new StringBuilder(); //the sequences before and after the decimal point
		HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
		predecimal.append(dividend/divisor + ".");
		
		int i=0;
		int start=-1;
		while (true){
			dividend = dividend%divisor*10;
			start = contains(indexes, dividend); 
			//if we have previously seen this dividend, we know we are in a repeating sequence
			if (start>=0 && i>0) break; 
			postdecimal.append("" + dividend/divisor);
			indexes.put(dividend, i); 
			i++;
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(predecimal);
		answer.append(postdecimal.substring(0, start));
		if (postdecimal.substring(start).equals("0")) {
			if (start==0) answer.append("0");
		}
		else answer.append("(" + postdecimal.substring(start) + ")");
		return answer.toString();
	}
	public static int contains(HashMap<Integer, Integer> map, int num){
		Integer res = map.get(num);
		if (res==null) return -1;
		return res;
	}
}