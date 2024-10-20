package clients;

import java.util.*;

public class SilverClient implements Client{

    private int clientId;
    private int capital;
    private List<Holding> holdings;

    private Map<Integer, Integer> shares;

    public SilverClient(int clientId, int capital){
        this.capital = capital;
        this.clientId = clientId;
        holdings = new ArrayList<>();
        shares = new HashMap<>();
    }

    @Override
    public List<Holding> getHoldings() {
        return holdings;
    }

    public int getClientId() {
        return clientId;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void addHolding( Holding holding){
        holdings.add(holding);
        shares.put( holding.getShare().getShareId(), shares.getOrDefault(holding.getShare().getShareId(), 0) + 1 );
    }

    public Map<Integer, Integer> getShares() {
        return shares;
    }

    public void setHoldings(List<Holding> holdings) {
        this.holdings = holdings;
    }

}
