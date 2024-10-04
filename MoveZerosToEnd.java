public class MoveZerosToEnd {


    // TIME : O(N) SPACE: O(N);

    // take the count of non zero element and put that elements into temp array
    // now again copy back that element into original array and append the 0 after that index
    
    /* 1. Take for loop 0 to n and count the non zero elements suppose k count
     * 2. Take for loop 0 to n and copy that non zero elements into temp[k] array
     * 3. Take for loop to n and check if index i>= k (means that will be the 0 element) arr[i] = 0
     *                                 else arr[i] = temp[i];
     */


    // TIME : O(N) SPACE : O(1)
        public void moveZeroes(int[] nums) {
            
            // j will point to first 0 eleemnt index
            // i will go from that j+1 index to n and point to element index to swap with the jth index (0 th element index)
            // p2 will point to the first zero index where we found 0 in starting
            // p1 will point next non-zero element index so that we can swap tjem
        int n = nums.length;
        int p2 = -1;
            for(int i=0;i<n;i++){
                if(nums[i] == 0){
                    p2 = i;
                    break;
                }
            }
    
            if(p2 == -1) return; // no 0 element are thier
            int p1 = p2+1;
    
            while(p1 < n){
                if(nums[p1] != 0){
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p2++;
                }
                p1++;
            }
        }
    
}
