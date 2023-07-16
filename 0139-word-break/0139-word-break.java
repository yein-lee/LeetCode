class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<=s.length(); j++){
                if(dp[j]>0 && wordDict.contains(s.substring(i, j))){
                    dp[i] = 1;
                }
            }
        }
        
        return dp[0] == 1;
    }
}