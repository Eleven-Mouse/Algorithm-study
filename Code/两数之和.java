//题目：
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
//你可以按任意顺序返回答案。




//核心思路：
// 1. 遍历数组，对于每一个元素，在数组中寻找另一个元素，使得两者的和等于目标值
// 2. 时间复杂度O(n^2)
class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int len = nums.length;
        for(int i = 0;i < len ;i++)
        {
            for(int j = i+1;j < len ;j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}