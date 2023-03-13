package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String dirPath = "..\\CookieFolder";
        File newDirectory = new File(dirPath);
        // if directory exist, print directory exists.
        // else create the directory
        if (newDirectory.exists()) {
            System.out.println("directory already exists.");
        } else {
            newDirectory.mkdir();
            System.out.println("directory has been created.");
        }

        Cookies cookie = new Cookies();
        cookie.readCookieFile();
        cookie.showCookies();

        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

        try (InputStream is = s.getInputStream()) {
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String messageReceived = "";

            while (!messageReceived.equals("close")) {
                messageReceived = dis.readUTF();

                if (messageReceived.equalsIgnoreCase("get-cookie")) {
                    String cookieValue = cookie.returnCookie();
                    System.out.println(cookieValue);

                    try (OutputStream os = s.getOutputStream()) {
                        BufferedOutputStream bos = new BufferedOutputStream(os);
                        DataOutputStream dos = new DataOutputStream(bos);
                        dos.writeUTF(cookieValue);
                        dos.flush();
                    }

                }
                
            }
        } catch (EOFException EX) {
            s.close();
            ss.close();
            
        }
    }
}