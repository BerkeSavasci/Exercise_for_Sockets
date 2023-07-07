import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerClient {
    private static final int PORT_NUMBER = 7777;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            try {
                openServer();
            } catch (IOException e) {
                System.err.println("Can't open the server");
            }
        } else if (args.length > 1) {
            System.out.println("Connecting to: " + args[0] + "at Port: " + args[1]);
            clientConnect(args[0], args[1]);
        }
    }

    static void openServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)){

            System.out.println("Server opened listening on PORT: " + PORT_NUMBER);

            Socket clientSocket = serverSocket.accept(); //accept the client to server
            System.out.println("Connection established");
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeUTF("Send me your Name.");
            try {
                Serializer serializer = new Serializer();
                String message = serializer.deserializeGetStringPDU(clientSocket.getInputStream());
                System.out.println("String read successfully! " + message);
                dos.writeUTF("Now send me your Matrikel NO.");
            } catch (IOException e) {
                System.err.println("Error! Can't read String");
            }
            try {
                Serializer serializer = new Serializer();
                int message = serializer.deserializeGetIntPDU(clientSocket.getInputStream());
                System.out.println("Integer read successfully! " + message);
                dos.writeUTF("Now send me a Byte");

            } catch (IOException e) {
                System.err.println("Error! Can't read Integer");
            }

            try {
                Serializer serializer = new Serializer();
                byte message = serializer.deserializeGetBytePDU(clientSocket.getInputStream());
                System.out.println("Byte read successfully! " + message);

            } catch (IOException e) {
                System.err.println("Error! Can't read Byte");
            }

        } catch (IOException e) {
            System.err.println("Error caught while opening server");
        }
    }

    static void clientConnect(String host, String input) {
        int port = Integer.parseInt(input);

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server on PORT: " + PORT_NUMBER);

            Message message = new Message(socket.getInputStream(), socket.getOutputStream());
            Thread t = new Thread(message);

            t.start();

        } catch (IOException e) {
            System.err.println("Error while connecting to server");
        }

    }
}