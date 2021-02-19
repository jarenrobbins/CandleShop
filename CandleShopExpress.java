/**
 * ITSC 1212 CandleShopExpress class
 * Created by Bruce Long and Modified by Adam Whaley
 *
 * RUN THIS SIMULATION MULTIPLE TIMES TO SEE HOW THE RESULTS ARE RANDOMIZED
 *
 */
public class CandleShopExpress {

  public static void main(String[] args) {

    int numType1 = (int)(Math.random()*11);  // Number of Type 1 candles being bought
    int numType2 = (int)(Math.random()*11);  // Number of Type 2 candles being bought
    int numType3 = (int)(Math.random()*11);  // Number of Type 3 candles being bought
    // Create a CandlePurchase object that will track and calculate the purchase information
    CandlePurchase purchase = new CandlePurchase(numType1,numType2,numType3);


    purchase.getPurchaseBreakdown();
  }



}
