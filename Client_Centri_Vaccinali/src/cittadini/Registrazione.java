package cittadini;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import centrivaccinali.CentriVaccinali;
import centrivaccinali.ConnessioneServer;

/**
 * <p>Registrazione class.</p>
 *
 * @author Moi Matteo 737574 VA | Rabuffetti Alex 739394 VA
 * @version $Id: $Id
 */
public class Registrazione {

	static JFrame frmRegistrazioneCittadino;
	private static JTextField tfNome;
	private static JTextField tfCognome;
	private static JTextField tfCodiceFiscale;
	private static JTextField tfEmail;
	private static JTextField tfUserID;
	private static JPasswordField passwordField;
	private static JTextField tfIDUnivocoVax;
	static JTextField tf_NomeCentroVax;
	static Registrazione window;
	/**
	 * Launch the application.
	 *
	 * @param args an array of {@link java.lang.String} objects
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Registrazione();
					window.frmRegistrazioneCittadino.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrazioneCittadino = new JFrame();
		frmRegistrazioneCittadino.setResizable(false);
		frmRegistrazioneCittadino.setTitle("Registrazione cittadino");
		frmRegistrazioneCittadino.setBounds(100, 100, 450, 326);
		frmRegistrazioneCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrazioneCittadino.getContentPane().setLayout(null);
		

		//start lblNome
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 11, 112, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblNome);
		
		//start lblCognome
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setBounds(10, 42, 112, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblCognome);
		
		//start tfNome
		tfNome = new JTextField();
		tfNome.setBounds(174, 8, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		//start tfCognome
		tfCognome = new JTextField();
		tfCognome.setBounds(174, 39, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfCognome);
		tfCognome.setColumns(10);
		
		//start tfCodiceFiscale
		tfCodiceFiscale = new JTextField();
		tfCodiceFiscale.setBounds(174, 70, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfCodiceFiscale);
		tfCodiceFiscale.setColumns(10);
		
		//start lblCodicefiscale
		JLabel lblCodicefiscale = new JLabel("Codice Fiscale :");
		lblCodicefiscale.setBounds(10, 73, 112, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblCodicefiscale);
		
		//start tfEmail
		tfEmail = new JTextField();
		tfEmail.setBounds(174, 101, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		//start lblEmail
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 104, 112, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblEmail);
		
		//start tfUserID
		tfUserID = new JTextField();
		tfUserID.setBounds(174, 132, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfUserID);
		tfUserID.setColumns(10);
		
		//start lblUserID
		JLabel lblUserID = new JLabel("User ID");
		lblUserID.setBounds(10, 135, 46, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblUserID);
		
		//start lblPassword
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 166, 112, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblPassword);
		
		//start passwordField
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 163, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(passwordField);
		
		//start lblIDUnicoVax
		JLabel lblIDUnicoVax = new JLabel("Id univoco vaccinazione :");
		lblIDUnicoVax.setBounds(10, 197, 150, 14);
		frmRegistrazioneCittadino.getContentPane().add(lblIDUnicoVax);
		
		//start tfIDUnivocoVax
		tfIDUnivocoVax = new JTextField();
		tfIDUnivocoVax.setBounds(174, 194, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tfIDUnivocoVax);
		tfIDUnivocoVax.setColumns(10);
		
		//Start btnRegistra
		/* l'actionPerformed controlla i dati inseriti dall'utente e 
		li utilizza per creare una nuova istanza della classe user per inserire così 
		l'utente nella tabella dei cittadini_registrati presente nel db */
		JButton btnRegistra = new JButton("Registrati");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean isValid = true;
				String password,NomeCentroVax,Nome,Cognome,CodiceFiscale,Email,UserID;
				Integer IDUnivocoVax;
				NomeCentroVax =	tf_NomeCentroVax.getText().replaceAll(" ", "");
				Nome = tfNome.getText().replaceAll(" ", "").replaceAll("[0-9]","");
				Cognome = tfCognome.getText().replaceAll(" ", "").replaceAll("[0-9]","");
				CodiceFiscale = tfCodiceFiscale.getText().replaceAll(" ", "");
				Email = tfEmail.getText().replaceAll(" ", "");
				UserID = tfUserID.getText().replaceAll(" ", "");
				password = String.valueOf(passwordField.getPassword());
				
				try {
					IDUnivocoVax = Integer.valueOf(tfIDUnivocoVax.getText().replaceAll(" ", ""));
				} catch (NumberFormatException a) {
					showMessageDialog(null,"Formato dell'id univoco vaccinazione non valido");
				}
				
				if (NomeCentroVax.isEmpty() || Nome.isEmpty() || Cognome.isEmpty() || CodiceFiscale.isEmpty()  
						|| Email.toString().isEmpty() || !(Email.contains("@")) || UserID.isEmpty() || password.isEmpty())	isValid = false;	
				if (isValid == true) {
				
				Utente user = new Utente(tf_NomeCentroVax.getText(),tfNome.getText(), tfCognome.getText(), tfCodiceFiscale.getText(), tfEmail.getText(),
						tfUserID.getText(), password, Integer.valueOf(tfIDUnivocoVax.getText()));
				try {
					//System.out.println("centyro vax rilevato dal client "+tfCentroVaxSelezionato.getText());
					Socket socket = CentriVaccinali.openSocket();
					ConnessioneServer cs = new ConnessioneServer(socket,"registrazioneCittadino", user);
					
					System.out.println(ConnessioneServer.richiestaServer(cs));
				} catch (IOException | ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
				CittadiniForm.frmCittadini.setVisible(true);
				frmRegistrazioneCittadino.dispose();
				}
				else {
					showMessageDialog(null,"Errore compilazione campi");
				}
			}
		});
		btnRegistra.setBounds(174, 248, 89, 23);
		frmRegistrazioneCittadino.getContentPane().add(btnRegistra);
		//end btnRegistra
		
		//Start btnBack
		JButton btnBack = new JButton("Indietro");
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CittadiniForm.frmCittadini.setVisible(true);
				CleanAll();
				frmRegistrazioneCittadino.dispose();
			}
		});
		btnBack.setBounds(10, 248, 89, 23);
		frmRegistrazioneCittadino.getContentPane().add(btnBack);
		//end btnBack
		
		
		//Start lbl_CentroVax
		JLabel lbl_CentroVax = new JLabel("Centro vaccinale selezionato :");
		lbl_CentroVax.setBounds(10, 223, 150, 14);
		frmRegistrazioneCittadino.getContentPane().add(lbl_CentroVax);
		//end lbl_CentroVax
		
		//Start tf_NomeCentroVax
		tf_NomeCentroVax = new JTextField();
		tf_NomeCentroVax.setEditable(false);
		tf_NomeCentroVax.setBounds(174, 220, 250, 20);
		frmRegistrazioneCittadino.getContentPane().add(tf_NomeCentroVax);
		tf_NomeCentroVax.setColumns(10);
		//End tf_NomeCentroVax
		
		//Start btnPulisci
		JButton btnPulisci = new JButton("Pulisci");
		btnPulisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CleanAll();
			}
		});
		btnPulisci.setBounds(335, 248, 89, 23);
		frmRegistrazioneCittadino.getContentPane().add(btnPulisci);
		//end btnPulisci
	}
	
	static void CleanAll() {
		
		tfNome.setText("");
		tfCognome.setText("");
		tfCodiceFiscale.setText("");
		tfEmail.setText("");
		tfUserID.setText("");
		passwordField.setText("");
		tfIDUnivocoVax.setText("");
		tf_NomeCentroVax.setText("");
		
	}
}
