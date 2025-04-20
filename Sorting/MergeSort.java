package Sorting;

class MergeSort1 {


    void merge1(int[] arr,int l,int h,int mid){

        int i=l;
        int j = mid+1;
        int k=l;
        int[] b = new int[h+1];

        while(i<=mid && j<=h){

            if(arr[i]<arr[j]){
                b[k++] = arr[i++];
            }else{
                b[k++] = arr[j++];
            }
        }

        if(i>mid){
            while(j<=h){
                b[k++] = arr[j++];
            }
        }else{
            
            while(i<=mid){
                b[k++] = arr[i++];
            }
        }

        for(int m=l;m<=h;m++){
            arr[m] = b[m];
        }
    }
    void merge(int[] arr,int l,int h,int mid){

        int n1 = mid-l+1;
        int n2 = h-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0;i<n1;i++)
            left[i] = arr[i+l];
        for(int i=0;i<n2;i++)
            right[i] = arr[mid+1+i];
        
        int i=0,j=0;
        int k = l;
        while(i<n1 && j<n2) {
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
        
    }
    void mergeSort(int[] arr,int l,int h){

        if(l<h){
            int mid = l+(h-l)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr,mid+1,h);

            merge1(arr,l,h,mid);
        }
    }
    
    public static void main(String[] args) {
        
        int[] arr = {6,12,7,8};

        new MergeSort1().mergeSort(arr,0,3);
        
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
