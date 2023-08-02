package bad_java.experiments;

import java.util.concurrent.TimeUnit;

public class InterruptedExceptionExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      System.out.println("Child thread started");
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Child thread finished");
    });
    thread.start();

    TimeUnit.SECONDS.sleep(5);
    thread.interrupt();
    System.out.println("Main thread finished");
  }
}
