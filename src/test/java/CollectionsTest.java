import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CollectionsTest {
  @Test
  void name() {
    List<Integer> source = Arrays.asList(1, 2, 3);
    source.set(0, 10);

    source = List.of(1,2,5,3,7,8,1,2,5,3);

    List<Integer> target = List.of(1,2,5);
    int firstOccurrence = Collections.indexOfSubList(source, target);
    assertThat(firstOccurrence).isEqualTo(0);

    int secondStartingPoint = Collections.indexOfSubList(source, target) + target.size();

    List<Integer> subList = source.subList(secondStartingPoint, source.size());
    int secondOccurrence = Collections.indexOfSubList(subList, target) + secondStartingPoint;
    assertThat(secondOccurrence).isEqualTo(6);
  }
}
