import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class namenum {
	public static char[][] map = {
			{},
			{},
			{'A', 'B', 'C'},
			{'D', 'E', 'F'},
			{'G', 'H', 'I'},
			{'J', 'K', 'L'},
			{'M', 'N', 'O'},
			{'P', 'R', 'S'},
			{'T', 'U', 'V'},
			{'W', 'X', 'Y'}
	};
	public static void main(String[] args) throws IOException {
		Scanner wordSc = new Scanner(new File("dict.txt"));
		Scanner sc = new Scanner(new File("namenum.txt"));
		final int NUM = sc.nextInt();
		String num = "" + NUM;
		sc.close();
		String words = "";
		while (wordSc.hasNext()){
			String word = wordSc.next();
			if (word.length()==num.length()) 
				words += word  + "\n";
		}
		wordSc.close();
		String[] dict = words.split("\n");
		//System.out.println(Arrays.toString(dict));
		
		ArrayList<String> result = new ArrayList<>();
		char[] inds = num.toCharArray();
		int[] indices = new int[inds.length];
		for (int i=0; i<indices.length; i++){
			indices[i] = Character.getNumericValue(inds[i]);
		}
				
		String word = "";
		int charIndex = 0;
		int numIndex = 0;
		find(charIndex, numIndex, indices, word, dict, result);
		
		PrintWriter out = new PrintWriter(new File("namenum.out"));
		for (String s: result){
			System.out.println(s);
		}
		out.close();
	}
	public static void find(int charIndex, int numIndex, int[] indices, 
			String word, String[] dict, ArrayList<String> result){
		if (word.length()==indices.length){
			if (Arrays.binarySearch(dict,  word)>=0) 
				result.add(word);
		} else {
			System.out.println(Arrays.toString(indices));
			System.out.println(numIndex + "  " + charIndex);
			System.out.println(word);
			System.out.println();
			word += map[indices[numIndex]][charIndex];
			find(charIndex, numIndex, indices, word, dict, result);
			word = word.substring(0,word.length()-1);
			if (charIndex<2) find(charIndex+1, numIndex, indices, word, dict, result);
			word = word.substring(0,word.length()-1);
			if (numIndex<indices.length-1) find(charIndex, numIndex+1, indices, word, dict, result);
			word = word.substring(0,word.length()-1);
		}
		
		
	}
	
}
