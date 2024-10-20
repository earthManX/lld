package tax;

public class TDSTaxStrategy implements TaxStrategy {

    double buyPercent;
    double intraDaySellPercent;
    double interDaySellpercent;

    public TDSTaxStrategy( double buyPercent, double intraDaySellPercent, double interDaySellpercent){
        this.buyPercent = buyPercent;
        this.interDaySellpercent = interDaySellpercent;
        this.intraDaySellPercent = intraDaySellPercent;
    }

    @Override
    public float calculateBuyAmount(int amount) {
        return (float) buyPercent * amount;
    }

    @Override
    public float calculateSellAmount(int amount, boolean sameDay) {
        if( sameDay){
            return (float) intraDaySellPercent * amount;
        }else{
            return (float) interDaySellpercent * amount;
        }
    }
    
}
