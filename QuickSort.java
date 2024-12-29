public class QuickSort {
    
    public static void main(String[] args) {
        int[] arr = new int[]{14,40,1,54};
        new QuickSort().quickSort(arr,0, 3);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }

    private void quickSort(int[] arr, int i, int j) {
        
        if(i<j){

            int pivotIndex = getPivotIndex(arr,i,j);
            quickSort(arr, i, pivotIndex-1);
            quickSort(arr, pivotIndex+1, j);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
    }

    private int getPivotIndex(int[] arr,int l,int h){

        int pivot = arr[l];
        int i = l;
        int j = h;


        while(i<j){

            //Here, we need to add some checks like i <= high-1 and j >= low+1. Because it might happen that i is standing at high and trying to proceed or j is standing at low and trying to exceed.

            while(i<=h-1 && arr[i]<=pivot) i++;
            while(j>=l+1 && arr[j]>=pivot) j--;

            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,j,l); // if we take high as pivot swap(i,h);
        return j;
    }

}
