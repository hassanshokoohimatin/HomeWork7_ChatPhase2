import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(88)){
            System.out.println("waiting...");
            Socket client1 = serverSocket.accept();
            System.out.println("connected to new client 1 ");
            Thread t1 = new Thread(new ClientManager(client1,"cilent 1"));
            t1.start();
            Socket client2 = serverSocket.accept();
            System.out.println("connected to new client 2 ");
            Thread t2 = new Thread(new ClientManager(client2,"client 2"));
            t2.start();
            Socket client3 = serverSocket.accept();
            System.out.println("connected to new client 3 ");
            Thread t3 = new Thread(new ClientManager(client3,"client 3"));
            t3.start();
        }catch (IOException e){}
    }
}