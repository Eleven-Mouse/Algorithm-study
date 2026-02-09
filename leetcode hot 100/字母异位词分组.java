//题目：
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是指字母相同，但排列不同的字符串。
//示例 :
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

//核心思路：
// 1. 遍历字符串数组，将每个字符串转换为字符数组，排序后得到排序后的字符串作为key，将字符串添加到map中
// 2. 遍历map，将key对应的value转换为list，并添加到结果list中
// 3. 返回结果list
class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}