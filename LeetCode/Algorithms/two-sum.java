class Solution {
    public int[] twoSum(int[] nums, int target) {
        int b[] =new int[2];
         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
       // Map <Integer,Integer> map = new Hashmap<>();
        for(int i=0; i<nums.length;i++)
        {
            int otherPart =target - nums[i];
            if (map.containsKey(otherPart))
            {
                b[0] =map.get(otherPart);
                b[1] =i;
                break;
            }
            
            map.put(nums[i],i);
        }
        return b;
    }
    
}