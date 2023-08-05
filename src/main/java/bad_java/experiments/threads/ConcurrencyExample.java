package bad_java.experiments.threads;

import java.util.concurrent.TimeUnit;

public class ConcurrencyExample {
  public static void main(String[] args) throws InterruptedException {
    // Shared state
    // int a = 0;

    // Race condition
    // #1 READ[0] INC[1] WRITE[1]
    // #2 READ[0] INC[1] WRITE[1]

    System.out.println("Hello world!");

    Thread main = Thread.currentThread();

    // new Thread().start();
    // Executors
    // ForkJoinPool
    // Stream.parallel()
    // CompletableFuture


//    Thread childThread = new CustomThread("Custom name");
//    child.setName("Second custom name");

//    Thread childThread = new Thread(() -> {
//      System.out.println("Hello from child thread: " + Thread.currentThread());
//      try {
//        TimeUnit.SECONDS.sleep(10);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });

    Runnable task = () -> {
      System.out.println("Hello from child thread: " + Thread.currentThread());
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Thread childThread = new Thread(task);
    childThread.setName("Child-thread");
    // childThread.setPriority(Thread.MAX_PRIORITY);
    // Thread affinity

    Thread.yield();
    childThread.start();

    System.out.println(main.getState());
    System.out.println(childThread.getState());

    TimeUnit.SECONDS.sleep(10);

    System.out.println(main);
    System.out.println(childThread);
  }
}

class CustomThread extends Thread {

  public CustomThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println("Hello from child thread: " + Thread.currentThread());
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
