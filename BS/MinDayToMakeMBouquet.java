package BS;

public class MinDayToMakeMBouquet {
    
    // BRUTE FORCE APPROACH 
    // TC  :O((max(arr[])-min(arr[])+1) * N),
    // The extremely naive approach is to check all possible answers from min(arr[]) to max(arr[]). The minimum number for which possible() returns true, is our answer.

    // we will go from the minDay to maxDay and check if we take for minDay how many floower will bloom and is that satisfying the condition 

    public static int[] getMinMaxDays(int[] arr,int n){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min = Math.min(arr[i],min);
            max = Math.max(arr[i],max);
        }

        return new int[]{min,max};
    }
    public static int findNoOfDays(int[] arr,int noOfBouq,int noOfFlowersInBouq){

        int flowers = arr.length;

        int totalFlowerBN = noOfBouq*noOfFlowersInBouq;
        if(totalFlowerBN > flowers){
            return -1;
        }
        int[] day = new int[2];
        day = getMinMaxDays(arr,flowers);
        int getMinDay = day[0];
        int getMaxDay = day[1];
        
        for(int i=getMinDay;i<=getMaxDay;i++){
            if(isPossible(i,arr,noOfBouq,noOfFlowersInBouq)){
                return i;
            }
        }
        return -1;
    }
    private static boolean isPossible(int day, int[] arr, int noOfBouq, int noOfFlowersInBouq) {
        
        int count = 0,createBouquet=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i] <= day){
                count++;
            }else count = 0;
            // if the count is same as the noofflower we want in bouq we will create one bouquet and reset count
            if(count == noOfFlowersInBouq){
                createBouquet++;
                count = 0;
            }
            // if the no of bouquest we created equal to no of bouq we return true;
            if(createBouquet >= noOfBouq){
                return true;
            }
        }

        return false;
    }

    // _----------------------------------------------------------------------------------------------

    // OPTIMAL APPROACH
    // TC : O(log(max(arr[])-min(arr[])+1) * N)
    // Using BS in the between min and amx we took
    public static boolean isPossible1(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int count = 0;int noOfBooq =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfBooq = noOfBooq + (count/k); // if we got 6 flowers in continuation we we want to make bouquest using 3 flowers we will fo 6/k = 2
                count = 0;
            }
        }

        noOfBooq = noOfBooq + (count/k); //if we can create bouq at the last indexes
        return noOfBooq >= m;

        
    }
    public static int findNoOfDays1(int[] arr,int noOfBouq,int noOfFlowersInBouq){

        int flowers = arr.length;

        int totalFlowerBN = noOfBouq*noOfFlowersInBouq;
        if(totalFlowerBN > flowers){
            return -1;
        }
        int[] day = new int[2];
        day = getMinMaxDays(arr,flowers);
        int low = day[0]; // minimum day ew can take
        int high = day[1]; // maximum day we can take

        while(low <= high){

            int mid = (low+high)/2;

            if(isPossible1(arr, mid, noOfBouq, noOfFlowersInBouq)){
                // if using this mid day if possible we haev to go to left side i.e we want minDays to makebouquet
                high = mid-1; // elimnate right part
            }else{
                low = mid+1; // eliminate left part
            }
        }
        return low;
       
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{2,4,1,5,7,9,3,2};

        int m = 2;// no of bouquets
        int k = 3; // no of flowers in bouquet
        System.out.println(findNoOfDays(arr,m,k));
        System.out.println(findNoOfDays1(arr,m,k));
        
    }
}
