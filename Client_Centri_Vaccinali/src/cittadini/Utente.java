package cittadini;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>Utente class.</p>
 *
 * @author Moi Matteo 737574 VA | Rabuffetti Alex 739394 VA
 * @version $Id: $Id
 */
public class Utente implements Serializable {
	private static final long serialVersionUID = 253842189L;
	String nomecvacc, nome, cognome, codfisc, email, userID, password, vacc;
	Date datavacc;
	int idvax;
	/**
	 * Costruttore usato dalla classe IscrizioneVaccinato per registrare
	 * il vaccinato nel database nella tabella cittadini_registrati
	 *
	 * @param nomecvacc a {@link java.lang.String} object
	 * @param nome a {@link java.lang.String} object
	 * @param cognome a {@link java.lang.String} object
	 * @param codfisc a {@link java.lang.String} object
	 * @param datavacc a Date object
	 * @param vacc a {@link java.lang.String} object
	 */
	public Utente(String nomecvacc, String nome, String cognome, String codfisc, Date datavacc, String vacc) {
		this.nomecvacc= nomecvacc;
		this.nome = nome;
		this.cognome = cognome;
		this.codfisc = codfisc;
		this.datavacc = datavacc;
		this.vacc = vacc;
	}
	
	/**
	 * Costruttore usato dalla classe Registrazione per registrare il cittadino
	 * nel database nella tabella vaccinati_+nomeCentroVax
	 *
	 * @param nomecvacc a {@link java.lang.String} object
	 * @param nome a {@link java.lang.String} object
	 * @param cognome a {@link java.lang.String} object
	 * @param codfisc a {@link java.lang.String} object
	 * @param email a {@link java.lang.String} object
	 * @param userID a {@link java.lang.String} object
	 * @param password a {@link java.lang.String} object
	 * @param idvax a int
	 */
	public Utente(String nomecvacc,String nome, String cognome, String codfisc, String email, String userID, String password, int idvax) {
		this.nomecvacc= nomecvacc;
		this.nome = nome;
		this.cognome = cognome;
		this.codfisc = codfisc;
		this.email = email;
		this.userID = userID;
		this.password = password;
		this.idvax = idvax;
	}

	/**
	 * <p>getCentroVax.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getCentroVax() {
		return this.nomecvacc;
	}
	
	/**
	 * <p>Getter for the field <code>nome</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * <p>Getter for the field <code>cognome</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getCognome() {
		return this.cognome;
	}
	/**
	 * <p>Getter for the field <code>codfisc</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getCodfisc() {
		return this.codfisc;
	}
	/**
	 * <p>Getter for the field <code>datavacc</code>.</p>
	 *
	 * @return a java.sql.Date object
	 */
	public java.sql.Date getDatavacc() {
		return this.datavacc;
	}
	/**
	 * <p>Getter for the field <code>vacc</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getVacc() {
		return this.vacc;
	}
	/**
	 * <p>Getter for the field <code>idvax</code>.</p>
	 *
	 * @return a int
	 */
	public int getIdvax() {
		return this.idvax;
	}
	/**
	 * <p>Getter for the field <code>email</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * <p>Getter for the field <code>userID</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getUserID() {
		return this.userID;
	}
	/**
	 * <p>Getter for the field <code>password</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getPassword() {
		return this.password;
		
	}
	
}

