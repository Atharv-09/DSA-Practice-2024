package BS;

public class KthMissingElement {
    
    // brute force : 
    // check each element and 
    //Note: The main idea is to shift k by 1 step if the current element is smaller or equal to k. And whenever we get a number > k, we can conclude that k is the missing number.

    public static void findKthMissingEle(int[] arr,int n,int k){

        // 2 3 4 7 11
        // 1 2 3 4 5 6 7 8 9 10 11 k=5
        // so we skipped 2,3,4 so 1+3,+1(5),

        for(int i=0;i<n;i++){
            if(arr[i] <= k) k++;
            else break;
        }
        System.out.println(k);
    }
    //2 3 4 7 11
    //1 2 3 4 5 - ideal array is nothing is missing
    //1 1 1 3 6 - numbers missing before that element
    // 1 2 3 4 5 6 7 8 9 10 11 (before 11 -> 6 elements are missing i.e. 1,5,6,8,9,10)
    // but we want 5th or kth missing number so that means, IN missing number array [1,1,1,3,6] we can say 5th missing number is between 3&6
    // we can say missing number lies between 7 and 11
    // Now we can apply BS and get that index

    public static void findKthMissingEle1(int[] arr,int n,int k){

        int left = 0;
        int right = n-1;

        while(left <= right){   

            int mid = (left+right)/2;
            //we have to calculate missing no on basis of the index and the currentELement
            int missing = arr[mid]-(mid+1); // For 4 =  4-(2+1) = 1
            if(missing > k){
                right = mid-1; // eliminate the right half as the missing lies on left side
            }else{
                left = mid+1; // eliminate the left half as the missing lies on right side
            }
        }
        // what to return 
        // 2 3 4 7 11 [k=5]
        // 1 1 1 3 6 [missing nos]
        // left,right,mid at index=4 [in last phase] but missing at 4th index = 6 > k so right pointer will go to left side of mid
        // right at inde = 3, mid at ind = 4 , low at ind = 4

        // we want arr[high] + more (but here more we can say that we want 5th missing number but at value=7 it has 3 missing no before)
        // so can say arr[high]+(k-missing at high indeX) = 7+(5-3) = 9 (ans)

        // above return arr[high] but it fails for input 4 5 6 , k = 3 here the high index will go -ve index so we can't return that
        // SOLUTION TO RETURN : 

        // missing = arr[high] - (high+1) [7-(3+1)] = 3 is missing
        // ans = arr[high]+more & more = k-missing at high index
        /// ans = arr[high] + k - (arr[high]-(high+1))  => ar[high]+k-arr[high]+high+1
        
        
        // ans = high+1+k = low+k

        System.out.println(right+1+k);
    }


    /// SAME METHOD IN OTHERY WAY : 
    public int findKthPositive(int[] arr, int k) {
        
        int low = 0;
        int high = arr.length-1;
        if(arr[0] > k) return k;
        while(low <= high){

            int mid = low + (high-low)/2;
            int missToL = arr[mid]-mid-1;

            if(missToL < k){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }

        int missToH = arr[high]-high-1;
        int weNeedMore = k - missToH;
        return (arr[high]+weNeedMore);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,3,4,7,11};

        findKthMissingEle1(arr,arr.length,5);
    }
}
