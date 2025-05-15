import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

           
            String line = in.readLine();
            System.out.println("Received: " + line);

            String[] numbers = line.split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            int sum = num1 + num2;
            out.println("Sum is: " + sum);

            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
