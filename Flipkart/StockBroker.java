import java.util.*;
import java.util.Map;

import clients.Client;
import clients.ClientService;
import clients.Holding;
import exceptions.CommonException;
import shares.BrokerService;
import shares.SharesService;
import shares.TransactionType;
import tax.TDSTaxStrategy;
import tax.TaxStrategy;
import exceptions.*;

public class StockBroker {
    
    /*
     * Create client : C <ClientId> <Capital>
    Create/Update share with price : S <ShareId> <Price>
    Transaction : Buy/Sell <ClientId> <ShareId> <Quantity> <Day (integer)>
    Print a client’s holdings : P <ClientId>
    Print all clients’ holdings : P

     */

    private ClientService clientService;
    private SharesService sharesService;
    private TaxStrategy strategy;
    private BrokerService brokerService;

    StockBroker(){
        clientService = ClientService.getClientService();
        sharesService = SharesService.getSharesService();
        strategy = new TDSTaxStrategy( 1.05, 0.9, 0.95);
        brokerService = BrokerService.getBrokerService(strategy);
    }

    public void createClient( int clientId, int capital){
        try{
            clientService.createClient(clientId, capital);
            System.out.println("Successfully added client - " + clientId + " capital -" + capital);
        }catch(CommonException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateShare( int shareId, int price){
        sharesService.createShare(shareId, price);
        System.out.println("Share - " + shareId + " price - " + price + " created");
    }

    // /Transaction : Buy/Sell <ClientId> <ShareId> <Quantity> <Day (integer)>
    public void transact(TransactionType type, int clientId, int shareId, int quantity, int day){
        try{
            brokerService.transact( type, clientId, shareId, quantity, day);
            System.out.println("Transaction completed successfully");
        }catch(CommonException e){
            System.out.println(e.getMessage());
        }
    }

    public void getHoldings(){
       Map<Client, List<Holding>> map =  clientService.getHoldings();
       map.entrySet().forEach(e -> {
            System.out.println("Client - " + e.getKey().getClientId() + " Capital - " + e.getKey().getCapital());
            List<Holding> l = e.getValue();
            l.forEach( h -> {
                System.out.println("Holding Share " + h.getShare().getShareId() + " Quantity " + h.getQuantity() + " Day " + h.getDay());
            });
       });
    }

    public void getHoldings(int clientId){
        try{
            List<Holding> l = clientService.getHoldings(clientId);
            l.forEach( h -> {
                System.out.println("Holding Share " + h.getShare().getShareId() + " Quantity " + h.getQuantity() + " Day " + h.getDay());
            });
        }catch( CommonException e){
            System.out.println(e.getMessage());
        }
    }

}
