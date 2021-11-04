import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 * Socket Connection as Client
 * HTTP Client for stud.fh-wedel.de
 */

public class httpclient {

    public static void main(String[] args) {
        if (args.length < 1) return;

        URL url;

        try{
            url = new URL(args[0]);
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
            return;
        }

        String hostname = url.getHost();
        int port = 80;

        try (Socket socket = new socket(hostname, port)) {

        }

    }
}
public class Main {

}