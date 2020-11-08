/*
ID: abandar1
LANG: JAVA
TASK: dualpal
 */

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class dualpal {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("dualpal.in"));
		final int N = sc.nextInt();
		final int S = sc.nextInt();
		sc.close();
		PrintWriter out = new PrintWriter(new File("dualpal.out"));

		int j = 0;
		int  count2 = 0;
		while (count2 < N){
			int num = S + 1 + j;
			int count = 0;
			for (int i = 2; i <= 10; i++) {
				if (isPalindrome(toBase(num, i))) count++;
				if (count == 2) break;
			}
			if (count == 2) {
				out.println(num);
				count2++;
			}
			j++;
		}
		out.close();
	}
	
  // Converts any int number to the specified base
	public static String toBase(int i, int base){
		if (i == 1) {
      return "1";
    } else if (i == 0) {
			return "";
		} else {
			return toBase(i / base, base) + i % base;
		}
	}
	
  // Returns whether a string is a palindrome
	public static boolean isPalindrome(String str){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
		String reverse = "";
		while (!stack.isEmpty()){
			reverse += stack.pop();
		}
		if (reverse.equals(str)) return true;
		return false;
	}
}
