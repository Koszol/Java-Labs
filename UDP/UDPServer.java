import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPServer {
    public static void  main(String [] args){
        System.out.println("UDP Server ready...");
        try{
            DatagramSocket aSocket = new DatagramSocket(9876);
            byte[] buffer = new byte[1024];
            while(true){
                DatagramPacket request=new DatagramPacket(buffer,buffer.length);
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData (), request.getLength () , request.getAddress () , request.getPort ());
                aSocket.send(reply);
            }
        }  catch (SocketException ex){
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex){
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ds.close(); localhost, albo 127.0.0.1
    }
}
// IwM_BKoszolko na gitlabie