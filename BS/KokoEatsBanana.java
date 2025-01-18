package BS;
/* KOKO EATING BANANA
 * Problem Statement: A monkey is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
 */


public class KokoEatsBanana {
 
    // BRUTE we will take from 1banana/hr to the max of piles of banana/hr and check if the hr matches or not

    static int calulateTotalHr(int[] piles,int hourlyBanana){
        int totalHrTaken = 0;
            for(int j=0;j<piles.length;j++){
                totalHrTaken += Math.ceil((double)piles[j]/(double)hourlyBanana);
            }
            return totalHrTaken;
    }
    static void findBananasToEatPerHr(int[] piles,int hr){

        // return k bananase per hr koko can eat
        int maxBananasInPiles = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxBananasInPiles = Math.max(maxBananasInPiles, piles[i]);
        }
        // take each values 1 b/hr, 2b/hr and check if their total hr to eat == hour gievn
        for(int i=1;i<=maxBananasInPiles;i++){
                int totalHr = calulateTotalHr(piles, i);
                if(totalHr == hr){
                    System.out.println(i);
                    return;
                }
            
        }
    }
    
    // OPTIMAL - BINARY SEARCH 
    // TC :  O(N * log(max(a[])))
    // as we are linearly checking the banana/hr from 1 to maxBananaInPiles
    // Insttead we can take mid numberofBananas/hr and check is that the banana per hour satisfying the condition
    // if that number of bananas per hour is less then  given hr then we can decrease the count of banana per houur, so we will go lefter side (eliminate right side)
    // if no of bananas per hour is more then given hr then we can increase of count of eating banana per hour, by taking max number of bananas so we will go right side (eliminate left side)

    static void findBananasToEatPerHr1(int[] piles,int hr){
        int n = piles.length;

        int maxBananaInPiles = calculateMax(piles,n);
        
        int low = 1;
        int high = maxBananaInPiles;

        while(low<=high){

            int mid = (low+high)/2;
            int totalHrTakesByEatingMidBananas = calulateTotalHr1(piles,mid);

            if(totalHrTakesByEatingMidBananas <= hr){
                high = mid-1; // we can increase hourse by eating less bananas
            }else{
                low = mid+1;
            }

        }
        System.out.println(low);

    }
    static int calulateTotalHr1(int[] piles,int hourlyBanana){
        int totalHrTaken = 0;
            for(int j=0;j<piles.length;j++){
                totalHrTaken += Math.ceil((double)piles[j]/(double)hourlyBanana);
            }
            return totalHrTaken;
    }
    private static int calculateMax(int[] piles, int n) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Integer.max(max, piles[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        
        int[] piles = new int[]{7,15,6,3};
        int hr = 4;
        findBananasToEatPerHr1(piles,hr);
    }
}
