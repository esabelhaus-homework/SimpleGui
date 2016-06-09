package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

// create a slice object to store the color and value
class Slice {
   double value;
   Color color;
   public Slice(double value, Color color) {  
      this.value = value;
      this.color = color;
   }
}

// create JComponent to store slices
class MyComponent extends JComponent {
   private static final long serialVersionUID = 1L;
   Slice[] slices = { 
		   new Slice(5, Color.BLACK), 
		   new Slice(35, Color.CYAN),
		   new Slice(20, Color.MAGENTA), 
		   new Slice(15, Color.YELLOW) 
   };
   
   MyComponent() {}
   
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
   
   void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, 
         startAngle, arcAngle);
         curValue += slices[i].value;
      }
   }
}

public class SimpleGui {
   public static void main(String[] argv) {
	  //Create and set up the window.
      JFrame frame = new JFrame("Pie Chart Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout (new BorderLayout ());
      frame.setPreferredSize(new Dimension(400,400));
      frame.add(new MyComponent(), BorderLayout.CENTER);
      
      //Display the window.
      frame.pack();
      frame.setVisible(true);
   }
}