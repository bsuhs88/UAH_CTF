package Modules.Event;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FindIP extends Event{



    public boolean checkIP (String ip) throws IOException {
        String correctIP = getIP();
        correctIP = correctIP.replaceAll("/","");

        if (ip.equals(correctIP)) {
            return true;
        } else {
            return false;
        }
    }

    private String getIP() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        System.out.println(socket.getLocalAddress());
        return socket.getLocalAddress().toString();
    }


}
