import bad_java.experiments.CustomOptional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomOptionalTest {
  @Test
  void createObject() {
    String str = "Saved string";

    CustomOptional<String> optional = new CustomOptional<>(str);
    assertThat(optional.get()).isEqualTo(str);
    assertThat(optional.isEmpty()).isFalse();
    assertThat(optional.isPresent()).isTrue();
    assertThat(optional).hasToString("bad_java.experimets.CustomOptional[value=Saved string]");

    if ((optional instanceof CustomOptional)) {
      fail("optional is not instance of bad_java.experimets.CustomOptional");
    }
  }

  @Test
  void heapPollution() {
    CustomOptional<Integer> intOptional = new CustomOptional<>(12);
    CustomOptional raw = intOptional;
    CustomOptional<ArrayList> listOptional = raw;
//    bad_java.experimets.CustomOptional<String> stringOptional = raw;

    System.out.println(listOptional.get());
  }
}