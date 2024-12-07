
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6

//Input: height = [4,2,0,3,2,5]
// Output: 9

// We have to get how much units of water we can trap between the differently heighted boxes

public class TrappingRainwater {
    

    // Brute force solution : 
    /*Approach: For each index, we have to find the amount of water that can be stored and we have to sum it up.
    If we observe carefully the amount the water stored at a particular index is the minimum of maximum elevation to the left and right of the index minus the elevation at that index.
    */
    // TC : O(N^2)
    // SC : O(1)
    static void trapRainWater_brute(int[] arr,int n){

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        System.out.println(waterTrapped);
    }

    // we can optimize the above by taking extra space and storing the leftMax and rightMax in diff array such that at index i we have leftMax[i] as left max and rightMax[i] as right max to that element

    // Better solution : 
    // TC : O(N+N+N) = O(3N)
    // SC : O(2N) for left and right

    static void trapRainWater_better(int[] height,int n){

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        // we are checking the max of the last max which we putted in leftMax or the current element and putting that into left[i]
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;

        for(int k=0;k<n;k++){
            int minElement = Math.min(left[k],right[k]);
            ans += (minElement-height[k]);
        }
        System.out.println(ans);
    }
    
    // Better solution optimize : 
    // Instead of taking the prefixMax / Left array we can take the max element till now and take the suffixMax[] / right[] array
    // TC : O(3N)
    // SC : O(N) instead of O(2N) before.


    // Optimal Solution : 
    // TWO POINTERS APPROACH 
    // TC : O(N)
    // SC : O(1)
    // arr = [0,1,0,2,1,0,1,3,2,1,2,1] and Suppose we are at index 5 , ele = 0, leftmax = 2 and rightmax = 3
    // we are adding water units as min(leftmax,rightmax)-ele = 2-0=2 [here we saw that we don't need rightmax]
    // only we need is the smaller of them(leftmax,rightmax)
    // 1. If we travser from L to R or R to L , we don't get the other side of any building , observation is we will think about 2 way travsersal
    // below we are always traversing the smaller building its either left one or right one
    static void trapRainWater_optimal(int[] height,int n){

        int leftMax =0,rightMax = 0;
        int left = 0,right = n-1;

        int trappedWater=0;

        while(left <= right){
            // everytime we are going on left/on right whose building is small

            if(height[left] <= height[right]){ // here we think on the right someone is greater then curr.
                if(height[left] >= leftMax)
                    leftMax = height[left]; // if the current building is the taller one
                else
                    trappedWater += (leftMax-height[left]); // we assumed we have someone rgeater then curr on the right side(coz we took the lesser height building among left and right)
                    // as we are taking the smallest element (at left/right index) we can store leftmax of water on the current building.
                left++;
            }else{
                if(height[right] >= rightMax)
                    rightMax = height[right];
                else
                    trappedWater += (rightMax-height[right]);
                right--;
            }
        }
        System.out.println(trappedWater);

    }
    public static void main(String[] args) {
        
        int[] height = new int[]{4,2,0,3,2,5};
        trapRainWater_optimal(height,height.length);

    }
}
