public class MergeSort {
    

    public static void main(String[] args) {
        
        int[] arr = new int[]{32,27,43,10};
        new MergeSort().mergeSort(arr,0, 3);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }

    void mergeSort(int arr[],int l,int r){

        if(l<r){
            int mid = l + (r-l)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);

            merge(arr,l,mid,r);
        }

        
    }

    void merge(int[] arr,int l,int mid,int r){

        int i = l;
        int j = mid+1;
        int k = l;

        int[] ans = new int[r+1];


        while(i <= mid && j<=r){
            if(arr[i] < arr[j]){
                ans[k++] = arr[i++];
            }else{
                ans[k++] = arr[j++];
            }
        }

        if(i>mid){
            while(j<=r){
                ans[k++] = arr[j++];
            }
        }else{
            while(i<=mid){
                ans[k++] = arr[i++];
            }
        }

        for(k=l;k<=r;k++){
            arr[k] = ans[k];
        }
    }
}


