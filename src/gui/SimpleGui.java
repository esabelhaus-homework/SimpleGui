package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimpleGui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Empty constructor
	SimpleGui() {}
	
	// create a global frame to be used by button for refocusing
	protected static JFrame frame;
    
	// Main
	public static void main(String[] argv) {
	    // create JButton object
	    final JButton ping = new JButton("PING");
	   
	    // add listener to the button
	    ping.addActionListener(new ActionListener(){
		 	@Override
			public void actionPerformed(ActionEvent e) {
		 		// open notice with pong when button pressed
		 		// specify object to return to once OK button pressed on message
				JOptionPane.showMessageDialog(frame, "PONG");
				
				// return focus to the frame
				return;
			}
		});
	   
	   // Create and set up the window.
       JFrame frame = new JFrame();
       
       // close when exit button pressed
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // add layout
       frame.setLayout (new BorderLayout ());
       
       // add ping button to frame
       frame.add(ping, BorderLayout.CENTER);
       
       // set preferred dimensions of frame
       frame.setPreferredSize(new Dimension(100, 100));
       
       // place frame centered on screen
       frame.setLocationRelativeTo(null);  
       
       //Display the window.
       frame.pack();
       frame.setVisible(true);
   }
}