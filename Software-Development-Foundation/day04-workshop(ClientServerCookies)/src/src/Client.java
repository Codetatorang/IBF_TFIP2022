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

public class Client {

    public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
        Socket socket = new Socket("localhost", Integer.parseInt(args[0]));
        try (OutputStream os = socket.getOutputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            InputStream is;
            BufferedInputStream bis;
            DataInputStream dis;
            try (DataOutputStream dos = new DataOutputStream(bos)) {
                Console cons = System.console();
                String readInput = "";
                String response;
                is = socket.getInputStream();
                bis = new BufferedInputStream(is);
                dis = new DataInputStream(bis);
                while (!readInput.equalsIgnoreCase("exit")) {
                    readInput = cons.readLine("Enter a command (try 'get-cookie'): ");
                    dos.writeUTF(readInput);
                    dos.flush();
                    response = dis.readUTF();
                    System.out
                            .println(response.substring(0, 1).toUpperCase()
                                    + response.substring(1, response.length()) + " cookie received.");
                }
            }
            dis.close();
            bis.close();
            is.close();

        } catch(EOFException ex){
            socket.close();
        }
    }
}