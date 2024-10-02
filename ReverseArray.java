public class ReverseArray {
    public void reverseArray(int arr[]) {
        // code here
        
        reverse(arr,0,arr.length-1);
        
    }
    
    // using extra space we can copy the array from back to first into that array
    // time : O(n) space : O(n)
    
    // using 2 pointer first and last and swap the values
    // time: O(n) 
    
    // using recursion below
    // time : O(n)
    
    void reverse(int[] arr,int left,int right){
        
        if(left < right) {
        
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            reverse(arr,left+1,right-1);
        }
    }
}
