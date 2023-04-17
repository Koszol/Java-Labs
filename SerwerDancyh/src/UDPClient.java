import types.TimeHistory;
import types.Tools;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient {
    public static void main(String[] args) {
        TimeHistory packet= new TimeHistory<>();
        byte[] data= Tools.byteSerialize(packet);
        int len=data.length;
        DatagramSocket aSocket = null;
        Scanner scanner = null;
        try {
            // args contain server hostname
            if (args.length < 1) {
                System.out.println("Usage: UDPClient <server host name>");
                System.exit(-1);
            }
            byte[] buffer = new byte[1024];
            InetAddress aHost = InetAddress.getByName(args[0]);
            int serverPort = 9876;
            aSocket = new DatagramSocket();
            scanner = new Scanner(System.in);
            String line = "";
            while (true) {
                System.out.println("Type a message to send a package: ");
                if (scanner.hasNextLine())
                    line = scanner.nextLine();
                DatagramPacket request = new DatagramPacket(data, len, aHost, serverPort);
                aSocket.send(request);
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(reply);
                System.out.println("Sent: " + new String(reply.getData(), 0, reply.getLength()));
            }
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            aSocket.close();
            scanner.close();
        }
    }
}