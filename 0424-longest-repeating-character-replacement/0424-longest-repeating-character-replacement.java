class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);

            if ((r - l + 1) - Collections.max(count.values()) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}