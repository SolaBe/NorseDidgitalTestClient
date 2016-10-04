import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Sola2Be on 03.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
            Socket cSocket = new Socket(ipAddress,3333);

            InputStream sin = cSocket.getInputStream();
            OutputStream sout = cSocket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            System.out.println("Insert data in format: id node"); // id's - 91,45,73
            Scanner scanner = new Scanner(System.in);             // nodes - [A-K]
            while(true) {
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
         System.out.println("Server offline");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
