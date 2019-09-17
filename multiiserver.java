package tp2.pkg1;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class multiiserver{
	public final static int DEFAULT_PORT = 2222;
	protected int port;
	protected ServerSocket listen_socket;
	protected Socket socket;
	private static int numeroClient = 0;
	public multiiserver(int port) {
		// TODO Auto-generated constructor stub
		System.out.println("Je suis le serveur>");
		this.port=port;
		try {
			listen_socket = new ServerSocket(port);
			while (true ) {
				socket = listen_socket.accept();
				new ListenToClient(socket,numeroClient++).start();
			}	
		}catch (IOException e) {
			System.out.println(e);
		}finally {
			try {
				socket.close();
			}catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main (String [] args) {
		new multiiserver(2222);
	}
}
