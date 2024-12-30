public class StockBuyAndSell1 {
    
    // Using brute force 
    // we will buy stock each day and try to sell each next al days and take the maxProfit
    // TC : O(N^2)

    // Using Optimal
    // TC : O(N)
    // as we will be taking the minPrice and traking the maxProfit(if it is max if sell the stock today )
    public int maxProfit(int[] prices) {
        
        int minBuy = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            minBuy = Math.min(prices[i],minBuy);
            maxProfit = Math.max(maxProfit, prices[i]-minBuy);
        }
        return maxProfit;
    }

    // Using 2 pointer apprach
    // we will take 2 pointer left and right and put at 0,1 index
    // such that left pointer will always pointes to the lowst and right will move
    // We always want our left point to be minimum

    public static int maxProfit1(int[] prices) {

        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while(right < prices.length){
            // if the left is greater then right then simply assign the right index to left and increment right
            // if smaller then just check the maxProfit that whether we buy at left day adn sell at right day whether its making max Profit

            if(prices[left] < prices[right]){
                maxProfit = Math.max(maxProfit,prices[right]-prices[left]);
            }else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    // Other way to get the buy and sell values with maxProfit
    public static void stockBuySell(int[] arr,int n){

        int maxProfit = 0;
        int minPrice = arr[0];
        int butAt=0,sellAt=0;
        for(int i=1;i<n;i++){

            // maxProfit = Math.max(maxProfit,arr[i]-minPrice);
            if((arr[i]-minPrice) > maxProfit){
                sellAt = i;
                maxProfit = arr[i] - minPrice;
            }
            // minPrice = Math.min(minPrice,arr[i]);
            if(arr[i] < minPrice){
                butAt = i;
                minPrice  = arr[i];
            }
        }

        System.out.println("But at rs. : " + arr[butAt] + " Sell at rs. : " + arr[sellAt] + " Max Profit : " + maxProfit);
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{7,7,1,5,3,6,4};

        stockBuySell(arr,arr.length);

        System.out.println(maxProfit1(arr));
    }
}
