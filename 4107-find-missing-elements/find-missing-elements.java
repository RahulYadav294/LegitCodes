class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = min; i<=max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        if(list.size() == 0) return list;
        Collections.sort(list);
        return list;
    }
}