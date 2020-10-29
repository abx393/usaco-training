import java.util.Arrays;

public class test {
	public static void main(String[] args){
		char[][] before = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
		System.out.println(toString(before));
		reflect(before);
		System.out.println(toString(before));
		
	}
	public static void rotate90(char[][] before){
		char[][] temp = new char[before.length][before.length];
		for (int i=0; i<before.length; i++)
			temp[i] = before[i].clone();
		for (int i=0; i<before.length; i++){
			for (int j=0; j<before.length; j++){
				before[i][j] = temp[before.length-1-j][i];
			}
		}
	}

	public static void reflect(char[][] before){
		char[][] temp = new char[before.length][before.length];
		for (int i=0; i<before.length; i++)
			temp[i] = before[i].clone();
		for (int i=0; i<before.length; i++){
			for (int j=0; j<before.length; j++){
				before[i][j] = temp[i][before.length-1-j];
			}
		}
	}
	public static String toString(char[][] before){
		String result = "";
		for (char[] arr: before){
			result += Arrays.toString(arr) + "\n";
		}
		return result;
	}
}
