import java.io.*;
import java.util.*;
	
public class lamps {
	static boolean[] lit;
	static ArrayList<Integer> on = new ArrayList<Integer>(), off = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lamps.in"));
		int n = Integer.parseInt(br.readLine());
		
		lit = new boolean[n];
		Arrays.fill(lit, true); //all lamps are lit at the start
		int c = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		while (x!=-1){
			on.add(x-1);
			x = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		while (x!=-1){
			off.add(x-1);
			x = Integer.parseInt(st.nextToken());
		}
		
	}
}
