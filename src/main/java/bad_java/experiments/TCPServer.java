package bad_java.experiments;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
  public static void main(String[] args) {
    ServerSocket server;
    InputStream in;
    Socket client;

    try {
      server = new ServerSocket(9999);    // create server socket

      for (int i = 5; --i >= 0;) {    // process only 5 client requests
        client = server.accept();   // wait for client connection
        System.out.println("Client connected" + client.getRemoteSocketAddress());

        in = client.getInputStream();  // get stream to read from
        System.out.println(in.read());

        client.close();
      }
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
