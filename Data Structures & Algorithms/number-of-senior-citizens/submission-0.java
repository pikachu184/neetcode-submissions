class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String d : details){
            int a = d.charAt(11) - '0';
            int b = d.charAt(12) - '0';

            int ageval = a*10+b;
            if(ageval > 60){
                count++;
            }
        }

             return count;  
    }
}