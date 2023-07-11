import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesAndPathsTest {
  @Test
  @DisabledOnOs(OS.WINDOWS)
  void getPermissions() throws IOException {
    Path path = Paths.get("data");

    // owner|group|others
    // rwx|rwx|rwx
    // 111|101|100 = 754
    // chmod 754 file.txt

    // chmod g+w file.txt
    // 111|111|100 = 774

    Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path);
  }

  @Test
  void commonOperations() throws IOException {
    File file = new File(".");
    file.toPath();
    Path path = Paths.get("data");
    path.toFile();

    Path white = path.resolve("white.txt");
    assertThat(Files.exists(white)).isFalse();

    Files.createFile(white);
    assertThat(Files.exists(white)).isTrue();

    Files.delete(white);
    assertThat(Files.exists(white)).isFalse();
  }
}
