package BS;
/*Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.
 N = 5, arr[] = {1,2,3,4,5}, limit = 8
3
Explanation:
 We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.
*/

public class SmallestDivisor {

    // BRUTE FORCE 
    // As we seen that we are going from 1 to maxElement and check for each that is the divisor such that element sub getting below limit
    // time : O(max(arr[])*N)
    private static boolean checkDivisor(int[] arr,int n,int limit,int divsor){

        int total = 0;

        for(int i=0;i<n;i++){
            total += Math.ceil((double)arr[i]/(double)divsor);
        }

        if(total <= limit){
            return true;
        }
        return false;
    }
    private static void findSmallDivisor(int[] arr,int n,int limit){

        int maxEle = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            maxEle = Math.max(maxEle,arr[i]);
        
        for(int i=1;i<=maxEle;i++){

            if(checkDivisor(arr,n,limit,i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }


    // OPTIMAL USING BINARY SEARCH
    // Instead of checking from 1 to max[arr[]]  we will try to eliminate the parts
    // TC : O(log(max(arr[]))*N)
    private static void findSmallDivisor1(int[] arr,int n,int limit){

        int maxEle = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            maxEle = Math.max(maxEle,arr[i]);
        
        int low = 1;
        int high = maxEle;

        while(low<= high){

            int mid = (low+high)/2;

            if(checkDivisor(arr,n,limit,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        System.out.println(low);
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,7,2,4,3,2,6};
        findSmallDivisor1(arr,arr.length,10);
    }
}
