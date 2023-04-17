import types.Packet;
import types.Tools;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UdpServer {
    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        try {
            // args contain message content and server hostname
            aSocket = new DatagramSocket(9876);
            byte[] buffer = new byte[1024];
            while(true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                System.out.println("Waiting for request...");
                aSocket.receive(request);
                String t = new String(request.getData(), 0, request.getLength());
                System.out.println("Received data");
                Packet read= null;
                try {
                    read = (Packet) Tools.byteDeserialize(buffer);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(read.toString());
            }
        } catch (SocketException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            aSocket.close();
        }

    }
}

