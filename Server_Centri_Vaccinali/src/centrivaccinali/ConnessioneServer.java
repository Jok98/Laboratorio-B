package centrivaccinali;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * 
 * @author Moi Matteo/Alex Rabuffetti
 * La classe permette di comunicare con il server tramite socket 
 * e inviando un'istanza della classe contenente una stringa che indica 
 * la tipologia di richiesta da elaborare e un oggetto contenente i dati necessari a tale processo
 */
public class ConnessioneServer implements Serializable {
	
	public static final long serialVersionUID = 192873466528L;
	public static Socket socket ;
	public static ObjectInputStream oin;
	public static ObjectOutputStream oout;
	String richiesta;
	public Object obj;


/**
 * 
 * @param socket
 * @param richiesta
 * @param obj
 * @throws IOException
 */
public ConnessioneServer(Socket socket, String richiesta, Object obj) throws IOException {
		this.socket = socket;
		oout = new ObjectOutputStream(socket.getOutputStream());
		oin = new ObjectInputStream(socket.getInputStream());
		this.richiesta = richiesta;
		this.obj =obj;
	}

	/**
	 * 
	 * @return
	 */
	public String getRichiesta() {
		return richiesta;
	}
	
	/**
	 * 
	 * @return
	 */
	public Object getObj() {
		return obj;
	}
	
	/**
	 * 
	 * @param richiesta
	 * @return
	 */
	public String setRichiesta(String richiesta) {
		return this.richiesta =richiesta;
	}
	
	/**
	 * 
	 * @param obj è un oggetto generico che cambia in base al tipo di richiesta 
	 * @return obj
	 */
	public  Object setObj(Object obj) {
		return this.obj=obj;
	}
	
	/**
	 * 
	 * @param cs è una istanza della classe ConnessioneServer e che viene inviata al server
	 * @return true/false in base al riuscito invio della richiesta al server
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static boolean richiestaServer(ConnessioneServer cs) throws ClassNotFoundException, IOException {
		
		try {
			
			oout.writeObject(cs);
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	

}



