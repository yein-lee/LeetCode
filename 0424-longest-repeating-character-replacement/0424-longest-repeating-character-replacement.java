class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int maxCount = 0, maxLength = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, count.get(currentChar));

            if ((r - l + 1) - maxCount > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            } else {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength;
    }
}