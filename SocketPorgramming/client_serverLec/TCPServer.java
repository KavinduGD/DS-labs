package SocketPorgramming.client_serverLec;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        String clientText;
        String capitalizedText;

        ServerSocket welcomeSocket= new ServerSocket( 6789);
        
        while(true){
            Socket connectionSocket= welcomeSocket.accept();
            
            //input stream
            BufferedReader inFromClient= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            //output stream
            DataOutputStream outToClient= new DataOutputStream(connectionSocket.getOutputStream());
          
            clientText=inFromClient.readLine();
            System.out.println("client says: "+clientText);
            
            capitalizedText=clientText.toUpperCase();
            
            outToClient.writeBytes(capitalizedText+'\n');
            outToClient.flush();

        }
    }
    
}
