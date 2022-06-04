package centrivaccinali;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <p>OperatoriForm class.</p>
 *
 * @author jokmo
 * @version $Id: $Id
 */
public class OperatoriForm {

	/** Constant <code>frmAppOperatori</code> */
	public static JFrame frmAppOperatori;
	/** Constant <code>CentriVax</code> */
	public static CentriVaccinali CentriVax = new CentriVaccinali();
	/** Constant <code>window</code> */
	public static OperatoriForm window = new OperatoriForm();
	/**
	 * Launch the application.
	 *
	 * @param args an array of {@link java.lang.String} objects
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatoriForm window = new OperatoriForm();
					window.frmAppOperatori.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatoriForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppOperatori = new JFrame();
		frmAppOperatori.setResizable(false);
		frmAppOperatori.setTitle("App Operatori - Centro Vaccinale");
		frmAppOperatori.setBounds(100, 100, 450, 214);
		frmAppOperatori.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppOperatori.getContentPane().setLayout(null);
		
		//Start Button Iscrizione centro vaccinale
		JButton btnNewButton = new JButton("Registrazione centro vaccinale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IscrizioneCentroVax.frame.setVisible(true);
				window.frmAppOperatori.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(0, 0, 217, 130);
		frmAppOperatori.getContentPane().add(btnNewButton);
		//End Button Iscrizione centro vaccinale
		
		//Start Button btnIscrizioneVax
		JButton btnIscrizioneVax = new JButton("Registrazione vaccinato");
		btnIscrizioneVax.setBounds(217, 0, 217, 130);
		btnIscrizioneVax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IscrizioneVaccinato.frame.setVisible(true);
				window.frmAppOperatori.setVisible(false);
			}
		});
		frmAppOperatori.getContentPane().add(btnIscrizioneVax);
		//End Button btnIscrizioneVax
		
		//Start Button btnBack
		JButton btnBack = new JButton("Indierto");
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				CentriVax.frmProgettoCentriVaccinali.setVisible(true);
				window.frmAppOperatori.dispose();
			}
		});
		btnBack.setBounds(168, 141, 101, 32);
		frmAppOperatori.getContentPane().add(btnBack);
		//End Button btnBack
	}

}
