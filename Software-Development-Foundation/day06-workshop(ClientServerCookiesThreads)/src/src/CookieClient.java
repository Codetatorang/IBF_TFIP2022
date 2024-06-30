package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CookieClient {

    public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {

        String host = "localhost";
        int port = 3000;
        Boolean exit = false;

        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }

        Socket socket = new Socket(host, port);

        try (OutputStream os = socket.getOutputStream()) {
            System.out.println("Connected to server.");

            BufferedInputStream bis;
            DataInputStream dis;
            try (InputStream is = socket.getInputStream()) {
                bis = new BufferedInputStream(is);
                dis = new DataInputStream(bis);
                DataOutputStream dos;
                try (BufferedOutputStream bos = new BufferedOutputStream(os)) {
                    dos = new DataOutputStream(bos);
                    Console cons = System.console();
                    String readInput;
                    String response;
                    while (!exit) {
                        readInput = cons.readLine("Enter a command (try 'cookie'): ");
                        
                        //exit if input is 'exit'
                        if(readInput.equalsIgnoreCase("exit")){
                            exit = true;
                            continue;
                        }
                        
                        //send response to server
                        dos.writeUTF(readInput);
                        dos.flush();
                        
                        //receive response from server
                        response = dis.readUTF();
                        System.out
                                .println(response.substring(0, 1).toUpperCase()
                                        + response.substring(1, response.length()) + " cookie received.");
                        
                        
                    }   os.close();
                }
                dos.close();
            }
            bis.close();
            dis.close();

        } catch (EOFException ex) {
            System.out.println("error! closing connectiont to socket.");
            socket.close();
        }
    }
}