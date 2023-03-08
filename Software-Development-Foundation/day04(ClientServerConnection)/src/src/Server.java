package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            Socket conn = server.accept();
            
            System.out.println("Connection connected.");
            //Do something
            //Get the input stream, read the data from the client
            InputStream is = conn.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            // Reader r = new InputStreamReader(is);
            // BufferedReader br = new BufferedReader(r);

            // String input = br.readLine();
            String input = ois.readUTF();
            // System.out.printf(">> from client: %s\n", input);
            System.out.printf(">> from client: %s\n", input);
            input = input.toUpperCase();
            System.out.printf(">> to client: %s\n", input);

            OutputStream os = conn.getOutputStream();
            // ObjectOutputStream oos = new ObjectOutputStream(os);
            
            // input = input.toUpperCase();
            // os = conn.getOutputStream();
            Writer w = new OutputStreamWriter(os);
            w.write(input);
            w.flush();

            // oos.writeUTF(input);
            // oos.flush();

            //Close the connection
            conn.close();
            server.close();
            // oos.close();

        }
    

    }

}