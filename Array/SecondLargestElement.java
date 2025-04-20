public class SecondLargestElement {
    
    public static void main(String[] args) {
        
        
        int[] arr = new int[]{12,35,3,11,19,89};
        secLargest(arr,arr.length-1);
    }
    // BRUTE FORCE

    /* We can use TC : O(n^2) by taking first largest element and on that basis the second largest element */
    /* We can use TC : O(nlogn) by sorting array elements and take the last second (if not having duplicates else looop from last to the second largest element) */

    // BETTTER
    // TC : O(n)+O(n)
    // SC : O(1) 
    public int getSecondLargest(int[] arr) {
        // Code Here
        
    
        int n = arr.length;
        
        if(n <= 1) return -1;
        if(n==2 && arr[0] == arr[1]) return -1;
        
        int maxEle = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(arr[i] > maxEle) maxEle = arr[i];
        }
        
        int secEleMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>secEleMax && arr[i]<maxEle)
                secEleMax = arr[i];
        }
        
        return secEleMax;
    }


    // OPTIMIZED
    // TC : O(N)
    // SC : O(1)
    public static void secLargest(int[] arr,int n){
        
        int secL = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;


        for(int i=0;i<arr.length;i++){

            if(arr[i] > large){
                secL = large;
                large = arr[i];
            }else if(arr[i] > secL && arr[i] < large){
                secL = arr[i];
            }
        }

        System.out.println("Largest Element : " + large + "\nSecond Largest : " + secL);
    }
}
