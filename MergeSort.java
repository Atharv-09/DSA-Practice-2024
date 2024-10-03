public class MergeSort {
    

    public static void main(String[] args) {
        
        int[] arr = new int[]{32,27,1,90,67,12,3,56,8,12,67,43,10};
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
        // int k = l;

        List<Integer> temp = new ArrayList<>();


        while(i <= mid && j<=r){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }

        if(i>mid){
            while(j<=r){
                temp.add(arr[j]);
                j++;
            }
        }else{
            while(i<=mid){
                temp.add(arr[i]);
                i++;
            }
        }

        for(int k=l;k<=r;k++){
            arr[k] = temp.get(k-l);
        }
    }
}


