package BS;

public class KthElementin2SortedArray {

    // Brute force
    // Usin third merged sorted array
    // TC : O(n+m) SC : O(n+m)
    public static int kthElement1(int m,int arr1[],int arr2[]){

        int n1 = arr1.length;
        int n2 = arr2.length;

        int n = n1+n2;
        int[] arr3 = new int[n];

        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        while(i<n1){
            arr3[k++] = arr1[i++];
        }
        while(j<n2){
            arr3[k++] = arr2[j++];
        }

        return arr3[m-1];
    }
    // Better approachj
    // INstead of using extra space we don't want eacg element in the array we just want k th element
    // we just take the count of the element as we reached to the count k we will return that

    public static int kthElement2(int m,int arr1[],int arr2[]){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int ele = -1;
        int n = n1+n2;
        int i=0,j=0,count=0;

        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                if(count == m-1) ele = arr1[i];
                count++;
                i++;
            }else{
                if(count == m-1) ele = arr2[j];
                count++;
                j++;
            }
        }

        while(i<n1){
            if(count == m-1) ele = arr1[i];
            i++;
            count++;
        }
        while(j<n2){
            if(count == m-1) ele = arr2[j];
            j++;
            count++;
        }
        
        return ele;
    }
    // OPTIMAL APPROACH
    public static long kthElement(int k, int arr1[], int arr2[]) {
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

    public static void main(String[] args) {
        
        int[] arr1 = new int[]{1,4,5,6,8,9,10};
        int[] arr2 = new int[]{2,2,2,4,7,8};

        System.out.println(kthElement2(9,arr1,arr2));
    }
}
