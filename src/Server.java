import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fatjimmy on 17/7/15.
 */
public class Server {
    public static void main(String[] args){
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            ServerSocket server = new ServerSocket(2001);
            Socket socket = server.accept();
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(stream);
            pw = new PrintWriter(socket.getOutputStream(),true);
            String s = br.readLine();
            pw.println("Hi");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                pw.close();
            }catch (Exception e){
            }
        }
    }
}
