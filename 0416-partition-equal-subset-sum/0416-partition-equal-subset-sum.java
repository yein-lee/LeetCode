class Solution {
   	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();

		if(sum%2 != 0){
			return false;
		}

		boolean [] dp = new boolean[sum/2 + 1];
		dp[0] = true;

		for(int i = 0; i < nums.length; i++){
			for(int j = dp.length - nums[i] - 1; j >= 0; j--){
				if(dp[j]){
					dp[j + nums[i]] = true;
				}
			}
		}

		return dp[dp.length - 1];
	}
}