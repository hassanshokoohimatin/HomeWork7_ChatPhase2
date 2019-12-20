import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager implements Runnable {
    String clientName;
    Socket clientSocket;
    InputStream fromClient;
    OutputStream toClient;
    DataInputStream reader;
    PrintWriter writer;

    public ClientManager(Socket clientSocket , String clientName){
        this.clientSocket = clientSocket;
        this.clientName = clientName;
    }

    public void run(){
        try{
            fromClient = clientSocket.getInputStream();
            toClient = clientSocket.getOutputStream();
            reader = new DataInputStream(fromClient);
            writer = new PrintWriter(toClient,true);

            writer.println("What is your name?");
            String name = reader.readLine();
            System.out.println(clientName + "   " + name);

            writer.println("your family name ?");

            name = reader.readLine();
            System.out.println(clientName + "   " + name);
        }catch (Exception e){}
    }
}
