public class StockBuyAndSell1 {
    

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
    }
}
