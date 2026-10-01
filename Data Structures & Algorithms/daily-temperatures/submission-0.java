class Solution {
    public int[] dailyTemperatures(int[] t) {
        //brute force approch
        // int[] res = new int[t.length];
        // for(int i =0; i<t.length ; i++){
        //     int curr = t[i];
        //     for(int j=i+1; j<t.length; j++){
        //         if(t[j] > curr){
        //             res[i] =  j-i;
        //             break;
        //         }
        //     }
        // }
        // return res;

    int[] res = new int[t.length];
    Stack<Integer> stack = new Stack<>();
    for(int i=0; i<t.length; i++){
        while(!stack.empty() && t[stack.peek()] < t[i]){
            Integer pop = stack.pop();
            res[pop] = i - pop;
        }
        stack.push(i);
    }

       return res; 
    }
}
