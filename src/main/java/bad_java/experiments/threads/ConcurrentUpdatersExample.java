package bad_java.experiments.threads;

public class ConcurrentUpdatersExample {
  // Atomicity
  public volatile static int counter;
  public static void main(String[] args) throws InterruptedException {
    Object o = new Object();
    // Race condition
    Thread inc = new Thread(() -> {
      for (int i = 0; i < 10_000_000; i++) {
        synchronized (o) {   // start of critical section
          // read
          // increment
          // write
          counter++;
        }                   // end of critical section
      }});
    inc.start();

    Thread dec = new Thread(() -> {
      for (int i = 0; i < 10_000_000; i++) {
        synchronized (o) {   // start of critical section
          // read
          // increment
          // write
          counter--;
        }                   // end of critical section
      }});
    dec.start();

    dec.join();
    inc.join();

    System.out.println(counter);
  }
}
