import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* Calculating a one-rep max for powerlifting, weightlifting, or bodybuilding */

public class OneRepMax {

	//Declare Variables
    double weight;
    double reps;
    double oneRepMax = 0;
	private JFrame frmOneRepMax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneRepMax window = new OneRepMax();
					window.frmOneRepMax.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OneRepMax() {
		initialize();
	}
		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOneRepMax = new JFrame();
		frmOneRepMax.setTitle("One Rep Max Calculator");
		frmOneRepMax.getContentPane().setBackground(new Color(32, 178, 170));
		frmOneRepMax.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Enter the weight\r\n performed:");
		lblPleaseEnterYour.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPleaseEnterYour.setForeground(new Color(255, 255, 255));
		lblPleaseEnterYour.setBounds(10, 0, 248, 61);
		frmOneRepMax.getContentPane().add(lblPleaseEnterYour);
		
		JTextPane txtWeight = new JTextPane();
		txtWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWeight.setBounds(268, 21, 43, 20);
		frmOneRepMax.getContentPane().add(txtWeight);
		
		JLabel lblEnterTheReps = new JLabel("Enter the reps performed:");
		lblEnterTheReps.setForeground(Color.WHITE);
		lblEnterTheReps.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEnterTheReps.setBounds(32, 41, 230, 40);
		frmOneRepMax.getContentPane().add(lblEnterTheReps);
		
		JTextPane txtReps = new JTextPane();
		txtReps.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReps.setBounds(268, 52, 43, 20);
		frmOneRepMax.getContentPane().add(txtReps);
		
		JLabel lblYourEstimatedOne = new JLabel("Your estimated one rep max is:");
		lblYourEstimatedOne.setForeground(Color.WHITE);
		lblYourEstimatedOne.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblYourEstimatedOne.setBounds(31, 85, 288, 40);
		frmOneRepMax.getContentPane().add(lblYourEstimatedOne);
		
		JTextPane txtCalculate = new JTextPane();
		txtCalculate.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtCalculate.setEditable(false);
		txtCalculate.setBounds(131, 124, 87, 28);
		frmOneRepMax.getContentPane().add(txtCalculate);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//Error check input in case of string
			    while (true){
			      try {
			        weight = Double.parseDouble(txtWeight.getText());
			        break;
			      }
			      catch (NumberFormatException ignore) {
			    	  JOptionPane.showMessageDialog(null, "Invalid Input. Enter a weight (numerically).");
			    	  txtReps.setText(Double.toString(reps = 0));
			    	  txtWeight.setText(Double.toString(weight = 0));
			    	  txtCalculate.setText(Double.toString(0));
			    	  oneRepMax = 0;
			        }
			    }

			    //Error check input in case of string
			    while (true){
			      try {
			        reps = Double.parseDouble(txtReps.getText());
			        break;
			      }
			      catch (NumberFormatException ignore) {
			    	  JOptionPane.showMessageDialog(null, "Invalid Input. Enter the number of reps (numerically).");
			    	  txtReps.setText(Double.toString(reps = 0));
			    	  txtWeight.setText(Double.toString(weight = 0));
			    	  txtCalculate.setText(Double.toString(0));
			    	  oneRepMax = 0;
			      }
			    }
			                                    
			     //Perform one rep max calculation
			    oneRepMax = weight/(1.0278-(.0278*reps));
			    
			    
			    //Display output to the user and error check for reps
			    if(reps < 11 )
			    txtCalculate.setText(String.format("%.0f", oneRepMax) + " lbs.");
			    else
			    	JOptionPane.showMessageDialog(null, "The number of reps cannot exceed 10.");
			    }
			
		});
		btnCalculate.setBounds(10, 174, 100, 37);
		frmOneRepMax.getContentPane().add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Clear Text Boxes and Labels/Set variables to 0.
				txtWeight.setText("");
				txtReps.setText("");
				txtCalculate.setText("");
				reps = 0;
				weight = 0;
				oneRepMax = 0;
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(120, 174, 100, 37);
		frmOneRepMax.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(230, 174, 100, 37);
		frmOneRepMax.getContentPane().add(btnExit);
		frmOneRepMax.setBounds(100, 100, 358, 271);
		frmOneRepMax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
