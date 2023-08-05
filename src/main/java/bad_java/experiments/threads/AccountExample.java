package bad_java.experiments.threads;

import lombok.Getter;

public class AccountExample {
  public static void main(String[] args) throws InterruptedException {
    Account acc = new Account();

    Thread inc = new Thread(() -> {
      for (int i = 0; i < 10_000_000; i++) {
        acc.inc();
      }
    });
    inc.start();

    Thread dec = new Thread(() -> {
      for (int i = 0; i < 10_000_000; i++) {
        acc.dec();
      }
    });
    dec.start();

    // blocking set
//    synchronized (acc) {
      // deadlock
      inc.join();
      dec.join();
//    }

    System.out.println(acc.getValue());
  }
}
class Account {
  @Getter
  private volatile long value;
  public synchronized void inc() {
      value++;
  }
  public synchronized void dec() {
      value--;
  }
}
