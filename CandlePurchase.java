/**
 * ITSC 1212 CandlePurchase class
 * Created by Adam Whaley
 *
 * 
 *
 */


public class CandlePurchase {
  
  //Declare fields for CandlePurchase
  private int numType1;
  private int numType2;
  private int numType3;
  private int totalNum;
  private final int DISCOUNT_THRESHOLD = 7;
  private final double DISCOUNT = .05;
  Candle type1 = new Candle(1, 2.5, (5*60),.01);    // Create a Candle object for a Type 1 candle
  Candle type2 = new Candle(2, 3.75, (7*60), .03);   // Create a Candle object for a Type 2 candle
  Candle type3 = new Candle(3, 5.99, (12*60), .05);  // Create a Candle object for a Type 3 candle
  
  public CandlePurchase(int numType1, int numType2, int numType3) {
    
    this.numType1 = numType1;
    this.numType2 = numType2;
    this.numType3 = numType3;
    this.totalNum = numType1 + numType2 + numType3;
    
  }
  
  public double getSubTotal() {
    
    //  COMPUTE THE COST OF THAT MANY CANDLES OF EACH TYPE 
    //  Right side: 
    //    1.  Call that Candle object's getCost method to return the cost for that type of candle 
    //    2.  Multiply that cost by the number of that type of candle being bought 
    //  Left side: 
    //    1.  Declare a double variable to hold the cost of the number of candles of that type being bought 
    //  Result of statement: Assign the cost of the number of candles being bought to a double variable for each type of candle 
    double costType1 = numType1 * type1.getCost(); 
    double costType2 = numType2 * type2.getCost(); 
    double costType3 = numType3 * type3.getCost();
    
    //Part B - Bulk Discounts!
    if(numType1 > DISCOUNT_THRESHOLD)
      costType1 = costType1 - (costType1*DISCOUNT);
    if(numType2 > DISCOUNT_THRESHOLD)
      costType2 = costType2 - (costType2*DISCOUNT);
    if(numType3 > DISCOUNT_THRESHOLD)
      costType3 = costType3 - (costType3*DISCOUNT);
    
    double totalCost = costType1 + costType2 + costType3;  // Compute total cost of all types of candles being bought
    return totalCost;
    
  }
  
  public double getTotalTax() {
    
    //  COMPUTE THE TAX FOR THAT MANY CANDLES OF EACH TYPE
    //  Same process as above but with tax instead of burn time
    double taxType1 =  this.numType1 * type1.getCost() * type1.getTax();
    double taxType2 =  this.numType2 * type2.getCost() * type2.getTax();
    double taxType3 =  this.numType3 * type3.getCost() * type3.getTax();
    double totalTax = taxType1 + taxType2 + taxType3;  // Total tax of all types of candles being bought
    return totalTax;
    
  }
  
  public int getTotalBurnTime() {
    
    //  COMPUTE THE BURN TIME FOR THAT MANY CANDLES OF EACH TYPE 
    //  Same process as above but with burn time instead of cost 
    int burnType1 = numType1 * type1.getTime(); 
    int burnType2 = numType2 * type2.getTime(); 
    int burnType3 = numType3 * type3.getTime(); 
    int totalBurn = burnType1 + burnType2 + burnType3;  // Total burn time of all types of candles being bought
    return totalBurn;
    
  }
  
  // method that calculates the grand total of a purchase
  // by combining the returns of getSubTotal and getTotalTax
  public double getTotal() {
    
    return getSubTotal() + getTotalTax();
    
  }
  
  public void getPurchaseBreakdown() {
    
    //Part C - Purchase Histograms
    System.out.println("Number of Type 1 candles purchased:");
    for(int i=0;i<numType1;i++)
      System.out.print("*");
    System.out.println();
    System.out.println("Number of Type 2 candles purchased:");
    for(int i=0;i<numType2;i++)
      System.out.print("*");
    System.out.println();
    System.out.println("Number of Type 3 candles purchased:");
    for(int i=0;i<numType3;i++)
      System.out.print("*");
    System.out.println();
    System.out.println("Total number of candles purchased:");
    for(int i=0;i<(numType1 + numType2 + numType3);i++)
      System.out.print("*");
    System.out.println();
    
    // I'm sure there's a better way to do this
    // but this is how I'm formatting how the discounts print
    String discount = "Since you bought more than 7 ";
    boolean type1 = false;
    boolean type2 = false;
    boolean type3 = false;
    if(numType1 > DISCOUNT_THRESHOLD)
      type1 = true;
    if(numType2 > DISCOUNT_THRESHOLD)
      type2 = true;
    if(numType3 > DISCOUNT_THRESHOLD)
      type3 = true;
    if(type1 && type2 && type3)
      discount += "Type 1, Type 2, and Type 3 candles, ";
    else if(type1 && type2)
      discount += "Type 1 and Type 2 candles, ";
    else if(type1 && type3)
      discount += "Type 1 and Type 3 candles, ";
    else if(type2 && type3)
      discount += "Type 2 and Type 3 candles, ";
    else if(type1)
      discount += "Type 1 candles, ";
    else if(type2)
      discount += "Type 2 candles, ";
    else if(type3)
      discount += "Type 3 candles, ";
    if(type1 || type2 || type3)
      System.out.println(discount + "you will recieve a 5% discount on them");
    
    //  DISPLAY THE RESULTS OF THIS SIMUATION 
    //  Print the results for the overall totals 
    System.out.println("The total cost of these " + totalNum + " candles is $" + this.getSubTotal() + ", plus $" + this.getTotalTax() + " in tax, equals $" + this.getTotal() + ", and the total burn time is " + this.getTotalBurnTime() + " minutes");
    
  }
  
  
}