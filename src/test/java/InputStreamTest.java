import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputStreamTest {
    @Test
    void readTest() throws IOException {
        byte[] bytes = {1,2,127,-128};
        InputStream in = new ByteArrayInputStream(bytes);

        assertThat(in.read()).isEqualTo(1);
        assertThat(in.read()).isEqualTo(2);
        assertThat(in.read()).isEqualTo(127);

        int intVal = in.read();
        assertThat(intVal).isEqualTo(128);
        int byteVal = (byte) intVal;
        assertThat(byteVal).isEqualTo(-128);

        assertThat(in.read()).isEqualTo(-1);
    }
    @Test
    void readArrayTest() throws IOException {
        byte[] bytes = {1,2,127,-128};
        InputStream in = new ByteArrayInputStream(bytes);

        byte[] buff = new byte[3];
        int readBytes = in.read(buff);

        assertThat(readBytes).isEqualTo(3);
        assertThat(buff).containsExactly(1,2,127);

        readBytes = in.read(buff);
        assertThat(readBytes).isEqualTo(1);
        assertThat(buff).containsExactly(128,2,127);

    }
    @Test
    void availableTest() throws IOException {
        byte[] bytes = {1,2,127,-128,2,3,4};
        InputStream in = new ByteArrayInputStream(bytes);

        assertThat(in.available()).isEqualTo(7);
        in.read();
        assertThat(in.available()).isEqualTo(6);

        in.skip(3);
        assertThat(in.available()).isEqualTo(3);
        assertThat(in.read()).isEqualTo(2);
    }
    @Test
    void markSupportedTest() throws IOException {
        byte[] bytes = {1,2,127,-128,2,3,4};
        InputStream in = new ByteArrayInputStream(bytes);

        assertThat(in.markSupported()).isTrue();
        in.read();
        in.read();
        in.mark(1);
        assertThat(in.read()).isEqualTo(127);
        assertThat(in.read()).isEqualTo(128);
        assertThat(in.read()).isEqualTo(2);
        assertThat(in.read()).isEqualTo(3);
        assertThat(in.read()).isEqualTo(4);
        in.reset();
        assertThat(in.read()).isEqualTo(127);
    }
}
