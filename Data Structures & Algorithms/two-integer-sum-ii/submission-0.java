class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0;
        int j = numbers.length - 1;
        while(i < j){
            int cursum = numbers[i] + numbers[j];
            if(cursum > target){
                j--;
            }else if(cursum < target){
                i++;
            }else{
                return new int[]{i+1 ,j+1};

            }
         }
         return new int[0];
        
    }
}
