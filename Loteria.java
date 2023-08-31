
package loteria;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Loteria {

    private static final ExecutorService pool = Executors.newFixedThreadPool(2);
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
          
        LeiaCVS obj1 = new LeiaCVS(2,1400);
        LeiaCVS obj2 = new LeiaCVS(1401,2892);
        
        Future<int[]> futuro1 = pool.submit(obj1);
        Future<int[]> futuro2 = pool.submit(obj2);


        
        pool.shutdown();
    }
    
}
