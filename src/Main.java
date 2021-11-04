import java.io.IOException;
import java.net.Socket;

public class Main{
    public static void main (String[] args) throws IOException {
        Socket socket = new Socket("stud.fh-wedel.de", 80);
    }
}