package shares;

import java.util.HashMap;
import java.util.Map;

import exceptions.CommonException;

public class ShareRepository {
    
    private static Map<Integer, Share> shares;
    private static ShareRepository repository;

    private ShareRepository(){}

    public static ShareRepository getShareRepository(){
        if( repository == null){
            repository = new ShareRepository();
            shares = new HashMap<>();
        }
        return repository;
    }

    public Share getShare( int shareId) throws CommonException{
        if( shares.containsKey(shareId)){
            return shares.get(shareId);
        }else{
            throw new CommonException("Share does not exist");
        }
    }

    public boolean shareExists(int shareId){
        if( shares.containsKey(shareId)){
            return true;
        }
        return false;
    }

    public void addShare(int shareId, int price){
        shares.put(shareId, new Share(shareId, price));
    }

    public void updateShare(int shareId, int price){
        shares.put(shareId, new Share(shareId, price));
    }

}
