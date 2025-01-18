package BS;

public class SearchSingleElementInSortedArr {
    // Brute force : Linearly traverse and check arr[i]==arr[i+1] if not then return that element
    // Using XOR : take xor of all the element the last element remaining is the single element

    // OPTIMAL : Using some obervation
    // we can see that the two pairs of element - first ele coming on even index and second ele coming on odd index
    // 1. condition we can consider that the mid element is the single elment by doing this - 
    // If arr[mid] != arr[mid-1] and arr[mid] != arr[mid+1]: If this condition is true for arr[mid], we can conclude arr[mid] is the single element.

    // The above condition will throw errors in the following 3 cases:

    // If the array size is 1.
    // If ‘mid’ points to 0 i.e. the first index.
    // If ‘mid’ points to n-1 i.e. the last index.

    //EDGE CASES RESOLVING:
    /*If n == 1: This means the array size is 1. If the array contains only one element, we will return that element only.
    If arr[0] != arr[1]: This means the very first element of the array is the single element. So, we will return arr[0].
    If arr[n-1] != arr[n-2]: This means the last element of the array is the single element. So, we will return arr[n-1]. */


    /*
     * The index sequence of the duplicate numbers in the left half is always (even, odd). That means one of the following conditions will be satisfied if we are in the left half:
        1. If the current index is even, the element at the next odd index will be the same as the current element.
        2. If the current index is odd, the element at the preceding even index will be the same as the current element.
       
        The index sequence of the duplicate numbers in the right half is always (odd, even). That means one of the following conditions will be satisfied if we are in the right half:
        1. If the current index is even, the element at the preceding odd index will be the same as the current element.
        2. If the current index is odd, the element at the next even index will be the same as the current element.

        We can easily check left and right halves : 

        If (i % 2 == 0 and arr[i] == arr[i+1]) or (i%2 == 1 and arr[i] == arr[i-1]), we are in the left half.
        If (i % 2 == 0 and arr[i] == arr[i-1]) or (i%2 == 1 and arr[i] == arr[i+1]), we are in the right half.

        How to eliminate the halves:

            1. If we are in the left half of the single element, we have to eliminate this left half (i.e. low = mid+1). Because our single element appears somewhere on the right side.
            2. If we are in the right half of the single element, we have to eliminate this right half (i.e. high = mid-1). Because our single element appears somewhere on the left side.
     */
    // even odd -> first second
    public static int findSingleElement(int[] arr,int n){

        // edge cases
        if(n==1) return arr[0];
        // if first element is single element
        if(arr[0]!=arr[1]) return arr[0];
        // if last element is single element
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-2;
        while (low<=high){

            int mid = low+(high-low)/2;
             
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            //we are in left half when
            // index is even and currElement == nextElement or index is odd and currElement == prevElement
            if((mid%2==1 && arr[mid] == arr[mid-1]) || (mid%2==0 && arr[mid] == arr[mid+1])){
                // skip left half
                low = mid+1;
            }else{ // we are at right half
                high = mid-1; // skip right part
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,1,2,2,3,3,4,5,5,6,6};

        System.out.println(findSingleElement(arr,arr.length));
    }
}
