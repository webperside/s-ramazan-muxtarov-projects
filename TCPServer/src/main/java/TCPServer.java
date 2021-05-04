import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        // TCPServer app - 6482
        // app -> Portal - 1234
        ServerSocket serverSocket = new ServerSocket(1234);
        // Youtube livestream

        while(true){
            Socket connection = serverSocket.accept();

            InputStream is = connection.getInputStream();
//            InputStreamReader reader = new InputStreamReader(is);
            DataInputStream dis = new DataInputStream(is);
//            dis.read
//            BufferedReader br = new BufferedReader(reader);

//            System.out.println(+ br.read());

            ByteBuffer imageBytes = ByteBuffer.allocate(dis.readInt());

            dis.readFully(imageBytes.array());

//            int b = dis.read();
//            while(b != -1){
//                imageBytes.put((byte) b);
//                b = dis.read();
//            }

//            while(dis.available() > 0){
//                imageBytes.put(dis.readByte());
//            }

            writeBytesInfoFile("image-from-client.png",imageBytes.array());
        }
    }

    public static void writeBytesInfoFile(String fileName, byte[] content) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, content);
    }
}
