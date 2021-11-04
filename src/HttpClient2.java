import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HttpClient2 {
    public static void main(String[] args) throws Exception {
        String hostname = "stud.fh-wedel.de";
        InetAddress InternetAdresse = InetAddress.getByName(hostname);
        Socket verbindung = new Socket(InternetAdresse, 80);
        boolean autoflush = true;
        //Output definieren
        PrintWriter sender = new PrintWriter(verbindung.getOutputStream(), autoflush);
        //Input definieren
        BufferedReader empfaenger = new BufferedReader( new InputStreamReader(verbindung.getInputStream()));

        //Send Request
        sender.println("GET / HTTP/1.1");
        sender.println("Host: "+ hostname);
        sender.println("Connection: Close");
        sender.println();

        //read Response
        boolean loop = true;
        StringBuilder schreiber = new StringBuilder(8096);
        while (loop){
            if (empfaenger.ready()) {
                int i = 0;
                while (i != -1) {
                    i = empfaenger.read();
                    schreiber.append((char) i);
                }
                loop = false;
            }
        }
        System.out.println(schreiber.toString());
        verbindung.close();
    }
}
