package Concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentUtils {
    
    public static void testES(){
        ExecutorService service = Executors.newFixedThreadPool(2);
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        Future<Integer> future=  service.submit(() -> {
            System.out.println("Testing service : 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception in sleeping thread");
            }
            System.out.println("Testing service : 1 after sleeping");
            return 1;
        });
        System.out.println(future.isDone());
        
        service.submit(() -> {
            System.out.println("Testing service : 2");
            try {
                System.out.println(future.get());
                Thread.sleep(5000);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Exception in sleeping thread");
            }
            System.out.println("Testing service : 2 after sleeping");
        });

        System.out.println(future.isDone());
        service2.submit(() -> {
            System.out.println("Testing service : 3");
        });
        System.out.println(future.isDone());
        service2.submit(() -> {
            System.out.println("Testing service : 4");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception in sleeping thread");
            }
            System.out.println("Testing service : 4 after sleeping");
        });
        System.out.println(future.isDone());
    }

    public static void main( String[] args){
        testES();
    }
}
