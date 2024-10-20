package shares;

import java.util.*;

import exceptions.CommonException;

public class SharesService {
    
    private static SharesService service;
    private static ShareRepository repository;

    private SharesService(){}

    public static SharesService getSharesService(){
        if( service == null){
            service = new SharesService();
            repository = ShareRepository.getShareRepository();
        }
        return service;
    }

    public int getSharePrice( int shareId){
        try{
            Share share = repository.getShare(shareId);
            return share.getPrice();
        }catch( CommonException e){
            //Handle exception
            return -1;
        }
    }

    public void createShare( int shareId, int price){
        if(repository.shareExists(shareId) ){
            repository.updateShare(shareId, price);
        }else{
            repository.addShare(shareId, price);
        }
    }

}
