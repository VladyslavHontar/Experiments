package bad_java.experiments;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class ManagedCounterExample {
  public static void main(String[] args) throws InterruptedException {
    ManagedCounter counter = new ManagedCounter(10_000_000_000L);
    Thread thread = new Thread(counter, "Counter");
    thread.start();

    counter.suspend();
    TimeUnit.SECONDS.sleep(2);
    counter.stop();
    System.out.println("Main thread finished");
  }
}
@Getter
class ManagedCounter implements Runnable {
  private volatile State state = State.NEW;
  private final long limit;
  private long current;

  ManagedCounter(long limit) {
    this.limit = limit;
  }
  @Override
  public void run() {
    state = State.RUNNING;
    loop: while (current<limit) {
      switch (state) {
        case RUNNING:
          doWork();
          break;
        case PAUSED:
          try {
            TimeUnit.MILLISECONDS.sleep(20);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          break;
        case STOPPED:
          break loop;

        default:
          System.out.println(state);
          break;
      }
    }
    System.out.println("Counter finished " + current);
  }

  private void doWork() {
    current++;
  }

  public void suspend() {
    state = State.PAUSED;
  }
  public void resume() {
    state = State.RUNNING;
  }
  public void stop() {
    state = State.STOPPED;
  }
  enum State {
    NEW,
    RUNNING,
    PAUSED,
    STOPPED
  }
}
