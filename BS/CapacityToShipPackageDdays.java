package BS;
/*A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days. */

/* N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
 rrsult = 9

 if 9 is max capacity of ship then Day-1 (5,4) Day-2 (5,2) Day-3(3,4) Day-4(5) Day5(6)

  N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
    result = 55 (as thier is only one day we have to load all the thinggs single day so totalLoadCapacity is ans)
*/
public class CapacityToShipPackageDdays {
    

    // brute force
    // TC : O(N * (sum(weights[]) - max(weights[]) + 1))
    // Here we will go by  is to check all possible capacities from max(weights[]) to sum(weights[]). The minimum number for which the required days <= d value
    public static int calculateDays(int daily,int[] weights,int n){

        int load = 0;
        int days = 1; // first day
        for(int i=0;i<n;i++){
            // here what we did
            // after adding current weight first check if its greater then the daily maximum limit
            // yes - then we will load weight till now and make day++ & load the current weight now for the next day
            // no - we can add that weight for the same day only coz it have not crossed the daily max weight limit
            if((load + weights[i])>daily){
                days++; // by adding current weight its overloading the daily max weight so add this load to next day
                load = weights[i]; // load the weight
            }else{
                load +=  weights[i]; // load weight on same day
            }
        }
        return days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        
        int n= weights.length;
        int maxW = Integer.MIN_VALUE;
        int totalSumW = 0;
        for(int i=0;i<n;i++){
            maxW = Math.max(maxW,weights[i]);
            totalSumW += weights[i];
        }

        for(int i=maxW;i<=totalSumW;i++){

            int daysTaking = calculateDays(i,weights,n);
            if(daysTaking <= days){
                return i;
            }
        }
        return -1;
    }
    //----------------------------------------------------------------------

    // OPTIMAL :  by taking the limit for the weights from max(arr) to totalSum(arr) 
    // and checking the days for that weight
    // suppose if we take x limit weight, how any days its taking to load
    // if the days its taking is less then the given days we can decrease the limit (we can eliminate the right half)
    // and if the days taking using the weight we passed if greater then max days limit given then we have to increase the weight (eliminate left part)

    //TC :O(N * log(sum(weights[]) - max(weights[]) + 1))
    public static int shipWithinDays1(int[] weights, int days) {
        
        int n= weights.length;
        int maxW = Integer.MIN_VALUE;
        int totalSumW = 0;
        for(int i=0;i<n;i++){
            maxW = Math.max(maxW,weights[i]);
            totalSumW += weights[i];
        }
        if(days==1) return totalSumW;
        int low = maxW;
        int high = totalSumW;

        while(low <= high){

            int mid = (low+high)/2;
            int daysTaking = calculateDays(mid,weights,n);

            if(daysTaking > days){
                // if the days taking to ship taking much days then limit we have to increase the load 
                // eliminating left part
                low = mid+1;
            }else{ // if the days taking to ship less days then limit we can decrease the load
            //eliminating right part
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        
        int capacity = shipWithinDays1(weights,5);
        System.out.println(capacity);

    }
}
