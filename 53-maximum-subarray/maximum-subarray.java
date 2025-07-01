class Solution {
    public int maxSubArray(int[] arr) {
       int sum=arr[0];
       int max=0;
       for(int i=0;i<arr.length;i++){
        if(max<0){
            max=0;
        }
        max+=arr[i];
        sum=Math.max(sum,max);
       }
       return sum;
    }
}