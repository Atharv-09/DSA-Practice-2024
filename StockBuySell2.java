public class StockBuySell2 {
    
    // opitmal by me
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];
        int n = prices.length;
        int maxProfit = 0,pro =0;

        for(int i=1;i<n;i++){
            if(prices[i] > prices[i-1]){
                maxProfit = Math.max(maxProfit,prices[i]-buy);
            }else{
                pro += prices[i-1]-buy;
                buy = prices[i];
            }
            
            maxProfit = Math.max(pro,maxProfit);
        }
        maxProfit=Math.max(maxProfit,pro += prices[n-1]-buy);
        return maxProfit;
    }

    //other ehod
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit1(int[] prices) {
        
        int max = 0;    
        int buy = prices[0];

        for(int i=1;i<prices.length;i++){
            // add profit when the prices goes up then buy price 
            if(buy < prices[i]) 
                max += prices[i]-buy;
            buy = prices[i];
        }
        return max;
    }
}
