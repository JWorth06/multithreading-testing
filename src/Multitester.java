import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multitester {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);//creating a pool of 5 threads

        for (int i = 0; i < 20; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            System.out.println("Terminating Executor");
            try {
                Thread.sleep(1000);
                String a = Thread.currentThread().getName();
                System.out.println(a + "is sleeping for 1 second");
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }

        System.out.println("Finished all threads");
    }
}
