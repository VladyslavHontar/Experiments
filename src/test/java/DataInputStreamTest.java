import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DataInputStreamTest {
  @Test
  void name() {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
      DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));

      dos.writeLong(42);    // 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00101010
      dos.writeByte(42);    // 00101010
      dos.flush();

      byte[] arr = baos.toByteArray();
      assertThat(arr).hasSize(9); // 8bytes for long and 1byte for byte

      // 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00101010 00101010

      try (DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(arr))) {
        assertThat(inputStream.readByte()).isEqualTo((byte)0);
        assertThat(inputStream.readLong()).isEqualTo(10794L);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
