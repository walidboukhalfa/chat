

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
	private PrintStream ecrire;
	private BufferedReader _userinStream;

	public Client(String IP, int PORT) {
		Socket socket= null;
		try {
			System.out.println("Je suis le client>");
			socket = new Socket(IP, PORT);
			for(;;) {
			BufferedReader lire = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ecrire = new PrintStream(socket.getOutputStream());
                        
			_userinStream = new BufferedReader(new InputStreamReader(System.in));
			String _text_ecrire = _userinStream.readLine();
			ecrire.println(_text_ecrire);
                        System.out.println("Je suis en attente:");
                        
			String txt = lire.readLine();
			System.out.println(" :"+ txt);
			}
			//socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // adresse IP du serveur
		
	}
	public static void main (String []args) {
		new Client("127.2.0.0",2222);
	}
}
