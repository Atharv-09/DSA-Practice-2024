public class ArraySortedAndRotated {
    

    public void check(int[] arr,int n){

        int breakIndex = 0;

        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                breakIndex  = i;
                break;
            }
        }

        int[] copy = new int[n];

        for(int i=0;i<n;i++){
            copy[(i+breakIndex)%n] = arr[i];
        }

        for(int i=0;i<n;i++){
            System.out.print(copy[i] +" ");
        }


    }

    public boolean check1(int[] nums,int n){
        
            int count = 0;
            // for(int i=0;i<n-1;i++){
            for(int i=0;i<n;i++){
    
                // if(nums[i] > nums[i+1])
                if(nums[i] > nums[(i+1)%n]) // to check the last element also, instead of suing loop till n-1 and check condition at last 
                    count += 1;
            }
            
            // if(nums[n-1] > nums[0]) count++;
    
            if(count <= 1) return true;
            else return false;
        
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{11,12,13,14,1,4,6,9,10};
        new ArraySortedAndRotated().check(arr, arr.length);

        System.out.println(new ArraySortedAndRotated().check1(arr,arr.length));
    }
}
