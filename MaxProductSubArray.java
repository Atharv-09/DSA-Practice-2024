//Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

// ip :  Nums = [1,2,3,4,5,0] o/p = 120 (1x2x3x4x5)
// ip :  Nums = [1,2,-3,0,-4,-5] o/p = 20 (-4x-5)


public class MaxProductSubArray {
    
    // Brute : Using 3 loops
    // Using i - 0 to n and j - i to n and k = i to j
    // check for each subarray sum is greater then maxSubArraySum

    // Better : Using 2 loops
    // TC : O(N^2)

    public static void maxProdSubArraySum(int[] arr,int n){
        int result = arr[0];
	    for(int i=0;i<arr.length-1;i++) {
	        int p = arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	            result = Math.max(result,p);
	            p *= arr[j];
	        }
	        result = Math.max(result,p);
	    }
	    System.out.println(result);   
    }


    
    // Optimal 2 : 

    // Observations : 1. If the given aray contains only +Ve integers then the whole arr product will maxproduct
    // 2. If the given array contains even number of -ve number then also whole arr product will maxProduct.
    //If the given array also contains an odd number of negative numbers: Now, an odd number of negative numbers when multiplied result in a negative number. Removal of 1 negative number out of the odd number of negative numbers will leave us with an even number of negatives. Hence the idea is to remove 1 negative number from the result

    // ex : 3 2 -1 4 5 -6 2 -3 1 2
    // if we have 3 -ve then ignore that -ve whose prefix product subarray or suffix product subarray is max
    // if we ignore -1 pre = [3,2] suf = [4,5,-6,2,-3,1,2]
    // if we ignore -6 pre = [3,2,-1,4,5] suf = [2,-3,1,2] .. etc
    // but what if it has 0 ?? then reset the pre,suf = 1;
    // - 1 3 -4 5 0 2 3 -1 -4 0 -3 1 3 {subarrays = {-1,3,-4,5} , {2,3,-1,-4} , {-3,1-3}}


    public static void maxProdSubArraySum1(int[] arr,int n){
        
        int maxProd = Integer.MIN_VALUE;
        int pre = 1,suf=1;

        for(int i=0;i<n;i++){

            if(pre == 0) pre =1;
            if(suf==0) suf = 1;

            pre = pre*arr[i];
            suf = suf*arr[n-i-1];

            maxProd = Math.max(maxProd,Math.max(pre,suf));
        }
        System.out.println(maxProd);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,-3,0,-4,-5,-6,19};

        maxProdSubArraySum1(arr,arr.length);

    }
}

/*
 * 
 * kadanes algorithm (DONT USE IN INTERFIEWS)
 * 	static int maxProductSubArray(int arr[]) {
    int prod1 = arr[0],prod2 = arr[0],result = arr[0];
    
    for(int i=1;i<arr.length;i++) {
        int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
        prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
        prod1 = temp;
        
        result = Math.max(result,prod1);
    }
    
    return result;
	}
*/