class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        res = []
        per = []

        def dfs():
            if len(per) == len(nums):
                res.append(per.copy())

            for i in range(len(nums)):
                if nums[i] not in per:
                    per.append(nums[i])
                    dfs()
                    per.pop()

        dfs()
        return res
        