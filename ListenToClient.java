package tp2.pkg1;
import java.io.*;
import java.net.*;
public class ListenToClient extends Thread {
	private Socket socket;
	private int clientId;
	protected BufferedReader message_recu_client;
	protected PrintStream ecrire_auClient;
	public ListenToClient (Socket socket, int clientId) {
		this.socket = socket;
		this.clientId = clientId;
	}
	@Override
	public void run() {
		try {
			message_recu_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ecrire_auClient = new PrintStream(socket.getOutputStream());
			execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void execute() {
		String line;
		BufferedReader ceque_je_dois_envoyer = new BufferedReader(new InputStreamReader(System.in));
		String lineaecrire;
		try {
			while(true) {
				line = message_recu_client.readLine();
				System.out.println(">"+line);
				System.out.print("> ");
                                
				lineaecrire = ceque_je_dois_envoyer.readLine();
				ecrire_auClient.println(">"+"("+clientId+")"+lineaecrire);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}