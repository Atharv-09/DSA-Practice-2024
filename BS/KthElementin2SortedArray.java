package BS;

public class KthElementin2SortedArray {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        if(n1 > n2) return kthElement(k,arr2,arr1);
        int left = k;
        int low = Math.max(0,k-n2); // low will be atleast k-n2 ,
        int high = Math.min(n1,k); // if we want 2nd element out of arr1 having n1 element it doesn;t make sence t
        // to pick all the elements
        
        while(low <= high){
            
            int mid1 = (low+high)/2;
            int mid2 = left-mid1; // from arr2
            
            int l1 = Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;
            
            if(mid1-1 >= 0) l1 = arr1[mid1-1];
            if(mid2-1 >= 0) l2 = arr2[mid2-1];
            
            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
            
        }
        
        return 0;
    }
}
