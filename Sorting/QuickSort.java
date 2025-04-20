package Sorting;

class QuickSort2 {
    
    void swap(int[] arr,int l,int h){
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
    int partition(int[] arr,int l,int h){

        int pivot = arr[l];
        int i =l,j=h;
        while(i<j){

            while(i<h && arr[i]<=pivot) i++;
            while(j>l && arr[j]>pivot) j--;
            
            if(i<j) swap(arr,i,j);

        }
        swap(arr,l,j);
        return j;
    }
    void quickSort(int arr[],int l,int h){

        if(l<h){

            int pivotIndex = partition(arr,l,h);
            
            quickSort(arr,l,pivotIndex-1);
            quickSort(arr,pivotIndex+1,h);
        }
    }

    public static void main(String[] args) {
        
        int[] arr = {5,23,8,1,8,43,3,9};

        new QuickSort2().quickSort(arr, 0, 7);

        for(int i=0;i<8;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
