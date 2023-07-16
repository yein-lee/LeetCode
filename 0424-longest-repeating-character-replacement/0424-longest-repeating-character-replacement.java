class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxCount = 0, maxLength = 0;
        char[] chars = s.toCharArray();
        
        for(int right = 0; right < chars.length; right++) {
            char rChar = chars[right];
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            maxCount = Math.max(maxCount, map.get(rChar));

            if (right - left + 1 - maxCount > k) {
                char lChar = chars[left];
                map.put(lChar, map.get(lChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}