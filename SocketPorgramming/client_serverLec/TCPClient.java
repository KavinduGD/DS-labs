package SocketPorgramming.client_serverLec;
import java.net.*; 
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class TCPClient {
    public static void main(String[] args) throws Exception{

        String text;
        String modifiedText;

        Socket clientSocket= new Socket("localhost", 6789);

        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //read a line from console
        text= inFromUser.readLine();
        System.out.println("you entered- "+ text);

        //output stream eka write karanwa
        outToServer.writeBytes(text+'\n');
        outToServer.flush();

        System.out.println("output stream sent");

        //read the modified text from server
        modifiedText=inFromServer.readLine();

        System.out.println("From server(Modifies text) - "+ modifiedText);

        clientSocket.close();

    }
    
}
