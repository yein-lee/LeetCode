from collections import defaultdict

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        s1CharCount = defaultdict(int)
        for i in range(len(s1)):
            s1CharCount[s1[i]] += 1

        subStringCharCount = defaultdict(int)
        for i in range(len(s1)):
            subStringCharCount[s2[i]] += 1

        if subStringCharCount == s1CharCount:
            return True

        l = 0
        for r in range(len(s1), len(s2)):
            subStringCharCount[s2[r]] += 1
            subStringCharCount[s2[l]] -= 1
            filtered_dict = {key: value for key, value in subStringCharCount.items() if value >= 1}
            l += 1
            if filtered_dict == s1CharCount:
                return True

        return False
                