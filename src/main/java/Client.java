import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Sola2Be on 05.10.2016.
 */
public class Client {

    private InetAddress ipAddress = null;
    private Socket clientSocket = null;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client () {

        try {
            ipAddress = InetAddress.getByName("127.0.0.1");
            clientSocket = new Socket(ipAddress,3333);

            InputStream sin = clientSocket.getInputStream();
            OutputStream sout = clientSocket.getOutputStream();

            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

            System.out.println("Insert data in format: id node"); // id's - 91,45,73
            scanner = new Scanner(System.in);             // nodes - [A-K]

            start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        while(true) {
            try {
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
