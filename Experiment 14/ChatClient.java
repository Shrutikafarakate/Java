import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server!");

            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            while (true) {
                System.out.print("You: ");
                clientMsg = inputFromConsole.readLine();
                outputToServer.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    break;
                }

                serverMsg = inputFromServer.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
