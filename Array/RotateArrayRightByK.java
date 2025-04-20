public class RotateArrayRightByK {


    // Using 1 array for one part and other part we can move forward by k steps
    // TC : O(N) SC : O(N)

    static void rotateRight(int[] arr,int k,int n){

        int[] temp = new int[k];
        int m  =0;
        for(int i=n-k;i<n;i++)
            temp[m++] = arr[i];
        
        for(int i=n-k-1;i>=0;i--)
            arr[i+k] = arr[i];
        
        for(int i=0;i<k;i++)
            arr[i] = temp[i];
    }


    // TC : O(N) SC : O(1)
    static void reverse(int[] arr,int s,int e){

        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;e--;
        }
    }
    static void rotateRightUsinReversalAlgo(int[] arr,int k,int n){

        k = k%n; //if we have let's say 101 to rotate, then we only rotate it 1 time not 101 times
        // if we have k =9 and n = 7 --> 9 % 7 = 2
        // then instead of rotation 9 time we will rotate only 2 times will make array as equal to we have rotated 9 times
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1);

    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,5,6,7,19,1,1,1,1,4,5,6};
        rotateRight(arr, 12, arr.length);
        // rotateRightUsinReversalAlgo(arr, 5, arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] +" ");
    }

    //LEFT 
    // O(N) and SP : O(N)
    public static void Rotatetoleft(int[] arr, int n, int k) {
        if (n == 0)
          return;
        k = k % n;
        if (k > n)
          return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
          temp[i] = arr[i];
        }
        for (int i = 0; i < n - k; i++) {
          arr[i] = arr[i + k];
        }
        for (int i = n - k; i < n; i++) {
          arr[i] = temp[i - n + k];
        }
      }
      // TC : O(N) SC : O(1)
      public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
          int temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start++;
          end--;
        }
      }
      // Function to Rotate k elements to left
      public static void Rotateeletoleft(int[] arr, int n, int k) {
        // Reverse first k elements
        Reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        Reverse(arr, k , n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
      }
}


