import java.util.concurrent.Callable;

//we use this class to implement
public class Divisor implements Callable<Integer> {
    final static int LIMIT = 100000;
    int threadNumber;
    public Divisor(int threadNumber){
        this.threadNumber = threadNumber;
    }
    public synchronized int findIntegerWithMaxDiv() {
        int maxDivisors = 0;
        int maxNumber = 0;
        for (int i = 1; i <= LIMIT; i++) {
            int divisors = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisors++;
                }
            }
            if (divisors > maxDivisors) {
                maxDivisors = divisors;
                maxNumber = i;
            }
        }
        return maxNumber;
    }
    @Override
    public Integer call() {
        return findIntegerWithMaxDiv();
    }
}
