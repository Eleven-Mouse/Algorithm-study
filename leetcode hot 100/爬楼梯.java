//题目：
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



//核心思路：
// 斐波拉契数列的前两个数是1，所以我们可以用两个变量来存储前两个数，然后用一个循环来计算后面的数。
// 时间复杂度：O(n)
// 空间复杂度：O(1)
class Solution
{
    int[] nums = new int[55];
    int result;
    public int climbStairs(int n)
    {
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 1;i < n ;i++)
        {
            nums[i+1] = nums[i] + nums[i-1];
            result = nums[i+1];
        }

        return (n <= 1)?1:result;

    }


}