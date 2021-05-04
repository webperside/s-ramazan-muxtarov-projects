import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        // localhost -> 127.0.0.1
        // daxili ip -> 192.168.1.111, 192.168.1.112
        // global ip -> 185.81.80.249
        Socket socket = new Socket("localhost",1234);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(os);
        byte[] imageBytes = readBytesFromFile("client-image.png");

        System.out.println("bytes length " + imageBytes.length);

        dataOutputStream.writeInt(imageBytes.length); // 10000
        dataOutputStream.write(imageBytes);
        dataOutputStream.flush();
        socket.close();
    }

    public static byte[] readBytesFromFile(String fileName) throws IOException{
        Path filePath = Paths.get(fileName);
        return Files.readAllBytes(filePath);
    }
}
