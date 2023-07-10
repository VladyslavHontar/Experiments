import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

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

    @Test
    void relativePath() {
        try (InputStream in = new FileInputStream("data/Txt.txt")) {
            assertThat(in.available()).isEqualTo(5);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    void randomAccessFile() throws FileNotFoundException {
        try (RandomAccessFile rw = new RandomAccessFile("data/Txt.txt", "rw")) {
            rw.seek(3);
            assertThat(rw.read()).isEqualTo(52);
            rw.seek(0);
            assertThat(rw.read()).isEqualTo(49);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    void inputStreamReader() {
        try (FileReader reader = new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16BE)) {
            assertThat(reader.read()).isEqualTo(0xFEFF);
            assertThat((char)reader.read()).isEqualTo('t');
            assertThat((char)reader.read()).isEqualTo('e');
            assertThat((char)reader.read()).isEqualTo('x');
            assertThat((char)reader.read()).isEqualTo('t');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader reader = new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16)) {
            assertThat((char)reader.read()).isEqualTo('t');
            assertThat((char)reader.read()).isEqualTo('e');
            assertThat((char)reader.read()).isEqualTo('x');
            assertThat((char)reader.read()).isEqualTo('t');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream stream = FileTest.class.getResourceAsStream("/top_level_resource.txt");
             Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_16);
             BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            assertThat((char)reader.read()).isEqualTo('t');
            assertThat((char)reader.read()).isEqualTo('e');
            assertThat((char)reader.read()).isEqualTo('x');
            assertThat((char)reader.read()).isEqualTo('t');

            assertThat(bufferedReader.readLine()).isEqualTo(" from top level resource");
            assertThat(bufferedReader.readLine()).isEqualTo("next line");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void readAllLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/utf16_file.txt", StandardCharsets.UTF_16))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
