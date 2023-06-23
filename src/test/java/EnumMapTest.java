import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapTest {
    @Test
    void name() {
        assertThat(Season.UNKNOWN.ordinal()).isEqualTo(0);
        assertThat(Season.SUMMER.ordinal()).isEqualTo(3);

        EnumMap<Season, String> enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SUMMER, "Summer");
        assertThat(enumMap).hasSize(1);
        assertThat(enumMap.get(Season.SUMMER)).isEqualTo("Summer");
    }
}
