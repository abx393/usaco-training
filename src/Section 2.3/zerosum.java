/*
ID: abandar1
LANG: JAVA
TASK: zerosum
*/

import java.util.*;
import java.io.*;

public class zerosum {
	public static int n;
	public static ArrayList<String> solutions = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("zerosum.in"));
		n = Integer.parseInt(br.readLine()); 
		br.close();
		
		generate(1, 2, "+1");
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		for (String s : solutions) out.println(s.substring(1));
		out.close();
	}
	public static void generate(int sum, int num, String path){
		if (num>n) {
			if (sum==0) solutions.add(path);
			return;
		}
		if (path.charAt(path.length()-2) == '-') generate(sum + num - 1 - (10*(num-1)+num), num + 1, path + " " + num);
		else if (path.charAt(path.length()-2) == '+') generate(sum - num + 1 + (10*(num-1)+num), num + 1, path + " " + num);
		generate(sum+num, num+1, path + "+" + num);
		generate(sum-num, num+1, path + "-" + num);
	}
}
