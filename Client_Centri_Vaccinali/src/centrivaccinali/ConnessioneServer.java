package centrivaccinali;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import cittadini.CittadiniForm;

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
	public static Socket socket = CentriVaccinali.socket;
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
	 * @param obj è un oggetto generico che cambia in base al tipo di richiesta
	 * @return obj
	 */
	public  Object setObj(Object obj) {
		return this.obj=obj;
	}
	
	/**
	 * <p>richiestaServer.</p>
	 *
	 * @param cs è una istanza della classe ConnessioneServer e che viene inviata al server
	 * @return true/false in base al riuscito invio della richiesta al server
	 * @throws java.lang.ClassNotFoundException
	 * @throws java.io.IOException
	 */
	public static boolean richiestaServer(ConnessioneServer cs) throws ClassNotFoundException, IOException {
		
		try {
			
			oout.writeObject(cs);
			ricezioneServer();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

	/**
	 * Legge tramite socket un'istanza della classe ConnessioneServer contenente
	 *  i dati e il tipo di richiesta elaborata dal server server
	 */
	public static void ricezioneServer() {
		
		try {
			ConnessioneServer return_cs =  (ConnessioneServer) oin.readObject();
			System.out.println("La risposta del server per la richiesta di  :"+return_cs.getRichiesta());
	    	
	    	switch(return_cs.getRichiesta()) {
	    	case "LogIn" :
	    		HashMap<String, String> datiLogIn = (HashMap<String, String>) return_cs.getObj();
	    		CittadiniForm.LogIn_Result(datiLogIn.get("logInResult"),datiLogIn.get("centroVax"));
	    		System.out.println("Risultato log in : "+datiLogIn.get("logInResult"));
	    		datiLogIn.clear();
	    	break;	
	    	case "IdUnivoco" :
	    		IscrizioneVaccinato.IdUnivoco = (int) return_cs.getObj();
	    		System.out.println("id univoco del vaccinato : "+(int) return_cs.getObj());
	    	break;
	    	case "centroVaxRegistrato" :
	    		showMessageDialog(null,"Centro vaccinale registrato");
	    	break;
	    	case"cittadinoRegistrato":
	    		showMessageDialog(null,"Cittadino registrato");
	    	break;
	    	case"eventiAvversiRegistrati":
	    		showMessageDialog(null,"Eventi avversi registrati");
	    	break;
	    	}
	    	socket.close();
		} catch (ClassNotFoundException | IOException e) {
			//e.printStackTrace();
		}
			
	}
	

	/**
	 * <p>cercaCentroVaccinale.</p>
	 * @param cs a {@link centrivaccinali.ConnessioneServer} object
	 * @return cvlis lista di centri vaccinali ottenuta dopo la query effettuata su db
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CentroVaccinale> cercaCentroVaccinale(ConnessioneServer cs) {
		ArrayList<CentroVaccinale> cvlis = new ArrayList<CentroVaccinale>();
		try {
			oout.writeObject(cs);
			
			cvlis = (ArrayList<CentroVaccinale>) oin.readObject();
			socket.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		if(cvlis.isEmpty()) {
			showMessageDialog(null,"Nessun centro vaccinale trovato");
		}else showMessageDialog(null,"Ricerca effettuata con successo");

		return cvlis;
	}
}



