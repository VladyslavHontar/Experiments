import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {
    @Test
    void name() {
        try (FileInputStream in = new FileInputStream("/Users/vlad/testFiles/Txt.txt")) {
            assertThat(in.available()).isEqualTo(5);
            assertThat(in.read()).isEqualTo(49);
            assertThat(in.read()).isEqualTo(50);
            assertThat(in.read()).isEqualTo(51);
            assertThat(in.read()).isEqualTo(52);
            assertThat(in.read()).isEqualTo(53);
            assertThat(in.read()).isEqualTo(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void buffered() {
        String path = "/Users/vlad/testFiles/Txt.txt";
        try (InputStream in = new BufferedInputStream(new FileInputStream(path), 4)) {
            assertThat(in.available()).isEqualTo(5);
            assertThat(in.read()).isEqualTo(49);
            assertThat(in.read()).isEqualTo(50);
            assertThat(in.read()).isEqualTo(51);
            assertThat(in.read()).isEqualTo(52);
            assertThat(in.read()).isEqualTo(53);
            assertThat(in.read()).isEqualTo(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
