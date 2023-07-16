class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        
        for (int right = 0; right < chars.length; right++) {
            maxCount = Math.max(maxCount, ++count[chars[right] - 'A']);
            if (right - left + 1 - maxCount > k) {
                count[chars[left] - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}