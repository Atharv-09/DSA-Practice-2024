class Main {

    static void selectionSort(int arr[],int n){

        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static void print(int[] arr,int n){
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+ " ");
    }
    public static void main(String[] args) {
        int arr[] = {64,25,107,12,22,788,11};
        selectionSort(arr,7);

        print(arr,7);
    }
}