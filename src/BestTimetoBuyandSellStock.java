/**
 * Created by fatjimmy on 17/7/28.
 */
//leetcode 121
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    public static void main(String[] args){
        int[] numbers = {7, 1, 5, 3, 6, 4, 0, 6};
        int result = maxProfit(numbers);
        System.out.println(result);
    }
}
