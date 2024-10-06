
//Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
// input {1,3,2} - > output {2,1,3} as the permutations are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}

public class NextPermutation {
    
    // Timem : O(n! x n) Space :O(N)
    // Calculte all the permutation of the array and then linear search and find the given array and return the next permutation of given array

    

    // TIME : O(3N) Space: O(1) / If we modifying array -> O(N)
    static int[] reverse(int arr[],int x,int y){

        while(x<y){
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            x++;
            y--;
        }
        return arr;
    }
    static int[] nextPermute(int[] arr,int n){

        int breakP = -1;
        // 1. Find the breakpoint from last such that we can increase 1 element affter that will make the new lexiographycal number greater then that given array no
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                breakP = i;
                break;
            }
        }
        // means thier is no deep -> arr[] = [5,4,3,2,1] ans = [1,2,3,4,5]
        if(breakP == -1){
            return reverse(arr,0,n-1);
        }


        //2. find the element that is slightly greater then the breakpoint eleemnt
        for(int i=n-1;i>breakP;i--){
            if(arr[i] > arr[breakP]){
                int temp = arr[i];
                arr[i] = arr[breakP];
                arr[breakP] = temp;
                break;
            }
        }

        //3. revere the array from breakP+1 to n
        return reverse(arr, breakP+1, n-1);

        

    }
    public static void main(String[] args) {
        
        int[] arr= new int[]{2,1,3};

        int[] ans = nextPermute(arr,arr.length);
        
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
