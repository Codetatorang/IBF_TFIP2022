package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        int port = 3000;
        Boolean exit = false;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);

        try ( // enabling of threads
                ServerSocket ss = new ServerSocket(port)) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            
            while (!exit) {
                System.out.println("Waiting for Connection...");
                Socket s = ss.accept();
                System.out.println("Connection Received...");
                CookieClientHandler cch = new CookieClientHandler(s);
                executorService.execute(cch);
                
                if(exit)
                    s.close();
            }
        }
    }
}