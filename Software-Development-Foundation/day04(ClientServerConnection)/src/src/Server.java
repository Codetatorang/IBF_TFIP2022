package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args) throws IOException{
    System.out.println("Starting server on port 3000");
    //Create a server socket and listen to a specific port
    ServerSocket server = new ServerSocket(3000);
    
    while(true){
            //wait for a connection
            System.out.println("Waiting incoming connection");
        try (Socket conn = server.accept()) {
            System.out.println("Connection connected.");
            //Do something
            //Get the input stream, read the data from the client
            InputStream is = conn.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String input = ois.readUTF();
            System.out.printf(">> from client: %s\n", input);
            input = input.toUpperCase();
            System.out.printf(">> to client: %s\n", input);
            OutputStream os = conn.getOutputStream();
            Writer w = new OutputStreamWriter(os);
            w.write(input);
            w.flush();
            //Close the connection
        }
            server.close();
        }
    

    }

}