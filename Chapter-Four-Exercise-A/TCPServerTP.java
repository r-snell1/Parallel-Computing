import java.io.*;
import java.net.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TCPServerTP {
    public static void main(String[] args) throws Exception {
        int portNumber;

        if (args.length != 1) {
            System.out.println("java <program name> <port number>");
            System.exit(1);
        }

        portNumber = Integer.parseInt(args[0]);

        // Create a thread pool with 5 threads
        ExecutorService connectionPool = Executors.newFixedThreadPool(5);

        // Create the ServerSocket (only one for the server)
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        System.out.println("Server is listening on port: " + portNumber);

        while (true) {
            // Accept client connections and submit to thread pool
            Socket connectionSocket = welcomeSocket.accept();
            connectionPool.submit(new ServerTP(connectionSocket));
        }
    }
}

class ServerTP implements Runnable {
    private Socket connectionSocket;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private String clientSentence;
    private String capitalizedSentence;

    public ServerTP(Socket socket) {
        this.connectionSocket = socket;
    }

    @Override
    public void run() {
        try {
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // Read client message
            clientSentence = inFromClient.readLine();
            System.out.println("Received from client: " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } //finally {}
    }
}