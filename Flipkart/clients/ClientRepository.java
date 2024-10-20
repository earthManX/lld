package clients;

import java.util.*;

import exceptions.CommonException;

public class ClientRepository {
    private static ClientRepository repository;

    private static Map<Integer, Client> clients;

    private ClientRepository(){}

    public static ClientRepository getClientRepository(){
        if( repository == null){
            repository = new ClientRepository();
            clients = new HashMap<>();
        }
        return repository;
    }

    public void addClient( int clientId, int capital){
        if( !clients.containsKey(clientId)){
            clients.put(clientId, new SilverClient(clientId, capital));
        }else{
            // throw exception
        }
    }

    public Client getClient(int clientId) throws CommonException{
        if( clients.containsKey(clientId)){
            return clients.get(clientId);
        }else{
            throw new CommonException("Client does not exist");
        }
    }

    public Map<Integer, Client> getClients(){
        return clients;
    }

}
