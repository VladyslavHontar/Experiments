import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputStreamTest {
    @Test
    void name() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(2626);    //Wrong assumption that only the last byte will be written
        out.write(4);
        out.write(127);
        out.write(-128);
        byte[] byteArray = out.toByteArray();

        assertThat(byteArray).hasSize(4).containsExactly(66,4,127,-128);
    }
}
