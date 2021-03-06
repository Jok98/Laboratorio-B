package centrivaccinali;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;


/**
 * <p>ConnessioneServer class.</p>
 *
 * @author Moi Matteo/Alex Rabuffetti
 * La classe permette di comunicare con il server tramite socket
 * e inviando un'istanza della classe contenente una stringa che indica
 * la tipologia di richiesta da elaborare e un oggetto contenente i dati necessari a tale processo
 * @version $Id: $Id
 */
public class ConnessioneServer implements Serializable {
	
	/** Constant <code>serialVersionUID=192873466528L</code> */
	public static final long serialVersionUID = 192873466528L;
	/** Constant <code>socket</code> */
	public static Socket socket ;
	/** Constant <code>oin</code> */
	public static ObjectInputStream oin;
	/** Constant <code>oout</code> */
	public static ObjectOutputStream oout;
	String richiesta;
	public Object obj;


/**
 * <p>Constructor for ConnessioneServer.</p>
 *
 * @param socket a {@link java.net.Socket} object
 * @param richiesta a {@link java.lang.String} object
 * @param obj a {@link java.lang.Object} object
 * @throws java.io.IOException
 */
public ConnessioneServer(Socket socket, String richiesta, Object obj) throws IOException {
		this.socket = socket;
		oout = new ObjectOutputStream(socket.getOutputStream());
		oin = new ObjectInputStream(socket.getInputStream());
		this.richiesta = richiesta;
		this.obj =obj;
	}

	/**
	 * <p>Getter for the field <code>richiesta</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getRichiesta() {
		return richiesta;
	}
	
	/**
	 * <p>Getter for the field <code>obj</code>.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	public Object getObj() {
		return obj;
	}
	
	/**
	 * <p>Setter for the field <code>richiesta</code>.</p>
	 *
	 * @param richiesta a {@link java.lang.String} object
	 * @return a {@link java.lang.String} object
	 */
	public String setRichiesta(String richiesta) {
		return this.richiesta =richiesta;
	}
	
	/**
	 * <p>Setter for the field <code>obj</code>.</p>
	 *
	 * @param obj ?? un oggetto generico che cambia in base al tipo di richiesta
	 * @return obj
	 */
	public  Object setObj(Object obj) {
		return this.obj=obj;
	}
	
	/**
	 * <p>richiestaServer.</p>
	 *
	 * @param cs ?? una istanza della classe ConnessioneServer e che viene inviata al server
	 * @return true/false in base al riuscito invio della richiesta al server
	 * @throws java.lang.ClassNotFoundException
	 * @throws java.io.IOException
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