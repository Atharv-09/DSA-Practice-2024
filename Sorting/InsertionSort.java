public class InsertionSort {
    
    static void insertionSort(int[] arr,int n){

        for(int i=1;i<n;i++){
            int curr= arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }

    // recursive
    static void insertion_sort(int[] arr, int i, int n) {
        // Base Case: i == n.
        if (i == n) return;

        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        insertion_sort(arr, i + 1, n);

    }
    public static void main(String[] args) {
        
        int[] arr = {4,3,2,10,12,1,5,6};
        
        insertionSort(arr,arr.length);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
