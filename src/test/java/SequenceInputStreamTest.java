import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceInputStreamTest {
    @Test
    void name() throws IOException {
        ByteArrayInputStream in1 = new ByteArrayInputStream(new byte[]{1});
        ByteArrayInputStream in2 = new ByteArrayInputStream(new byte[]{2});
        ByteArrayInputStream in3 = new ByteArrayInputStream(new byte[]{3});

        Enumeration<ByteArrayInputStream> enumeration = Collections.enumeration(List.of(in1, in2, in3));

        SequenceInputStream in = new SequenceInputStream(enumeration);

        assertThat(in.read()).isEqualTo(1);
        assertThat(in.read()).isEqualTo(2);
        assertThat(in.read()).isEqualTo(3);
        assertThat(in.read()).isEqualTo(-1);
    }
}