package shares;

import clients.ClientRepository;
import clients.*;
import exceptions.CommonException;
import tax.TaxStrategy;
import java.util.*;

public class BrokerService {
    
    private static BrokerService service;
    private static ShareRepository shareRepository;
    private static ClientRepository clientRepository;
    private static TaxStrategy taxStrategy;
    private static Exchange exchange;

    private BrokerService(){}

    public static BrokerService getBrokerService( TaxStrategy strategy){
        if( service == null){
            service = new BrokerService();
            shareRepository = ShareRepository.getShareRepository();
            clientRepository = ClientRepository.getClientRepository();
            taxStrategy = strategy;
            exchange = new Exchange();
        }
        return service;
    }

    public void transact(TransactionType type, int clientId, int shareId, int quantity, int day) throws CommonException{
        if( !shareRepository.shareExists(shareId)){
            throw new CommonException("Share does not exist");
        }
        if( quantity < 0 ){
            throw new CommonException("Quantity cannot be less than 0");
        }
        if( day < 0 ){
            throw new CommonException("Day cannot be less than 0");
        }
        Share s = shareRepository.getShare(shareId);
        Client c = clientRepository.getClient(clientId);
        int price = s.getPrice();
        if( type.equals(TransactionType.BUY)){
            int amountRequired = (int) taxStrategy.calculateBuyAmount( quantity * price);
            int capital = clientRepository.getClient(clientId).getCapital();

            if( amountRequired <= capital){
                //Client executes the transaction successfully
                c.addHolding(new Holding(s, quantity, day));
                c.setCapital(capital- amountRequired);
                exchange.execute();
            }else{
                throw new CommonException("Client does not have enough money");
            }
        }else{
            int amount = 0;
            if( c.getShares().get(shareId) != null && c.getShares().get(shareId) <= quantity){
                List<Holding> holdings = c.getHoldings();
                Iterator<Holding> itr = holdings.iterator();
                while( quantity != 0 ){
                    Holding holding = itr.next();
                    if( holding.getShare().getShareId() == shareId){
                        if( quantity >= holding.getQuantity()){
                            amount += (day == holding.getDay()) ? 
                                taxStrategy.calculateSellAmount(holding.getQuantity() * price, true ) :
                                taxStrategy.calculateSellAmount(holding.getQuantity() * price, false ) ;
                            quantity -= holding.getQuantity();
                            itr.remove();
                        }else{
                            amount += (day == holding.getDay()) ? 
                                taxStrategy.calculateSellAmount( quantity * price, true ) :
                                taxStrategy.calculateSellAmount( quantity * price, false ) ;
                            quantity = 0;
                            holding.setQuantity(holding.getQuantity()-quantity);    
                        }
                    }
                }
                c.setCapital(c.getCapital() + (int) amount);
                c.setHoldings(holdings);
            }else{
                throw new CommonException("Client does not have enough shares to sell");
            }

        }
    }
}
