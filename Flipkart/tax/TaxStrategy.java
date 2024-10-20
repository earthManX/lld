package tax;

public interface TaxStrategy {
    
    public float calculateBuyAmount(int amount);
    public float calculateSellAmount( int amount, boolean sameDay);
    
}
