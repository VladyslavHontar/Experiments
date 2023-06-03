import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

public class Main {
  public static void main(String[] args) {
    copyFile("C:\\tmp\\in.txt", "C:\\tmp\\out.txt");
  }

  private static void copyFile(String inputFileName, String outputFileName) {
    try (FileInputStream in = new FileInputStream(inputFileName);
         FileInputStream out = new FileInputStream(outputFileName)) {
      copyFile(in, out);
    } catch (IOException ex) {
      System.out.println("Caught IOException and rethrowing as UncheckedIOException");
      throw new UncheckedIOException(ex);
    }
  }
  private static void copyFileOldStyle(String inputFileName, String outputFileName) throws UncheckedIOException {
    FileInputStream in = null;
    FileInputStream out = null;
    try {
      in = new FileInputStream(inputFileName);
      out = new FileInputStream(outputFileName);
      copyFile(in, out);
    } catch (IOException ex) {
      System.out.println("Caught IOException and rethrowing as UncheckedIOException");
      throw new UncheckedIOException(ex);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static void copyFile(FileInputStream in, FileInputStream out) throws IOException {
    throw new IOException("Exception in copyFile method");
  }
}