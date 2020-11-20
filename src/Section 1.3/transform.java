/*
ID: abandar1
LANG: JAVA
TASK: transform
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class transform {
	private static char[][] before;
	private static char[][] after;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("transform.in"));
		int x = sc.nextInt();
		before = new char[x][x];
		after = new char[x][x];
		for (int i = 0; i < x; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				before[i][j] = s.charAt(j);
			}
		}
    `
		for (int i = 0; i < x; i++) {
			String s = sc.next();
			for (int j = 0; j<s.length(); j++) {
				after[i][j] = s.charAt(j);
			}
		}
		sc.close();
		PrintWriter out = new PrintWriter("transform.out");
		rotate90();
		if (equal()) {
			out.println(1); 
            out.close();
			return; 
		}

		rotate90();
		if (equal()){ 
			out.println(2); 
            out.close();
			return;
		}

		rotate90();
		if (equal()) {
			out.println(3); 
            out.close();
			return;
		}

		rotate90();
		reflect();
		if (equal()) {
			out.println(4); 
            out.close();
			return;
		}

		char[][] temp = before;
		if (checkCombo()) {
			out.println(5); 
            out.close();
			return;
		}

		before = temp;
		reflect();
		if (equal()) {
			out.println(6); 
            out.close();
			return;
		}

		out.println(7);
		out.close();
	}

	public static void rotate90() {
		char[][] temp = new char[before.length][before.length];
		for (int i = 0; i < before.length; i++)
			temp[i] = before[i].clone();
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before.length; j++) {
				before[i][j] = temp[before.length - 1 - j][i];
			}
		}
	}

	public static void reflect() {
		char[][] temp = new char[before.length][before.length];
		for (int i = 0; i < before.length; i++)
			temp[i] = before[i].clone();
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before.length; j++) {
				before[i][j] = temp[i][before.length - 1 -j];
			}
		}
	}
	
	public static boolean checkCombo() {
		for (int i = 0; i < 3; i++) {
			rotate90();
			if (Arrays.deepEquals(before, after)) return true;
		}
		return false;
	}

	public static boolean equal() {
		return Arrays.deepEquals(before, after);
	}
}
