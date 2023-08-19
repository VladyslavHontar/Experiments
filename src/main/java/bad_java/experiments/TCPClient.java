package bad_java.experiments;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
  public static void main(String[] args) {
    Socket client;
    OutputStream out;
    InetAddress ia;

    try {
      ia = InetAddress.getByName("localhost");    //get localhost address

      client = new Socket(ia, 9999);    // create socket connection

      out = client.getOutputStream();   // get stream to write to

      out.write("Hello from client".getBytes());  // write message to stream

      out.flush();

      out.close();
      client.close();
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
