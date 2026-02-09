/*
原地标记法（负数标记）：
前提：1. 数值范围与索引范围必须匹配
     2. 数组元素初始必须为正数（非负性）
     3. 原始数据信息必须可恢复
 */


class Solution {
    public int findDuplicate(int[] nums) {
        int m = -1;
        for(int i = 0; i < nums.length; i++){
            // 拿到当前的数字（取绝对值，因为可能已经被改成负数了）
            int cur = Math.abs(nums[i]);
            if(nums[cur] < 0){
                //找到重复数
                m = cur;
                break;
            }
            nums[cur] = -nums[cur];
        }
        //恢复数组，满足题意不修改nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return m;
    }
}
