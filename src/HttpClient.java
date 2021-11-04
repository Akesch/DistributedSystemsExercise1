import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

//HTTP Head Request for distributed Systems Lecture
public class HttpClient {
    public static  void main(String[] args){
        if (args.length < 1) return;
        URL url;
        try {
            url = new URL("http://stud.fh-wedel.de");
        } catch (MalformedURLException ex){
            ex.printStackTrace();
            return;
        }

        String hostname = url.getHost();
        int port = 80;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to " + socket.getInetAddress());

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("HEADER " + url.getPath() + " HTTP/1.1");

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (UnknownHostException ex) {
            System.out.println("Fehler:" + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("Fehler:" + ex.getMessage());
        }
    }
}
