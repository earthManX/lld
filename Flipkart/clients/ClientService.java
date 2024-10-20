package clients;

import java.util.*;

import exceptions.CommonException;

public class ClientService {
    
    private static ClientService service;
    private static ClientRepository repository;

    private ClientService(){}

    public static ClientService getClientService(){
        if( service == null){
            service = new ClientService();
            repository = ClientRepository.getClientRepository();
        }
        return service;
    }

    public void createClient(int clientId, int capital) throws CommonException{
        if( capital < 0 ){
            throw new CommonException("Client cannot have initial negative capital");
        }
        repository.addClient(clientId, capital);
    }

    public Map<Client, List<Holding>> getHoldings(){
        Map<Integer, Client> clients = repository.getClients();
        Map<Client, List<Holding>> holdings = new HashMap<>();
        clients.values().forEach( c -> {
            holdings.put( c, c.getHoldings());
        });
        return holdings;
    }

    public List<Holding> getHoldings( int clientId) throws CommonException{
        return repository.getClient(clientId).getHoldings();
    }

    public Client getClient( int clientId) throws CommonException{
        return repository.getClient(clientId);
    }
}
