/*
ID: abandar1
LANG: JAVA
TASK: crypt1
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class crypt1 {
	public static int a, b, c, d, e;
	public static int[] digits;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("crypt1.in"));
		int N = sc.nextInt();
		int[] temp = new int[N];
		for (int i=0; i<N; i++){
			temp[i] = sc.nextInt();
		}
		digits = temp;
		//System.out.println(Arrays.toString(digits));
		sc.close();
		
		PrintWriter out = new PrintWriter(new File("crypt1.out"));
		
		int numSolutions = 0;
		
		for (int i=0; i<N; i++){ 
			a= digits[i];
			for (int j=0; j<N; j++){
				b = digits[j];
				for (int k=0; k<N; k++){
					c = digits[k];
					for (int l=0; l<N; l++){
						d = digits[l];
						for (int m=0; m<N; m++){
							e = digits[m];
							int product = c*e;
							if (fails(product%10)) continue;
							int product2 = (b*e+product/10);
							if (fails(product2%10)) continue;
							int product3 = (a*e + product2/10);
							if (fails(product3)) continue;
							int p1 = 100* (product3%10) + 10*(product2%10) + product%10;
							
							int prod = c*d;
							if (fails(prod%10)) continue;
							int sum1 = prod%10+product2%10;
							if (fails(sum1%10)) continue;
							
							int prod2 = (b*d+prod/10);
							if (fails(prod2%10)) continue;
							int sum2 = prod2%10 + product3%10 + sum1/10;
							if (fails(sum2%10)) continue;
							
							int prod3 = (a*d + prod2/10);
							if (fails(prod3)) continue;
							int sum3 = prod3 + sum2/10;
							if (fails(sum3)) continue;
							
							int p2 = 100* (prod3%10) + 10*(prod2%10) + prod%10;
							/*System.out.println(" " + a+b+c + "\nx " + d + e );
							System.out.println("-----------");
							System.out.println(" " + p1);
							System.out.println(p2);
							System.out.println(p1 + 10*p2);
							System.out.println();*/
							numSolutions++;
						}
					}
				}
			}
		}
		out.println(numSolutions);
		out.close();
	}
	
	public static boolean fails(int x){
		for (int i=0; i<digits.length; i++){
			if (x==digits[i]) return false;
		}
		return true;
	}
	public static boolean isPrime (int x) {
		for (int i=2; i<x; i++){
			if (x%i==0) return false;
		}
		return true;
	}
}
