class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        
        HashMap<Character, Integer> s2Map = new HashMap<>();
		for(int i=0; i<s1.length(); i++){
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (isMatch(s1Map, s2Map)) {
            return true;
        }
        
        for(int i=s1.length(); i<s2.length(); i++){
            char removeC = s2.charAt(i-s1.length());
            s2Map.put(removeC, s2Map.get(removeC)-1);
            char addC = s2.charAt(i);
            s2Map.put(addC, s2Map.getOrDefault(addC, 0)+1);
            if (isMatch(s1Map, s2Map)) {
                return true;
            }
        }

		return false;
	}
    
    private boolean isMatch(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map) {
        for (char key : s1Map.keySet()) {
            if (!s1Map.get(key).equals(s2Map.get(key))) {
                return false;
            }
        }
        return true;
    }
}