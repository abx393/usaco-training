/*
ID: abandar1
LANG: JAVA
TASK: palsquare
 */

import java.util.Scanner;
import java.util.Stack;
import java.io.*;

public class palsquare {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("palsquare.in"));
		int base = sc.nextInt();
		sc.close();
        
		char[] rep = new char[] {'0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G','H','I','J'};
        
		PrintWriter out = new PrintWriter(new File("palsquare.out"));
		for (int i=1; i<=300; i++){
			String square = toBase(i*i, base, rep);
			if( isPalindrome( square ) ){
				out.println(toBase(i, base, rep) + " " + square);
			}
		}
		out.close();
	}
	public static String toBase(int i, int base, char[] rep){
		//converts any int number to the specified base
		if (i==1) return "1";
		else if (i==0){
			return "";
		} else {
			return toBase(i/base, base, rep) + rep[i%base];
		}
	}
	public static boolean isPalindrome(String str){
		//returns whether a string is a palindrome
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<str.length(); i++){
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
