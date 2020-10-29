
public class dptrial {
	public static void main(String[] args) {
		System.out.println(longestsubseq(new int[] {10,8,9,4,6,3}));
		System.out.println(longestsubseq(new int[] {1, 2, 3}));
		System.out.println(longestsubseq(new int[] {3, 2, 1}));
	}
	public static int longestsubseq(int[] nums){
		int[] bestrun = new int[nums.length];
		int j=0;
		bestrun[0] = nums[nums.length-1];
		for (int i=nums.length-2; i>=0; i--){
			if (nums[i]>bestrun[j]) bestrun[++j] = nums[i];
			else if (nums[i]<bestrun[j]) bestrun[j] = nums[i];
		}
		return j+1;
	}
}
