
import java.io.*;
import java.net.*;

class TCPClient {

    // ------------------------------------------------------
    public static void main(String[] args) throws Exception {
        String ipAddress;
        int portNumber;
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser;
        Socket clientSocket;
        DataOutputStream outToServer;
        BufferedReader inFromServer;

        if (args.length != 2) {
            System.out.println("java <program name> <IP address of server> <port number of server>");
            System.exit(1);
        } // End if

        ipAddress = args[0];
        portNumber = Integer.parseInt(args[1]);

        inFromUser = new BufferedReader( new InputStreamReader(System.in) );

        clientSocket = new Socket(ipAddress, portNumber);

        outToServer = new DataOutputStream( clientSocket.getOutputStream() );

        inFromServer = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );

        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();
    } // End main


}//end class
