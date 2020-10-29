/*
ID: abandar1
LANG: JAVA
TASK: fact4
*/

import java.io.*;

public class fact4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("fact4.in"));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int ans = 1;
		for (int i=2; i<=n; i++){
			String temp = "" + ans*i;
			int j=temp.length()-1;
			while (j>=0) {
				if (temp.charAt(j)!='0') break;
				j--;
			}
			String s = temp.substring(Math.max(0, j-2), j+1);
			ans = Integer.parseInt(s);
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		out.println(ans%10);
		out.close();
	}
}
