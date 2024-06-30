package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CookieClientHandler implements Runnable {

    private Socket s = new Socket();

    public CookieClientHandler(Socket s) {
        this.s = s;
    }

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
    }

    @Override
    public void run() {
        Cookies cookie = new Cookies();

        Boolean exit = false;
        // returns a random cookie
        try (InputStream is = s.getInputStream(); BufferedInputStream bis = new BufferedInputStream(is); DataInputStream dis = new DataInputStream(bis); OutputStream os = s.getOutputStream(); BufferedOutputStream bos = new BufferedOutputStream(os); DataOutputStream dos = new DataOutputStream(bos);) {

            String messageReceived;

            while (!exit) {
                messageReceived = dis.readUTF();
                cookie.readCookieFile();

                if (messageReceived.equalsIgnoreCase("cookie")) {
                    String cookieValue = cookie.returnCookie();
                    System.out.printf("sending %s back", cookieValue);
                    dos.writeUTF(cookieValue);
                    dos.flush();
                }

            }
            is.close();
            bis.close();
            dis.close();
            os.close();
            bos.close();
            dos.close();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
