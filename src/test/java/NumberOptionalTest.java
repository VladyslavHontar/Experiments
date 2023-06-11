import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOptionalTest {

  @Test
  void name() {
    NumberOptional<Number> ref;
    ref = new NumberOptional<>(12);
  }
}