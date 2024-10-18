
import java.io.*;
import java.net.*;


class TCPServer {

    // ------------------------------------------------------
    public static void main(String[] args) throws Exception {
        int portNumber;
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket;
        Socket connectionSocket;
        BufferedReader inFromClient;
        DataOutputStream outToClient;

        if (args.length != 1) {
            System.out.println("java <program name> <port number>");
            System.exit(1);
        } // End if

        portNumber = Integer.parseInt(args[0]);

        welcomeSocket = new ServerSocket(portNumber);

        while (true) {// Infinite loop
            connectionSocket = welcomeSocket.accept();

            inFromClient = new BufferedReader( new InputStreamReader( connectionSocket.getInputStream() ) );

            outToClient = new DataOutputStream( connectionSocket.getOutputStream() );

            clientSentence = inFromClient.readLine();
            System.out.println("Received from client: " + clientSentence);

            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);

        } // End while

    } // End main


} // End class