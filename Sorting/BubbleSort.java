public class BubbleSort {
    
    static void bubbleSort(int[] arr,int n){
        
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                     swapped = true;
                }
            }

            if(swapped == false) break;
        }
    }

    // recursive
    static void bubble_sort(int[] arr, int n) {
        //Base case: range == 1.
        if (n == 1) return;

        int didSwap = 0;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = 1;
            }
        }

        // if no swapping happens.
        if (didSwap == 0) return;

        //Range reduced after recursion:
        bubble_sort(arr, n - 1);

    }
    
    public static void main(String[] args) {
        
        int[] arr = {12,3,6,9,1};
        int n = 5;
        bubbleSort(arr,n);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
