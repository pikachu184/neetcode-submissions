class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    //  Map<Integer , Integer> map = new HashMap();
    //  int idx= 0;
    //  for(int i : nums){
    //     if(map.containsKey(i) && Math.abs(idx - map.get(i)) <= k){
    //      return true;
    //     }
    //     else{
    //         map.put(i , idx);

    //     }
    //     idx++;
    //  }   
    //  return false;

    Set<Integer> set = new HashSet();
    for(int i =0; i<nums.length; i++){
        if(set.contains(nums[i])){
            return true;
        }
        set.add(nums[i]);
        if(set.size() > k){
            set.remove(nums[i-k]);
        }
    }
       return false;
    }
}