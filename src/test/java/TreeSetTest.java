import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeSetTest {
    @Test
    void name() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(-2);
        treeSet.add(3);
        treeSet.add(-8);
        treeSet.add(6);
        treeSet.add(72);

        System.out.println(treeSet);

        System.out.println(treeSet.headSet(6));
        System.out.println(treeSet.tailSet(6));
        System.out.println(treeSet.subSet(-2, 7));

        assertThat(treeSet.higher(6)).isEqualTo(72);
        assertThat(treeSet.ceiling(6)).isEqualTo(6);
        assertThat(treeSet.ceiling(78)).isNull();
        assertThat(treeSet.lower(72)).isEqualTo(6);
        assertThat(treeSet.floor(3)).isEqualTo(3);
    }
}
