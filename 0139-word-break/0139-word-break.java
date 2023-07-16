class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        
        for(int i = s.length() - 1; i>=0; i--){
            for(int j = i + 1; j <= s.length(); j++){
                if(dp[j] == true && wordDict.contains(s.substring(i, j))){
                    dp[i] = true;
                }
            }
        }
        
        return dp[0];
    }
}