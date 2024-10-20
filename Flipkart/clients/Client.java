package clients;

import java.util.List;
import java.util.Map;

public interface Client {
    
    public List<Holding> getHoldings();
    public int getClientId() ;

    public int getCapital() ;

    public void setCapital(int capital) ;
    public void addHolding(Holding holding);
    public Map<Integer, Integer> getShares();
    public void setHoldings(List<Holding> holdings);
}
