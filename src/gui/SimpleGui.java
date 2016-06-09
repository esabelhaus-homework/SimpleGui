package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimpleGui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JFrame frame;
    
	public static void main(String[] argv) {
	   final JButton ping = new JButton("PING");
	   
	   ping.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "PONG");
				return;
			}
		});
	   
	   JMenuBar menuBar = new JMenuBar();
	   menuBar.add(ping);
	   
	   //Create and set up the window.
       JFrame frame = new JFrame("Ping Pong");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout (new BorderLayout ());
       frame.add(menuBar, BorderLayout.CENTER);
       //Display the window.
       frame.pack();
       frame.setVisible(true);
   }
}