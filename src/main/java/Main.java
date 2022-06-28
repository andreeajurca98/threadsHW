import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10); //maximum threads in the thread pool
        Integer result = 0;
        for (int i = 1; i <= 10; i++) {
            try {
                Divisor divisor = new Divisor(i);
                Future<Integer> futureResult =  es.submit(divisor);
                result = futureResult.get();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        try {
            es.shutdown(); //doesn't accept new tasks, shutdowns after all running threads finish their current work
            es.awaitTermination(60, TimeUnit.SECONDS); //awaits 60 seconds before termination

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}