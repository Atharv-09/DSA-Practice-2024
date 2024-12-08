import java.util.Stack;

public class SumOfSuArraysMaximum {
    static int[] findNextMaximumElement(int[] arr,int n){

        Stack<Integer> st = new Stack<>(); // we wil store the indexes not tehe element
        int[] right = new int[n];

        for(int i=n-1;i>=0;i--){

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();

            st.push(i);
        }
        return right;
    }
     
    static int[] findPrevMaximumElement(int[] arr,int n){
        Stack<Integer> st = new Stack<>(); // we wil store the indexes not tehe element
        int[] left = new int[n];

        for(int i=0;i<n;i++){

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();

            st.push(i);
        }
        return left;
    }
    static int findSumOfMaxofSubarrays(int[] arr,int n){

        int total = 0;
        int mod = (int) (1e9 +7);
        int[] nextMaxElementIndexes = findNextMaximumElement(arr,n);
        int[] prevMaxElementIndexes = findPrevMaximumElement(arr,n);
    
        int left=0,right=0;
        for(int i=0;i<n;i++){
            
            left = i-prevMaxElementIndexes[i];
            right = nextMaxElementIndexes[i]-i;

            total += (long) (left) * (right) % mod * arr[i] % mod;
            total %= mod;
            // total = (long)(total + (right*left*arr[i])%mod) % mod;
        }
        return total;
    }
    // 2 1 3 4

    // 2 , 2 1 , 2 1 3 , 2 1 3 4 = 2+2+3+4
    // 1 , 1 3 , 1 3 4 = 1 + 3 + 4
    // 3 , 3 4 = 3 + 4
    // 4 = 4
    // 3 is coming 3 time + 2 is coming 2  times + 1 is coming 1 time + 4 is coming 4 times
    // ans = 3*3 +2*2+1*1 + 4*4 = 9+4+1+16 = 30 
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,1,3,4};
        System.out.println(findSumOfMaxofSubarrays(arr,arr.length));
    }
}
