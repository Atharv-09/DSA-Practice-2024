package BS;
import java.util.*;

// LEETCODE : 1552. Magnetic Force Between Two Balls
// LINK : https://leetcode.com/problems/magnetic-force-between-two-balls/description/

public class AggresiveCows {
    // BRUTE FOR BY TAKING THE ALL THE MIN DISTANCE FROM 1 to (max-min)
    //TC : O(nlogn) + O(n*max(stalls[])-min(stalls[]))  -> nlogn to sort n to check is that min distance possible to place all cows
    public static int findMaxofMinDistBetweenCows(int[] stalls,int n,int cows){

        Arrays.sort(stalls);

        int minDist = 1;
        int maxDist = stalls[n-1]-stalls[0];

        for(int i=minDist;i<=maxDist;i++){
            // question we want max distance among the min distance of cows, thats why we are taking minDist from 1 to max-min
            // such that if the minDist x possible then we will increment minDist and check is that possible coz we want - MAXIMUM AMONG THE MINIMUM DISTANCES BETWEEN COWS
            if(canWePlaceCow(stalls,i,cows)){ // we are checking by taking i as the minDistance are we able to place all cows
                continue;
            }else{
                return i-1;
            }
        }
        return maxDist;
    }
    private static boolean canWePlaceCow(int[] stalls, int minDist, int cows) {
        
        int preCow = stalls[0]; // postition of last cow placed
        int cowsCount = 1; // no of cows placed
        for(int i=1;i<stalls.length;i++){
            int distance = stalls[i]-preCow; // if we place cow at ith distance the distance between ith cow and the previous cow.
            if(distance >= minDist){
                preCow = stalls[i];
                cowsCount++;
            }
            if(cowsCount >= cows) return true; // if we are able to place all the cows at the minDistance then we will return true
        }
        return false;
    }

    // OPTIMAL : O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
    // by taking the minDistance as the pointer frmo low = 1 to high 
    public static int findMaxofMinDistBetweenCows1(int[] stalls,int n,int cows){

        Arrays.sort(stalls);
        int low = 1; // minimum distance we can consider as 1 
        int high = stalls[n-1]-stalls[0]; // max distance we can consider as if we have 0  2 4 7 10 cows = 2; we can put 1st cow at 0 and 2nd cow at 10th so max can go 10-0 = 10
        int ans = Integer.MIN_VALUE;

        while(low <= high){

            int mid = (low+high)/2;

            if(canWePlaceCow(stalls,mid,cows)){
                ans = Math.max(ans,mid); // if suppose the minDist = 2 is possible we will put it ans and go for the maximum of min dist, go low = mid+1;
                    // now if mindDistt = 3 possile it will replace ans=2 with 3 as the 3 is maximum distance among the minDistance
                // if it is possible we want the maximum dist we will eliminate left half
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
        

    }
    public static void main(String[] args) {
        
        int stalls[] = new int[]{0,4,3,9,7,10};

         int ans = findMaxofMinDistBetweenCows1(stalls,stalls.length,2);
        
         System.out.println(ans);
    }
}   
