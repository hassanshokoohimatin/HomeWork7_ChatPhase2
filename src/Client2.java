import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1",88)){
            System.out.println("connected to the server");
            InputStream fromServer;
            OutputStream toServer;
            DataInputStream reader;
            PrintWriter writer;
            fromServer = socket.getInputStream();
            toServer = socket.getOutputStream();
            reader = new DataInputStream(fromServer);
            writer = new PrintWriter(toServer,true);

            String response = reader.readLine();
            System.out.println("Server : " + response);

            System.out.println("Your message : ");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            writer.println(message);

            response = reader.readLine();
            System.out.println("Server : " + response);

            System.out.println("Your message : ");
            message = scanner.nextLine();
            writer.println(message);

        }
    }
}
