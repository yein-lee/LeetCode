class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        
        int [] s1Count = new int[26];
        int [] s2Count = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            s1Count[s1.charAt(i)-'a'] += 1;
            s2Count[s2.charAt(i)-'a'] += 1;
        }
        
        for(int i=s1.length(); i<s2.length(); i++){
            if(this.containsPermutaition(s1Count, s2Count)) return true;
            
            s2Count[s2.charAt(i)-'a'] += 1;
            s2Count[s2.charAt(i-s1.length())-'a'] -= 1;
        }
        
        if(this.containsPermutaition(s1Count, s2Count)) return true;
        return false;
        
    }
    
    
    private boolean containsPermutaition(int[] c1, int[] c2){
        for(int i=0; i<26; i++){
            if(c1[i]!=0 && c1[i]!=c2[i]) return false;
        }
        return true;
    }
}