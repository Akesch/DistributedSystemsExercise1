import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HttpClient2 {
    public static void main(String[] args) throws Exception {
        String hostname = "stud.fh-wedel.de";
        InetAddress wedelAdresse = InetAddress.getByName(hostname);
        Socket socke = new Socket(wedelAdresse, 80);
        boolean autoflush = true;
        PrintWriter out = new PrintWriter(socke.getOutputStream(), autoflush);
        BufferedReader in = new BufferedReader( new InputStreamReader(socke.getInputStream()));

        //Send Request
        out.println("GET / HTTP/1.1");
        out.println("Connection: Close");
        out.println("Host: "+ hostname);
        out.println();

        //read Response
        boolean loop = true;
        StringBuilder homo = new StringBuilder(8096);
        while (loop){
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    homo.append((char) i);
                }
                loop = false;
            }
        }
        System.out.println(homo.toString());
        socke.close();
    }
}
