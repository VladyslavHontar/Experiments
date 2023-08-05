package bad_java.experiments.threads;

import java.util.concurrent.TimeUnit;

public class CounterExample {
  public static void main(String[] args) throws InterruptedException {
    Runnable task = () -> {
      System.out.println("Counter started");
      long i = 0;
      Thread currentThread = Thread.currentThread();
      for (int c = 0; i < 10_000_000_000L; i++, c++) {
        if (c == 1_000_000) {
          if (currentThread.isInterrupted()) {
            break;
          }
          c = 0;
        }
      }
      System.out.println("Counter finished " + i);
    };
    Thread thread = new Thread(task);
//    thread.setDaemon(true);
    System.out.println("main before start");
    thread.start();

//    while (thread.isAlive()) {
//      Thread.yield();
//      TimeUnit.SECONDS.sleep(1);
//    }                                   // spin-lock/spin-loop/busy-wait

    TimeUnit.SECONDS.sleep(3);

    thread.interrupt();
    thread.join();

//    System.out.println("before join");
//    thread.join();                      // wait-notify
//    System.out.println("after join");

    System.out.println("main finished");
  }
}
