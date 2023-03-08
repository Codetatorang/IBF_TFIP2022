package src;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {
    public static void main(String[]args) throws IOException{
        //Connect ot he server listening on port 3000
        //127.0.01 or localhost means my local computer
        Integer port = 0; 
        if (0 == port){
            port = 3000;
        }else{
           port = Integer.parseInt(args[0]);
        }

        Socket clientConn = new Socket("127.0.0.1", port);

        System.out.printf("Connected to server on localhost:%d\n", port);

        //Console
        Console cons = System.console();
        String line = cons.readLine("What would like to uppercase? ");

        //Do something
        //Get the output stream to write to the server.
        OutputStream os = clientConn.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        
        Writer wr = new OutputStreamWriter(os);
        // wr.write(line);
        // wr.flush();
        oos.writeUTF(line);
        oos.flush();

        // get the input stream from the server
        InputStream is = clientConn.getInputStream();
        Reader r = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(r);
        String returnedString = br.readLine();
        System.out.printf("your message %s is converted into %s \n: ", line, returnedString);

        //Close connection
        clientConn.close();
        wr.close();
        oos.close();
    }
}