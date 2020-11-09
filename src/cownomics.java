import java.util.*;
import java.io.*;

public class cownomics {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] spotty = new String[N][M];
		String[][] plain = new String[N][M];
		
		for (int i=0; i<N; i++){
			String s = br.readLine();
			for (int j=0; j<M; j++){
				spotty[i][j] = s.charAt(j) + "";
			}
		}
		for (int i=0; i<N; i++){
			String s = br.readLine();
			for (int j=0; j<M; j++){
				plain[i][j] = s.charAt(j) + "";
			}
		}
		br.close();
		
		int count = 0;
		for (int i=0; i<M; i++){
			for (int j=i+1; j<M; j++){
				A: for (int k=j+1; k<M; k++){
					TreeSet<Integer> nums = new TreeSet<Integer>();
					for (int n=0; n<N; n++){
						nums.add(base4(spotty[n][i], spotty[n][j], spotty[n][k]));	
					}
					for (int l=0; l<N; l++){
						if (Arrays.binarySearch(nums.toArray(), base4(plain[l][i], plain[l][j], plain[l][k])) >= 0) continue A;
					
					}
					count++;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		out.println(count);
		out.close();
	}
	public static int base4(String a, String b, String c){
		String s = "ACGT";
		//HashMap<String, Integer> m = new HashMap<String, Integer>();
		return 16*s.indexOf(a) + 4*s.indexOf(b) + s.indexOf(c);
		/*
		m.put("A", 0);
		m.put("C", 1);
		m.put("G", 2);
		m.put("T", 3);
		*/
		//return 16*m.get(a) + 4*m.get(b) + m.get(c);
	}
}
